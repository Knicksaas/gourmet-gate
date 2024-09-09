import {Form, WidgetModel} from "@eclipse-scout/core";
import ParameterFormModel, {ParameterFormWidgetMap} from './ParameterFormModel';
import {ParameterRepository} from "./ParameterRepository";

export class ParameterForm extends Form {
  declare widgetMap: ParameterFormWidgetMap;
  declare data: string;

  parameterName: string;

  protected override _jsonModel(): WidgetModel {
    return ParameterFormModel();
  }

  protected override _load(): JQuery.Promise<String> {
    return ParameterRepository.get().getParameterValueByName(this.parameterName);
  }

  override importData() {
    this.widget('ParameterNameField').setValue(this.parameterName);
    this.widget('ParameterValueField').setValue(this.data);
  }


  override exportData(): any {
    return this.widget('ParameterValueField').value;
  }

  protected override _save(data: any): JQuery.Promise<void> {
    return ParameterRepository.get().setParameterValueByName(this.parameterName, data);
  }
}
