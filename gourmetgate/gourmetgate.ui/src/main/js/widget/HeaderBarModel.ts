import {WidgetModel} from "@eclipse-scout/core";

export interface HeaderBarModel extends WidgetModel {
  /**
   * Title lable of the header bar
   */
  title?: string;
  /**
   * Icon ID of the header bar icon on the right side
   */
  iconId?: string;
  /**
   * Amount of articles in the cart
   */
  cartCount?: number;
}
