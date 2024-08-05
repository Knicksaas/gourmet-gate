import {BeanTile} from "@eclipse-scout/core";
import {CartItem} from "../index";

export class OrderPositionTile extends BeanTile<CartItem> {

  $description: JQuery;
  $icons: JQuery;
  $options: JQuery;

  $staticDescription: JQuery;
  $unit: JQuery;
  $price: JQuery;
  $name: JQuery;

  $editIcon: JQuery;
  $deleteIcon: JQuery;

  constructor() {
    super();
    this.displayStyle = 'PLAIN';
  }

  protected override _renderBean() {
    this.$container.addClass('order-position-tile');
    this.$description = this.$container.appendDiv('description');
    this.$icons = this.$container.appendDiv('icons');

    this._renderDescription();
    this._renderIcons();
    this._renderOptions();
  }

  protected _renderDescription() {
    this.$staticDescription = this.$description.appendDiv('static-description');
    this.$name = this.$staticDescription.appendDiv('name');
    this.$unit = this.$staticDescription.appendDiv('unit');
    this.$price = this.$staticDescription.appendDiv('price');
    this.$name.text(this.bean.articleName);
    this.$unit.text(this.bean.unit);
    this.$price.text(this.bean.price);
  }

  protected _renderIcons() {
    if (this.bean.hasOptions) {
      this.$editIcon = this.$icons.appendDiv('edit-order-position');
    }
    this.$deleteIcon = this.$icons.appendDiv('delete-order-position');
  }

  protected _renderOptions() {
    if (this.bean.hasOptions) {
      this.$options = this.$description.appendDiv('options');
      this.$options.text(this.bean.options);
    }
  }
}
