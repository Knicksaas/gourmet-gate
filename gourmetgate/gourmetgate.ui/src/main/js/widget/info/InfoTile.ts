import {BeanTile, InitModelOf} from "@eclipse-scout/core";
import {InfoTileBean} from "./InfoTileBean";

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
  }


  protected override _renderBean() {
    this.$iconBox = this.$container.appendDiv('icon-box');
    this.$textBox = this.$container.appendDiv('text-box');
    this.$buttonBox = this.$container.appendDiv('button-box');

    this.$icon = this.$iconBox.appendDiv('info-icon')
    this.$icon.appendDiv('gg-icon icon-white gg-icon-check')

    this.$title = this.$textBox.appendDiv('title');
    this.$description = this.$textBox.appendDiv('description');
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }
}
