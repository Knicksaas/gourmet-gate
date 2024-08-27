package org.gourmetgate.gourmetgate.core.table;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.core.order.OrderService;
import org.gourmetgate.gourmetgate.core.qrcode.PdfService;
import org.gourmetgate.gourmetgate.core.qrcode.QrCodeService;
import org.gourmetgate.gourmetgate.data.table.HallFormDataDo;
import org.gourmetgate.gourmetgate.data.table.ITableRepository;
import org.gourmetgate.gourmetgate.data.table.TableDo;
import org.gourmetgate.gourmetgate.data.table.TableStatus;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TableService implements IService {

  public void regenerateTableLayout() {
    int tableRows = BEANS.get(TableRowCountParameter.class).getValue();
    int tablesPerRow = BEANS.get(TablesPerRowParameter.class).getValue();
    long tablesRequred = (long) tableRows * tablesPerRow;

    // Ensure corret table amount
    long currentExistingTables = BEANS.get(ITableRepository.class).getTableCount();
    if (currentExistingTables < tablesRequred) {
      createTables(tablesRequred - currentExistingTables);
    }

    // Rename tables
    renameTables(tablesRequred);
  }

  protected void createTables(long amount) {
    LongStream.range(0, amount)
      .mapToObj(val -> String.format("#%s", val))
      .map(text -> BEANS.get(TableDo.class)
        .withName(text)
        .withStatusEnum(TableStatus.ACTIVE))
      .forEach(dataObject -> BEANS.get(ITableRepository.class).create(dataObject));
  }

  protected void renameTables(long amount) {
    AtomicLong counter = new AtomicLong(1);
    BEANS.get(ITableRepository.class).all(amount)
      .map(dataObject -> dataObject.withName(String.format("#%s", counter.getAndIncrement())))
      .forEach(dataObject -> BEANS.get(ITableRepository.class).update(dataObject.getTableId(), dataObject));
  }

  protected long getActiveTableCount() {
    return (long) BEANS.get(TableRowCountParameter.class).getValue() * BEANS.get(TablesPerRowParameter.class).getValue();
  }

  public HallFormDataDo getHallFormData() {
    Stream<TableDo> tableStream = BEANS.get(ITableRepository.class).all(getActiveTableCount())
      .map(table -> table.withOpenOrders(BEANS.get(OrderService.class).getOpenOrderCountForTable(table.getTableId())));
    return BEANS.get(HallFormDataDo.class)
      .withTables(tableStream.toList())
      .withTableRowCount(BEANS.get(TableRowCountParameter.class).getValue())
      .withTablesPerRowCount(BEANS.get(TablesPerRowParameter.class).getValue());
  }

  public PDDocument getTableQrCodesAsPdf() {
    BufferedImage[] tableQrCodes = BEANS.get(ITableRepository.class).all()
      .map(tableDo -> BEANS.get(QrCodeService.class).generateQrCode(buildTableLink(tableDo.getTableId()), tableDo.getName()))
      .toArray(BufferedImage[]::new);
    try {
      return BEANS.get(PdfService.class).createPdfWithImages(tableQrCodes);
    } catch (IOException e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  protected String buildTableLink(String tableId) {
    String baseUrl = "http://HACKBOOK:8084/";
    return baseUrl + "api/order/?tableId=" + tableId;
  }

  public boolean tableExists(String tableId) {
    return BEANS.get(ITableRepository.class).getById(tableId).isPresent();
  }

  public String getTableName(String tableId) {
    return BEANS.get(ITableRepository.class).getById(tableId)
      .map(TableDo::getName)
      .orElse(null);
  }
}
