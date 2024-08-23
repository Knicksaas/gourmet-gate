import $ from "jquery";

export class Table {

  tableId: string;
  name: string;
  enabled: boolean;
  openOrders: number; // Not persisted

  static ENTITY_TYPE = 'table';

  init(model: any) {
    $.extend(this, model);
  }
}
