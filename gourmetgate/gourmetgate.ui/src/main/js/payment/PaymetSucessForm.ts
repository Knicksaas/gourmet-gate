import {InfoTile, InfoTileBean} from "../index";

export class PaymentSuccessTile extends InfoTile {

  protected override _createBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-check',
      title: 'Bestellung erfolgreich',
      description: 'Die Bestellung wurde an die Küche übermittelt'
    }
  }
}
