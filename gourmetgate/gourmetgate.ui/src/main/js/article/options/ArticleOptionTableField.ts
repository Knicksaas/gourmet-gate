import {InitModelOf, ObjectOrModel, scout, TableField, TableRow, WidgetModel} from "@eclipse-scout/core";
import ArticleOptionTableFieldModel, {ArticleOptionTableFieldWidgetMap} from './ArticleOptionTableFieldModel';
import {ArticleOption} from "./ArticleOption";

export class ArticleOptionTableField extends TableField {
  declare widgetMap: ArticleOptionTableFieldWidgetMap;

  articleId: string;

  protected override _jsonModel(): WidgetModel {
    return ArticleOptionTableFieldModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this.widget('AddArticleOptionMenu').on('action', this._addArticleOption.bind(this));
    this.widget('DeleteArticleOptionMenu').on('action', this._deleteArticleOption.bind(this));
  }

  setRows(articleOptions: ArticleOption[]) {
    let rows = articleOptions.map(option => this._optionToRow(option))
    this.table.replaceRows(rows);
  }

  getRows(): ArticleOption[] {
    return this.table.rows.map(row => this._rowToOption(row));
  }

  protected _optionToRow(option: ArticleOption): ObjectOrModel<TableRow> {
    return {
      id: option.articleOptionId,
      cells: [
        option.articleOptionId,
        option.articleId,
        option.description
      ]
    };
  }

  protected _rowToOption(row: TableRow) {
    return scout.create(ArticleOption, {
      articleOptionId: row.cells[0].value,
      articleId: row.cells[1].value,
      description: row.cells[2].value
    })
  }

  protected _addArticleOption() {
    this.table.insertRow({
      cells: [
        null, this.articleId, 'New option'
      ]
    })
  }

  protected _deleteArticleOption() {
    this.table.deleteRow(this.table.selectedRow());
  }
}
