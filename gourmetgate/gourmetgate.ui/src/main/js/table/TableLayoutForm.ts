import {Form, WidgetModel} from "@eclipse-scout/core";
import TableLayoutFormModel, {TableLayoutFormWidgetMap} from './TableLayoutFormModel';
import {ParameterRepository, TableRepository, TableRowCountParameter, TablesPerRowParameter} from "../index";

export class TableLayoutForm extends Form {
  declare widgetMap: TableLayoutFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return TableLayoutFormModel();
  }

  protected override _load(): JQuery.Promise<any> {
    return ParameterRepository.get()
      .getParameterValue(TableRowCountParameter)
      .then(value => this.widget('TableRowCountField').setValue(value))
      .then(() => ParameterRepository.get().getParameterValue(TablesPerRowParameter)
        .then(value => this.widget('TablesPerRowCountField').setValue(value)))
  }


  protected override _save(data: any): JQuery.Promise<void> {
    return this._storeParams()
  }

  protected _storeParams(): JQuery.Promise<any> {
    let rowCount = this.widget('TableRowCountField').value;
    let tableCount = this.widget('TablesPerRowCountField').value;
    return ParameterRepository.get().setParameterValue(TableRowCountParameter, rowCount)
      .then(() => ParameterRepository.get().setParameterValue(TablesPerRowParameter, tableCount)
        .then(() => TableRepository.get().regenerateTables()));
  }
}
