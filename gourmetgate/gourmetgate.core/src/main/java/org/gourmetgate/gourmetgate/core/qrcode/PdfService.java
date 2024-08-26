package org.gourmetgate.gourmetgate.core.qrcode;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.eclipse.scout.rt.platform.service.IService;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class PdfService implements IService {

  public PDDocument createPdfWithImages(BufferedImage[] bufferedImages) throws IOException {
    PDDocument document = new PDDocument();

    int pageAmount = calculatePageAmount(bufferedImages.length);
    int imagePerRow = calculateImagesPerRow();
    int rowsPerPage = calculateImageRowsPerPage();

    for (int pageCount = 0; pageCount < pageAmount; pageCount++) {
      PDPage page = new PDPage(PDRectangle.A4);
      document.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);

      for (int rowCount = 0; rowCount < rowsPerPage; rowCount++) {
        for (int imageCount = 0; imageCount < imagePerRow; imageCount++) {
          int imageIndex = calculateCurrentImageIndex(pageCount, rowCount, imageCount);
          if (imageIndex >= bufferedImages.length) {
            break;
          }
          PDImageXObject image = JPEGFactory.createFromImage(document, bufferedImages[imageIndex]);
          placeImage(image, contentStream, rowCount, imageCount);
        }
      }
      contentStream.close();
    }
    return document;
  }

  private void placeImage(PDImageXObject image, PDPageContentStream contentStream, int rowCount, int imageCount) throws IOException {
    PDRectangle bounds = PDRectangle.A4;
    float x = imageCount * getConfiguredImageSize();
    float y = bounds.getHeight() - ((rowCount + 1) * getConfiguredImageSize());
    contentStream.drawImage(image, x, y, getConfiguredImageSize(), getConfiguredImageSize());
  }

  private int calculateCurrentImageIndex(int pageCount, int rowCount, int imageCount) {
    int currentPage = (rowCount) * calculateImagesPerRow();
    int pagesBefore = (pageCount) * calculateImageRowsPerPage() * calculateImagesPerRow();
    return imageCount + currentPage + pagesBefore;
  }

  private int calculatePageAmount(int pictures) {
    return (int) Math.ceil((double) pictures / (calculateImagesPerRow() * calculateImageRowsPerPage()));
  }

  private int calculateImageRowsPerPage() {
    return (int) (PDRectangle.A4.getHeight() / getConfiguredImageSize());
  }

  private int calculateImagesPerRow() {
    return (int) (PDRectangle.A4.getWidth() / getConfiguredImageSize());
  }

  protected int getConfiguredImageSize() {
    return 190;
  }
}

