import {ObjectOrModel, PageWithTable, scout, Table, TableRow} from "@eclipse-scout/core";
import parameterTablePageModel, {ParameterTable} from './ParameterTablePageModel';
import {Parameter, ParameterForm, ParameterRepository} from "../index";

export class ParameterTablePage extends PageWithTable {
  declare detailTable: ParameterTable;

  protected override _jsonModel(): Record<string, any> {
    return parameterTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);
    table.widget('EditMenu').on('action', this._onEditMenuClick.bind(this));
  }

  protected override _loadTableData(searchFilter: any): JQuery.Promise<Parameter[]> {
    return ParameterRepository.get().getParameterTablePageData();
  }

  protected override _transformTableDataToTableRows(tableData: Parameter[]): ObjectOrModel<TableRow>[] {
    return tableData.map(row => {
      return {
        id: row.name,
        cells: [
          row.parameterId,
          row.name,
          row.value
        ]
      }
    });
  }

  protected _onEditMenuClick() {
    let form = this._createParameterForm(this.detailTable.selectedRow().id);
    form.one('close', () => this.reloadPage());
    form.open();
  }

  protected _createParameterForm(parameterName: string): ParameterForm {
    return scout.create(ParameterForm, {
      parent: this.detailTable,
      parameterName: parameterName
    });
  }
}
