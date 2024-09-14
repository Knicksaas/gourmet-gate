import {InfoPage, InfoTileBean} from "../index";

export class ScanQrCodeInfoPage extends InfoPage {
  routeRef = 'userGuide'

  protected override _createInfoTileBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-qr-code',
      title: 'QR-Code scannen',
      description: 'Scannen Sie den QR-Code auf Ihrem Tisch, um mit einer neue Bestellung zu starten.',
      infoColorClass: 'info-color-blue'
    }
  }
}
