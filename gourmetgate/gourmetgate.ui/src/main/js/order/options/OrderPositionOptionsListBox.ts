import {ListBox, Table} from "@eclipse-scout/core";
import {OrderPositionOptionsLookupCall} from "./OrderPositionOptionsLookupCall";

export class OrderPositionOptionsListBox extends ListBox<string> {
  declare lookupCall: OrderPositionOptionsLookupCall;

  protected override _createDefaultListBoxTable(): Table {
    let table = super._createDefaultListBoxTable();
    table.setTextFilterEnabled(false);
    return table;
  }
}
