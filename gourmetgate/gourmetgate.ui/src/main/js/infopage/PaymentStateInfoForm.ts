import {InfoForm, InfoTileBean, PaymentRepository} from "../index";
import {EnumObject} from "@eclipse-scout/core";

export type PaymentStatus = EnumObject<typeof PaymentStateInfoForm.PaymentStatus>;

export class PaymentStateInfoForm extends InfoForm {

  static PaymentStatus = {
    CREATED: 0,
    PAID: 10,
    FAILED: 100
  } as const;

  protected override _load(): JQuery.Promise<InfoTileBean> {
    return PaymentRepository.get().getPaymentStatus();
  }


  protected override _onTileButtonClick() {
    this.widget('InfoTileGrid').tiles.forEach(t => t.setLoading(true));
    window.location.assign('/');
  }
}
