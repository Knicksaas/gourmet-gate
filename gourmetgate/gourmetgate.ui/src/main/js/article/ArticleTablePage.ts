import {ObjectOrModel, PageWithTable, TableRow} from "@eclipse-scout/core";
import {ArticleRepository, ArticleTable, ArticleTablePageEntry} from "../index";
import ArticleTablePageModel from "./ArticleTablePageModel";

export class ArticleTablePage extends PageWithTable {
  declare detailTable: ArticleTable;

  protected override _jsonModel(): Record<string, any> {
    return ArticleTablePageModel();
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
            tableEntry.options
          ]
        };
      });
  }
}
