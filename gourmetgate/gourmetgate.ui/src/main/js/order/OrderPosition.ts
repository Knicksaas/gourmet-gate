import $ from "jquery";

export class OrderPosition {

  orderPositionId: string;
  orderId: string;
  articleId: string;
  price: string;
  vat: string;

  static ENTITY_TYPE = 'orderPosition';

  init(model: any) {
    $.extend(this, model);
  }
}
