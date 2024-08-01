import {FormFieldModel} from "@eclipse-scout/core";
import {HeaderBar} from "./HeaderBar";

export interface HeaderBarFieldModel extends FormFieldModel {
  headerBar?: HeaderBar;
}
