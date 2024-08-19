import {
  access,
  Desktop as ScoutDesktop,
  DesktopModel as ScoutDesktopModel,
  Event,
  InitModelOf
} from '@eclipse-scout/core';
import DesktopModel, {DesktopWidgetMap} from './DesktopModel';
import {CartForm, OrderForm, ShopOutline} from "../index";

export class Desktop extends ScoutDesktop {
  declare widgetMap: DesktopWidgetMap;

  protected override _jsonModel(): ScoutDesktopModel {
    return DesktopModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this._transformDesktop();
  }

  protected _transformDesktop() {
    if (access.quickCheck('EscapeShopViewPermission')) {
      this.setNavigationVisible(true);
      this.setNavigationHandleVisible(true);
      this.setHeaderVisible(true);
    }
  }

  activateOrderPage() {
    let outline = this.getOutlines().find(o => o instanceof ShopOutline);
    let orderPage = outline.nodes.find(page => page.id === OrderForm.PageId);
    outline.selectNode(orderPage);
    orderPage.reloadPage();
  }

  activateCartPage() {
    let outline = this.getOutlines().find(o => o instanceof ShopOutline);
    let cartPage = outline.nodes.find(page => page.id === CartForm.PageId);
    outline.selectNode(cartPage);
    cartPage.reloadPage();
  }


}

export interface DataChangeEvent<T = Desktop> extends Event<T> {
  dataType: string;
  data: any;
}
