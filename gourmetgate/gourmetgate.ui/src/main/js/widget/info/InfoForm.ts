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
