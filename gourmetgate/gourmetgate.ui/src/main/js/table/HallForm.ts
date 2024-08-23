import {Form, InitModelOf, scout, WidgetModel} from "@eclipse-scout/core";
import HallFormModel, {HallFormWidgetMap} from './HallFormModel';
import {TableLayoutForm} from "../index";

export class HallForm extends Form {
  declare widgetMap: HallFormWidgetMap;

  static PageId: string = 'HallPage';

  protected override _jsonModel(): WidgetModel {
    return HallFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this.widget('EditTableLayoutMenu').on('action', this._openTableLayoutForm.bind(this));
  }

  protected _openTableLayoutForm() {
    scout.create(TableLayoutForm, {
      parent: this
    }).open();
  }
}
