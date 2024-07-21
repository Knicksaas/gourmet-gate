import {BeanTile, WidgetModel} from "@eclipse-scout/core";
import ArticleTileModel from "./ArticleTileModel";

export class ArticleTile extends BeanTile {

  protected override _jsonModel(): WidgetModel {
    return ArticleTileModel();
  }
}
