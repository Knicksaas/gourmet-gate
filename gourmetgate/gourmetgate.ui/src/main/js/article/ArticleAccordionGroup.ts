import {Group, WidgetModel} from "@eclipse-scout/core";
import ArticleAccordionGroupModel from "./ArticleAccordionGroupModel";

export class ArticleAccordionGroup extends Group {

  protected override _jsonModel(): WidgetModel {
    return ArticleAccordionGroupModel();
  }
}
