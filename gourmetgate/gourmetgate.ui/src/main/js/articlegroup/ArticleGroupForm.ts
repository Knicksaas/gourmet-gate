import {Form, FormModel, WidgetModel} from "@eclipse-scout/core";
import {ArticleGroupFormWidgetMap, default as ArticleGroupFormJsonModel} from './ArticleGroupFormModel';
import {ArticleGroup, ArticleGroupRepository} from "../index";

export interface ArticleGroupFormModel extends FormModel {
  articleGroupId?: string;
}

export class ArticleGroupForm extends Form implements ArticleGroupFormModel {
  declare model: ArticleGroupFormModel;
  declare widgetMap: ArticleGroupFormWidgetMap;
  declare data: ArticleGroup;
  articleGroupId: string;

  protected override _jsonModel(): WidgetModel {
    return ArticleGroupFormJsonModel();
  }

  protected override _load(): JQuery.Promise<ArticleGroup> {
    return ArticleGroupRepository.get().getArticleGroup(this.articleGroupId);
  }

  override importData() {
    this.widget('IdField').setValue(this.data.articleGroupId);
    this.widget('NameField').setValue(this.data.name);
    this.widget('EnabledField').setValue(this.data.enabled);
  }

  override exportData(): ArticleGroup {
    this.data.name = this.widget('NameField').value;
    this.data.enabled = this.widget('EnabledField').value;
    return this.data;
  }

  protected override _save(data: ArticleGroup): JQuery.Promise<void> {
    return ArticleGroupRepository.get().saveArticleGroup(data);
  }
}
