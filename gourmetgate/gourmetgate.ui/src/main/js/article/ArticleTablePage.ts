import {ObjectOrModel, PageWithTable, scout, Table, TableRow} from "@eclipse-scout/core";
import {ArticleGroupForm, ArticleRepository, ArticleTable, ArticleTablePageEntry} from "../index";
import ArticleTablePageModel from "./ArticleTablePageModel";

export class ArticleTablePage extends PageWithTable {
  declare detailTable: ArticleTable;

  protected override _jsonModel(): Record<string, any> {
    return ArticleTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    this.detailTable.widget('EditEntryMenu').on('action', this._modifyEntryMenuAction.bind(this));
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
            tableEntry.active
          ]
        };
      });
  }

  protected _modifyEntryMenuAction() {
    let row = this.detailTable.selectedRow();
    if (row.parentRow) {

    } else {
      // Must be an ArticleGroup when no parent row is present
      this._createArticleGroupForm(row.id).open();
    }
  }

  protected _createArticleGroupForm(articleGroupId: string): ArticleGroupForm {
    let outline = this.getOutline();
    return scout.create(ArticleGroupForm, {
      parent: outline,
      articleGroupId: articleGroupId
    });
  }
}
