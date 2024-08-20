import {Outline, WidgetModel} from "@eclipse-scout/core";
import ConfigurationOutlineModel from "./ConfigurationOutlineModel";

export class ConfigurationOutline extends Outline {

  protected override _jsonModel(): WidgetModel {
    return ConfigurationOutlineModel();
  }
}
