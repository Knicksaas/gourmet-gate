import {Icon, InitModelOf, scout, Widget} from "@eclipse-scout/core";
import {HeaderBarModel, IHeaderBarEventMap} from "../index";

export class HeaderBar extends Widget implements HeaderBarModel {
  declare model: HeaderBarModel;
  declare eventMap: IHeaderBarEventMap;
  declare self: HeaderBar;

  title: string;
  iconId: string;
  cartCount: number;
  icon: Icon;

  $title: JQuery;
  $cartCountIndicator: JQuery;

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.resolveTextKeys(['title']);
  }

  protected override _render() {
    super._render();
    this.$container = this.$parent.appendDiv('header-bar');
  }

  protected override _renderProperties() {
    super._renderProperties();
    this._renderTitle();
    this._renderIconId();
    this._renderCartCount();
  }

  protected _renderTitle() {
    this.$title = this.$container.appendDiv('header-bar-title');
    this.$title.text(this.title);
  }

  protected _renderIconId() {
    this._removeIconId();
    this.icon = scout.create(Icon, {
      parent: this,
      iconDesc: this.iconId
    });
    this.icon.render();
    this.$container.on('click', this._onIconClick.bind(this));
  }

  protected _removeIconId() {
    if (this.icon) {
      this.icon.destroy();
    }
  }

  protected _renderCartCount() {
    this._removeCartCount();
    this.$cartCountIndicator = this.$container.appendDiv('cart-count-indicator');
    this.$cartCountIndicator.text(this.cartCount)
    this.$cartCountIndicator.toggleClass('hidden', !this.cartCount)
    this.$cartCountIndicator.addClass('animate');
    this.$container.on('click', this._onIconClick.bind(this));
  }

  protected _removeCartCount() {
    if (this.$cartCountIndicator) {
      this.$cartCountIndicator.remove();
    }
  }

  protected _onIconClick() {
    this.trigger('iconClick');
  }
}
