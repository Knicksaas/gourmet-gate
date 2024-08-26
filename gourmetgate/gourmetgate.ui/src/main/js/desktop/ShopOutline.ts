import {access, InitModelOf, Outline, OutlineModel} from '@eclipse-scout/core';
import DataOutlineModel from './ShopOutlineModel';
import {OrderForm} from "../index";

export class ShopOutline extends Outline {

  protected override _jsonModel(): OutlineModel {
    return DataOutlineModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    if (!access.quickCheck('EscapeShopViewPermission')) {
      this.selectNode(this.nodes.find(page => page.id === OrderForm.PageId));
    }
  }
}
