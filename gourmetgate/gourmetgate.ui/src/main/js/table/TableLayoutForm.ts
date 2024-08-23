import {Form, WidgetModel} from "@eclipse-scout/core";
import TableLayoutFormModel, {TableLayoutFormWidgetMap} from './TableLayoutFormModel';
import {ParameterRepository, TableRowCountParameter, TablesPerRowParameter} from "../index";

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
}
