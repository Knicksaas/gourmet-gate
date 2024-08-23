import {BeanTile} from "@eclipse-scout/core";
import {Table} from "../index";

export class TableTile extends BeanTile<Table> {

  $name: JQuery;

  protected override _renderBean() {
    this.$container.addClass('table-tile');
    this.$name = this.$container.appendDiv('table-name');
    this.$name.text(this.bean.name);
    this.$container.toggleClass('has-open-orders', this.bean.openOrders > 0);
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }
}
