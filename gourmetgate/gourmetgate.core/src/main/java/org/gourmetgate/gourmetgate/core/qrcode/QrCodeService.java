package org.gourmetgate.gourmetgate.core.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.DefaultRuntimeExceptionTranslator;
import org.eclipse.scout.rt.platform.service.IService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class QrCodeService implements IService {

  public BufferedImage generateQrCode(String url, String description) {
    try {
      Map<EncodeHintType, Object> hints = new HashMap<>();
      hints.put(EncodeHintType.MARGIN, getConfiguredQrCodeMargin());

      BitMatrix matrix = new MultiFormatWriter()
        .encode(url, BarcodeFormat.QR_CODE, getConfiguredQrCodeSize(), getConfiguredQrCodeSize(), hints);
      BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
      return addDescription(image, description);
    } catch (WriterException e) {
      throw BEANS.get(DefaultRuntimeExceptionTranslator.class).translate(e);
    }
  }

  protected BufferedImage addDescription(BufferedImage image, String description) {
    Graphics g = image.getGraphics();
    Font font = g.getFont().deriveFont(30f);
    g.setColor(Color.BLACK);
    int textYPos = getConfiguredQrCodeSize() - (getConfiguredQrCodeMargin() / 2);
    drawCenteredString(g, description, image.getWidth(), textYPos, font);
    g.dispose();
    return image;
  }

  private void drawCenteredString(Graphics g, String text, int width, int y, Font font) {
    FontMetrics metrics = g.getFontMetrics(font);
    int x = (width - metrics.stringWidth(text)) / 2;
    int middleY = y - metrics.getHeight() / 2;
    g.setFont(font);
    g.drawString(text, x, middleY);
  }

  protected int getConfiguredQrCodeSize() {
    return 400;
  }

  protected int getConfiguredQrCodeMargin() {
    return 4;
  }

}
