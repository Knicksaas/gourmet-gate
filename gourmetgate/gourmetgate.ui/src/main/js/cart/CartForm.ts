import {Form, WidgetModel} from "@eclipse-scout/core";
import {CartFormData} from "../index";
import CartFormModel from "./CartFormModel";

export class CartForm extends Form {
  declare data: CartFormData;

  protected override _jsonModel(): WidgetModel {
    return CartFormModel();
  }
}
