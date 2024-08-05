import $ from "jquery";

export class CartItem {

  orderPositionId: string;
  articleName: string;
  unit: string;
  price: number;
  hasOptions: string
  options: string

  static ENTITY_TYPE = 'orderPositionTileData';

  init(model: any) {
    $.extend(this, model);
  }
}
