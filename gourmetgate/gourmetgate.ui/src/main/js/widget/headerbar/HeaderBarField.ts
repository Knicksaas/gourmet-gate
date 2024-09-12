import {FormField} from "@eclipse-scout/core";
import {HeaderBar} from "./HeaderBar";
import {HeaderBarFieldModel, HeaderBarModel} from "../../index";

export class HeaderBarField extends FormField implements HeaderBarFieldModel {
  declare model: HeaderBarModel;

  headerBar: HeaderBar;

  constructor() {
    super();
    this.gridDataHints.weightY = 0;
    this.gridDataHints.fillHorizontal = true;
    this.gridDataHints.fillVertical = true;
    this.gridDataHints.w = 2;
    this.gridDataHints.heightInPixel = 50;
    this._addWidgetProperties(['headerBar']);
  }

  protected override _render() {
    this.addContainer(this.$parent, 'header-bar-field');
    if (this.headerBar) {
      this.headerBar.render();
      this.addField(this.headerBar.$container);
    }
  }
}
