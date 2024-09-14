import {BeanTile, InitModelOf} from "@eclipse-scout/core";
import {InfoTileBean} from "../../index";

export class InfoTile extends BeanTile {
  declare bean: InfoTileBean;

  $iconBox: JQuery;
  $textBox: JQuery;
  $buttonBox: JQuery;

  $icon: JQuery;

  $title: JQuery;
  $description: JQuery;
  $button: JQuery;

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.setCssClass('info-tile');
  }

  setBean(bean: InfoTileBean) {
    this.setProperty('bean', bean);
  }

  _setBean(bean: InfoTileBean) {
    this._setProperty('bean', bean);
  }

  protected override _renderBean() {
    this._removeBean();

    this.$iconBox = this.$container.appendDiv('icon-box');
    this.$textBox = this.$container.appendDiv('text-box');
    this.$buttonBox = this.$container.appendDiv('button-box');

    this.$icon = this.$iconBox.appendDiv('info-icon')
      .addClass(this.bean.infoColorClass);
    this.$icon.appendDiv('gg-icon icon-white').addClass(this.bean.iconClass);

    this.$title = this.$textBox.appendDiv('title')
      .text(this.bean.title);
    this.$description = this.$textBox.appendDiv('description')
      .text(this.bean.description);

    if (this.bean.buttonLabel) {
      this.$button = this.$buttonBox.appendDiv('info-action-button')
        .addClass(this.bean.infoColorClass)
        .text(this.bean.buttonLabel)
        .on('click', this._onButtonClick.bind(this));
    }
  }

  protected _removeBean() {
    if (this.rendered) {
      this.$iconBox.remove();
      this.$textBox.remove();
      this.$buttonBox.remove();
    }
  }

  protected _onButtonClick(event: JQuery.ClickEvent) {
    this.trigger('buttonClick');
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }
}
