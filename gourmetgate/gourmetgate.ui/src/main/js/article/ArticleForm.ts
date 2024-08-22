import {Form, InitModelOf, PropertyChangeEvent, WidgetModel} from "@eclipse-scout/core";
import ArticleFormModel, {ArticleFormWidgetMap} from './ArticleFormModel';
import {Article, ArticleRepository} from "../index";

export class ArticleForm extends Form {
  declare widgetMap: ArticleFormWidgetMap;
  declare data: Article;

  articleId: string;

  protected override _jsonModel(): WidgetModel {
    return ArticleFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.widget('ArticleOptionTableField').articleId = this.articleId;
    this.widget('HasOptionsField').on('propertyChange:value', this._onHasOptionsFieldValueChange.bind(this));
  }

  protected override _load(): JQuery.Promise<any> {
    return ArticleRepository.get().getArticle(this.articleId);
  }


  override importData() {
    this.widget('IdField').setValue(this.data.articleId);
    this.widget('NameField').setValue(this.data.name);
    this.widget('ArticleGroupField').setValue(this.data.articleGroupId);
    this.widget('UnitField').setValue(this.data.unit);
    this.widget('PriceField').setValue(this.data.price);
    this.widget('VatField').setValue(this.data.vatId);
    this.widget('EnabledField').setValue(this.data.enabled);
    this.widget('HasOptionsField').setValue(this.data.options);
    this.widget('ArticleOptionTableField').setRows(this.data.articleOptions);
  }


  override exportData(): any {
    this.data.name = this.widget('NameField').value;
    this.data.articleGroupId = this.widget('ArticleGroupField').value;
    this.data.unit = this.widget('UnitField').value;
    this.data.price = this.widget('PriceField').value;
    this.data.vatId = this.widget('VatField').value;
    this.data.enabled = this.widget('EnabledField').value;
    this.data.options = this.widget('HasOptionsField').value;
    this.data.articleOptions = this.widget('ArticleOptionTableField').getRows();
    return this.data;
  }

  protected override _save(data: Article): JQuery.Promise<void> {
    return ArticleRepository.get().updateArticle(this.articleId, data);
  }

  protected _onHasOptionsFieldValueChange(event: PropertyChangeEvent<boolean>) {
    this.widget('ArticleOptionTableField').setEnabled(event.newValue);
  }
}
