import {ListBox, Table} from "@eclipse-scout/core";

export class OrderPositionOptionsListBox extends ListBox<string> {

  protected override _createDefaultListBoxTable(): Table {
    let table = super._createDefaultListBoxTable();
    table.setTextFilterEnabled(false);
    return table;
  }
}
