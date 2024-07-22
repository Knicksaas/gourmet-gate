import {BeanTile, WidgetModel} from "@eclipse-scout/core";
import ArticleTileModel from "./ArticleTileModel";
import {Article} from "../index";

export class ArticleTile extends BeanTile<Article> {
  $title: JQuery;
  $footer: JQuery;
  $unit: JQuery;
  $price: JQuery;

  protected override _jsonModel(): WidgetModel {
    return ArticleTileModel();
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
}
