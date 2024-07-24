import {Group, GroupModel, TileGrid, WidgetModel} from "@eclipse-scout/core";
import ArticleAccordionGroupJsonModel from "./ArticleAccordionGroupJsonModel";

export interface ArticleAccordionGroupModel extends GroupModel<TileGrid> {
  articleGroupId?: string;
}

export class ArticleAccordionGroup extends Group<TileGrid> implements ArticleAccordionGroupModel {
  declare model: ArticleAccordionGroupModel;

  articleGroupId: string;

  protected override _jsonModel(): WidgetModel {
    return ArticleAccordionGroupJsonModel();
  }
}
