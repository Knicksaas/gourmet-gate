import {PaymentStatus} from "../../index";
import $ from "jquery";

export class InfoTileBean {
  title: string;
  description?: string;
  infoColorClass?: string;
  iconClass: string;
  buttonLabel?: string;
  paymentStatus?: PaymentStatus

  static ENTITY_TYPE = 'infoTileBean';

  init(model: any) {
    $.extend(this, model);
  }
}
