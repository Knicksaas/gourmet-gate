package org.gourmetgate.gourmetgate.core.printable;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.order.IOrderRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionOptionRepository;
import org.gourmetgate.gourmetgate.data.orderposition.IOrderPositionRepository;
import org.gourmetgate.gourmetgate.data.printable.PrintableOrderDo;

import java.util.List;
import java.util.stream.Collectors;

public class PrintableOrderService implements IService {

  public List<PrintableOrderDo> getUnprintedOrders() {
    List<PrintableOrderDo> unprintedOrders = BEANS.get(IOrderRepository.class).getUnprintedOrders().toList();

    // Add order positions
    unprintedOrders.forEach(order -> order
      .withOrderPositions(BEANS.get(IOrderPositionRepository.class).getPrintableOrderPositionsByOrderId(order.getPrintableOrderId()).toList()));

    // Add order positions option text
    unprintedOrders.stream()
      .map(PrintableOrderDo::getOrderPositions)
      .flatMap(List::stream)
      .forEach(orderPosition -> orderPosition.withOptionText(
        BEANS.get(IOrderPositionOptionRepository.class).getSelectedOrderPositionOptionNames(orderPosition.getPrintableOrderPositionId())
          .collect(Collectors.joining(", "))));

    return unprintedOrders;
  }

  public void markOrdersAsPrinted(List<String> orderIds) {
    BEANS.get(IOrderRepository.class).markOrdersAsPrinted(orderIds);
  }
}
