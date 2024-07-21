import {BeanTile, WidgetModel} from "@eclipse-scout/core";
import ArticleTileModel from "./ArticleTileModel";
import {Article} from "../index";

export class ArticleTile extends BeanTile<Article> {

  protected override _jsonModel(): WidgetModel {
    return ArticleTileModel();
  }

  protected override _renderBean() {
    super._renderBean();
    this.$container
      .appendDiv("article-tile-title")
      .text(this.bean.name);
  }
}
