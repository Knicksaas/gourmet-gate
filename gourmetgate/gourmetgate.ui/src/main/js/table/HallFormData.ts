import $ from "jquery";
import {Table} from "../index";

export class HallFormData {

  tables: Table[];
  tableRowCount: number;
  tablesPerRowCount: number;

  static ENTITY_TYPE = 'hallFormData';

  init(model: any) {
    $.extend(this, model);
  }
}
