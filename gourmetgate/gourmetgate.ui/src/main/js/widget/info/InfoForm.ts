import {Form, WidgetModel} from "@eclipse-scout/core";
import InfoFormModel, {InfoFormWidgetMap} from './InfoFormModel';

export class InfoForm extends Form {

  declare widgetMap: InfoFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return InfoFormModel();
  }
}
