import {Desktop, ggicons, HeaderBar} from "../index";
import {InitModelOf} from "@eclipse-scout/core";

export class OrderHeaderBar extends HeaderBar {

  constructor() {
    super();
    this.title = '${textKey:Order}';
    this.iconId = ggicons.SHOPPING_CART;
    this.cartCount = 10;
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.on('iconClick', this._onHeaderClick.bind(this));
  }

  protected _onHeaderClick() {
    (<Desktop>this.findDesktop()).activateCartPage();
  }
}
