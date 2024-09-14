import {InfoPage, InfoTileBean} from "../index";
import {EnumObject} from "@eclipse-scout/core";

export type PaymentStatus = EnumObject<typeof PaymentStateInfoPage.PaymentStatus>;

export class PaymentStateInfoPage extends InfoPage {
  routeRef = 'paymentState'
  state: PaymentStatus;

  static PaymentStatus = {
    PENDING: 0,
    SUCCESS: 10,
    FAILED: 100
  } as const;

  setPaymentState(state: PaymentStatus) {
    this.state = state;
    this.infoTile.setBean(this._createBeanForState(state));
  }

  protected _createBeanForState(state: PaymentStatus) {
    switch (state) {
      case PaymentStateInfoPage.PaymentStatus.SUCCESS:
        return this._createSuccessBean();
      case PaymentStateInfoPage.PaymentStatus.FAILED:
        return this._createFailedBean();
      default:
        return this._createPendingBean();
    }
  }

  protected override _createInfoTileBean(): InfoTileBean {
    return this._createBeanForState(PaymentStateInfoPage.PaymentStatus.PENDING);
  }

  protected _createPendingBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-help',
      title: 'Bezahlung ausstehend...',
      description: 'Die Bezahlung wurde noch nicht abgeschlossen.',
      infoColorClass: 'info-color-light-blue'
    }
  }

  protected _createSuccessBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-pause',
      title: 'Kurze pause...',
      description: 'Die Küche kann momentan keine weiteren Bestellungen entgegennehmen. Bitte haben Sie einen Moment Geduld.',
      infoColorClass: 'info-color-orange'
    }
  }

  protected _createFailedBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-cross',
      title: 'Bezahlung fehlgeschlagen',
      description: 'Probieren wir es nochmals',
      buttonLabel: 'Nochmals probieren',
      infoColorClass: 'info-color-red'
    }
  }
}
