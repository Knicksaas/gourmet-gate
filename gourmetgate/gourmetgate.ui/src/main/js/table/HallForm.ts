import {Form, InitModelOf, PropertyChangeEvent, WidgetModel} from "@eclipse-scout/core";
import HallFormModel, {HallFormWidgetMap} from './HallFormModel';

export class HallForm extends Form {
  declare widgetMap: HallFormWidgetMap;

  static PageId: string = 'HallPage';

  protected override _jsonModel(): WidgetModel {
    return HallFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this.widget('TablePerRowCountField').on('propertyChange:value', this._onTablesPerRowChange.bind(this));
  }

  protected _onTablesPerRowChange(event: PropertyChangeEvent<number>) {
    let tileGrid = this.widget('HallTileGrid')
    tileGrid.setGridColumnCount(tileGrid.tiles.length / event.newValue);
  }
}
