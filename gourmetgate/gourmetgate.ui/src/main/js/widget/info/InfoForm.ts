import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import InfoFormModel, {InfoFormWidgetMap} from './InfoFormModel';
import {InfoTile, InfoTileBean} from "../../index";

export class InfoForm extends Form {

  declare widgetMap: InfoFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return InfoFormModel();
  }

  /**
   * Override by child class to load correct bean data
   */
  protected override _load(): JQuery.Promise<InfoTileBean> {
    throw new Error("No implementation provided");
  }

  override importData() {
    this._createInfoTile(this.data);
  }

  protected _createInfoTile(bean: InfoTileBean) {
    if (!bean) {
      bean = scout.create(InfoTileBean, {
        title: this.session.text('NothingHere'),
        infoColorClass: 'info-color-orange',
        iconClass: 'gg-icon-help',
        buttonLabel: this.session.text('NavigationBackward')
      });
    }

    let tile = scout.create(InfoTile, {
      parent: this.widget('InfoTileGrid'),
      bean: bean
    });
    tile.on('buttonClick', this._onTileButtonClick.bind(this))
    this.widget('InfoTileGrid').insertTile(tile);
  }

  protected _onTileButtonClick() {
    // NOP
  }
}
