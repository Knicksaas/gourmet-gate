import {InfoForm, InfoTileBean} from "../index";
import {scout} from "@eclipse-scout/core";

export class ScanQrCodeInfoForm extends InfoForm {

  protected override _load(): JQuery.Promise<InfoTileBean> {
    return $.resolvedPromise(scout.create(InfoTileBean, {
      iconClass: 'gg-icon-qr-code',
      title: 'QR-Code scannen',
      description: 'Scannen Sie den QR-Code auf Ihrem Tisch, um mit einer neue Bestellung zu starten.',
      infoColorClass: 'info-color-blue'
    }));
  };
}
