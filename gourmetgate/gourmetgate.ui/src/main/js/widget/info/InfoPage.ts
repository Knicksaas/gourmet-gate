import InfoPageModel, {InfoPageInfoForm} from './InfoPageModel';
import {InfoForm, InfoTile, InfoTileBean, PageWithData} from "../../index";
import {scout} from "@eclipse-scout/core";

export class InfoPage extends PageWithData {
  declare detailForm: InfoPageInfoForm;

  infoTile: InfoTile;

  protected override _jsonModel(): Record<string, any> {
    return InfoPageModel();
  }

  protected override _initDetailForm(form: InfoForm) {
    super._initDetailForm(form);
    this.infoTile = this._createInfoTile(this._createInfoTileBean());
    form.widget('InfoTileGrid').insertTile(this.infoTile)
  }

  protected _createInfoTile(bean: InfoTileBean): InfoTile {
    let tile = scout.create(InfoTile, {
      parent: this.detailForm.widget('InfoTileGrid'),
      bean: bean
    });
    tile.on('buttonClick', this._onTileButtonClick.bind(this))
    return tile;
  }

  protected _createInfoTileBean(): InfoTileBean {
    // NOP
    return null;
  }

  protected _onTileButtonClick() {
    // NOP
  }
}
