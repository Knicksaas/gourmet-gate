import {
  MessageBox,
  MessageBoxes,
  ObjectOrModel,
  PageWithTable,
  scout,
  Status,
  Table,
  TableRow,
  TableRowsSelectedEvent
} from "@eclipse-scout/core";
import {
  ArticleForm,
  ArticleGroupForm,
  ArticleGroupRepository,
  ArticleRepository,
  ArticleTable,
  ArticleTablePageEntry
} from "../index";
import ArticleTablePageModel from "./ArticleTablePageModel";

export class ArticleTablePage extends PageWithTable {
  declare detailTable: ArticleTable;

  protected override _jsonModel(): Record<string, any> {
    return ArticleTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    this.detailTable.widget('CreateArticleGroupMenu').on('action', this._createArticleGroup.bind(this));
    this.detailTable.widget('CreateArticleMenu').on('action', this._createArticle.bind(this))
    this.detailTable.widget('EditEntryMenu').on('action', this._modifyEntryMenuAction.bind(this));
    this.detailTable.widget('DeleteEntryMenu').on('action', this._deleteTableEntry.bind(this));
    this.detailTable.on('rowsSelected', this._onTableRowClicked.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<ArticleTablePageEntry[]> {
    return ArticleRepository.get().getArticleTablePageData();
  }

  protected override _transformTableDataToTableRows(tableData: ArticleTablePageEntry[]): ObjectOrModel<TableRow>[] {
    return tableData
      .map(tableEntry => {
        return {
          id: tableEntry.id,
          expanded: true,
          parentRow: tableEntry.parentId,
          cells: [
            tableEntry.id,
            tableEntry.parentId,
            tableEntry.name,
            tableEntry.unit,
            tableEntry.price,
            tableEntry.options,
            tableEntry.enabled
          ]
        };
      });
  }

  protected _onTableRowClicked(event: TableRowsSelectedEvent) {
    this.detailTable.widget('CreateArticleMenu').setVisible(this.detailTable.selectedRows.length !== 0);
  }

  protected _createArticleGroup() {
    ArticleGroupRepository.get().createArticleGroup()
      .then(articleGroup => {
        this._createArticleGroupForm(articleGroup.articleGroupId).open();
      });
  }

  protected _createArticle() {
    let seletectedRow = this.detailTable.selectedRow();
    let articleGroupId = seletectedRow.parentRow ? seletectedRow.parentRow.id : seletectedRow.id;
    ArticleRepository.get().createArticle(articleGroupId)
      .then(article => {
        this._createArticleForm(article.articleId).open();
      });
  }

  protected _modifyEntryMenuAction() {
    let row = this.detailTable.selectedRow();
    if (this._isArticleGroup(row)) {
      this._createArticleGroupForm(row.id).open();
    } else {
      this._createArticleForm(row.id).open();
    }
  }

  protected _deleteTableEntry() {
    let row = this.detailTable.selectedRow();
    MessageBoxes.openYesNo(this.getOutline(), '${textKey:DeleteWarning}', Status.Severity.WARNING)
      .then(option => {
        if (option == MessageBox.Buttons.YES) {
          if (this._isArticleGroup(row)) {
            ArticleGroupRepository.get().deleteArticleGroup(row.id);
          } else {
            // TBD
          }
        }
      });
  }

  protected _createArticleGroupForm(articleGroupId: string): ArticleGroupForm {
    let outline = this.getOutline();
    return scout.create(ArticleGroupForm, {
      parent: outline,
      articleGroupId: articleGroupId
    });
  }

  protected _createArticleForm(articleId: string): ArticleForm {
    let outline = this.getOutline();
    return scout.create(ArticleForm, {
      parent: outline,
      articleId: articleId
    });
  }

  protected _isArticleGroup(row: TableRow): boolean {
    return !row.parentRow;
  }
}
