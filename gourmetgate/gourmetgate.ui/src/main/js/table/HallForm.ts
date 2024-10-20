import {Form, InitModelOf, scout, WidgetModel} from "@eclipse-scout/core";
import HallFormModel, {HallFormWidgetMap} from './HallFormModel';
import {DataChangeEvent, HallFormData, Table, TableLayoutForm, TableRepository, TableTile} from "../index";

export class HallForm extends Form {
  declare widgetMap: HallFormWidgetMap;
  declare data: HallFormData;

  static PageId: string = 'HallPage';

  protected override _jsonModel(): WidgetModel {
    return HallFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this.session.desktop.on('dataChange', this._onDataChange.bind(this));
    this.widget('EditTableLayoutMenu').on('action', this._openTableLayoutForm.bind(this));
    this.widget('DownloadTableQrCodesMenu').on('action', this._onDownloadQrCodes.bind(this));
  }


  protected override _load(): JQuery.Promise<any> {
    return TableRepository.get().getHallFormData();
  }

  override importData() {
    let tiles = this.data.tables.map(table => this._createTableTile(table));
    this.widget('HallTileGrid').deleteAllTiles();
    this.widget('HallTileGrid').insertTiles(tiles);
    this.widget('HallTileGrid').setGridColumnCount(this.data.tableRowCount);
  }

  protected _createTableTile(data: Table) {
    return scout.create(TableTile, {
      parent: this.widget('HallTileGrid'),
      bean: data
    });
  }

  protected _openTableLayoutForm() {
    scout.create(TableLayoutForm, {
      parent: this
    }).open();
  }

  protected _onDownloadQrCodes() {
    window.open('api/table/qrcodes/', '_blank').focus();
  }

  protected _onDataChange(event: DataChangeEvent) {
    if (event.dataType === HallFormData.ENTITY_TYPE) {
      this.data = event.data;
      this.importData();
    }
  }
}
