import {Form, WidgetModel} from "@eclipse-scout/core";
import InfoFormModel from "./InfoFormModel";

export class InfoForm extends Form {

  protected override _jsonModel(): WidgetModel {
    return InfoFormModel();
  }
}
