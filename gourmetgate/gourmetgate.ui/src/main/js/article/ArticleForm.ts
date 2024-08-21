import {Form, WidgetModel} from "@eclipse-scout/core";
import ArticleFormModel from "./ArticleFormModel";

export class ArticleForm extends Form {

  articleId: string;

  protected override _jsonModel(): WidgetModel {
    return ArticleFormModel();
  }
}
