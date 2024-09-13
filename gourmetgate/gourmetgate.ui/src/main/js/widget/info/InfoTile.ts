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

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.setCssClass('info-tile');
    this.bean = this._createBean();
  }


  protected override _renderBean() {
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
      this.$buttonBox.appendDiv('info-action-button')
        .addClass(this.bean.infoColorClass)
        .text(this.bean.buttonLabel)
        .on('click', this._onButtonClick.bind(this));
    }
  }

  protected _createBean(): InfoTileBean {
    return null;
  }

  protected _onButtonClick(event: JQuery.ClickEvent) {
    // NOP
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }
}
