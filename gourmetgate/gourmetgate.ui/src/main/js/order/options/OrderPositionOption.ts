import $ from "jquery";

export class OrderPositionOption {

  orderPositionOptionId: string;
  orderPositionId: string;
  articleOptionId: string;
  selected: boolean;

  static ENTITY_TYPE = 'orderPositionOption';

  init(model: any) {
    $.extend(this, model);
  }
}
