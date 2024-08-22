import {BeanTile, scout, strings, TileGrid} from "@eclipse-scout/core";
import {CartItem, OrderPositionOption, OrderPositionOptionForm, OrderRepository} from "../index";

export class OrderPositionTile extends BeanTile<CartItem> {

  $description: JQuery;
  $icons: JQuery;
  $options: JQuery;

  $staticDescription: JQuery;
  $unit: JQuery;
  $price: JQuery;
  $name: JQuery;

  $editIconContainer: JQuery;
  $editIcon: JQuery;
  $deleteIconContainer: JQuery;
  $deleteIcon: JQuery;

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
    this.$price.text(this.bean.price + ' CHF');
  }

  protected _renderIcons() {
    if (this.bean.hasOptions) {
      this.$editIconContainer = this.$icons.appendDiv('gg-icon-container bg-blue');
      this.$editIcon = this.$editIconContainer
        .appendDiv('gg-icon big')
        .addClass('gg-icon-edit');
      this.$editIconContainer.on('click', this._onEditClick.bind(this));
    }
    this.$deleteIconContainer = this.$icons.appendDiv('gg-icon-container bg-red');
    this.$deleteIcon = this.$deleteIconContainer
      .appendDiv('gg-icon big')
      .addClass('gg-icon-trash');
    this.$deleteIconContainer.on('click', this._onDeleteClick.bind(this));
  }

  protected _renderOptions() {
    if (this.bean.hasOptions && this.bean.options.length > 0) {
      this.$options = this.$description.appendDiv('options');
      this.$options.text('→ ' + this.bean.options);
    }
  }

  protected _removeOptions() {
    if (this.$options) {
      this.$options.remove();
    }
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }

  protected _onEditClick() {
    let optionsForm = this._createOptionsForm();
    optionsForm.one('close', () => this._updateOptionsText(optionsForm.data));
    optionsForm.open();
  }

  protected _createOptionsForm(): OrderPositionOptionForm {
    return scout.create(OrderPositionOptionForm, {
      parent: this,
      orderPositionId: this.bean.orderPositionId,
      title: '${textKey:Options_} ' + this.bean.articleName
    });
  }

  protected _updateOptionsText(options: OrderPositionOption[]) {
    this._removeOptions();
    this.bean.options = strings.join(', ', ...options.filter(o => o.selected).map(o => o.description));
    this._renderOptions();
  }

  protected _onDeleteClick() {
    OrderRepository.get().deleteOrderPosition(this.bean.orderPositionId);
    (<TileGrid>this.parent).deleteTile(this);
  }
}
