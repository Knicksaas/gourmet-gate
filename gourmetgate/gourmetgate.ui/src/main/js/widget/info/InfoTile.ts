import {BeanTile, InitModelOf} from "@eclipse-scout/core";

export class InfoTile extends BeanTile {

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.setCssClass('info-tile');
  }

  protected override _renderDisplayStyle() {
    this.$container.addClass('dashboard');
  }
}
