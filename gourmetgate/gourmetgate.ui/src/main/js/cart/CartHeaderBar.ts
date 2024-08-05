import {Desktop, HeaderBar} from "../index";
import {icons, InitModelOf} from "@eclipse-scout/core";

export class CartHeaderBar extends HeaderBar {

  constructor() {
    super();
    this.title = '${textKey:Cart}';
    this.iconId = icons.PLUS;
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.on('iconClick', this._onHeaderClick.bind(this));
  }

  protected _onHeaderClick() {
    (<Desktop>this.findDesktop()).activateOrderPage();
  }
}
