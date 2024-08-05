import $ from "jquery";
import {CartItem} from "../index";

export class CartFormData {

  cartItems: CartItem[];
  price: number;

  static ENTITY_TYPE = 'cartFormData';

  init(model: any) {
    $.extend(this, model);
  }

}
