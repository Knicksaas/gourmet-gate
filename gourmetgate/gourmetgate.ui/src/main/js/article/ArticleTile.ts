import {BeanTile, BeanTileModel, WidgetModel} from "@eclipse-scout/core";
import ArticleTileJsonModel from "./ArticleTileJsonModel";
import {Article} from "../index";

export interface ArticleTileModel extends BeanTileModel {
  cartCount?: number;
}

export class ArticleTile extends BeanTile<Article> implements ArticleTileModel {
  declare model: ArticleTileModel;
  cartCount: number;

  $title: JQuery;
  $footer: JQuery;
  $unit: JQuery;
  $price: JQuery;
  $cartCountIndicator: JQuery;

  protected override _jsonModel(): WidgetModel {
    return ArticleTileJsonModel();
  }

  setCartCount(cartCount: number) {
    this.setProperty('cartCount', cartCount)
  }

  protected override _renderProperties() {
    super._renderProperties();
    this._renderCartCount();
  }

  protected override _renderBean() {
    this.$container.addClass('article-tile');

    this.$title = this.$container.appendDiv('article-title');
    this.$footer = this.$container.appendDiv('article-footer');
    this.$unit = this.$footer.appendDiv('article-unit');
    this.$price = this.$footer.appendDiv('article-price');

    this.$title.text(this.bean.name);
    this.$unit.text(this.bean.unit);
    this.$price.text(this.bean.price + ' CHF');
  }

  protected _renderCartCount() {
    this.$cartCountIndicator = this.$container.appendDiv('article-cart-count-indicator');
    this.$cartCountIndicator.text(this.cartCount)
    this.$cartCountIndicator.toggleClass('hidden', !this.cartCount)
  }
}
