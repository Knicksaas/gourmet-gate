import $ from "jquery";

export class CartFormData {

  static ENTITY_TYPE = 'cartFormData';

  init(model: any) {
    $.extend(this, model);
  }

}
