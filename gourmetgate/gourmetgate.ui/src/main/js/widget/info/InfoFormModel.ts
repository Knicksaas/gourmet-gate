import {Form, FormModel, GroupBox, TileField, TileGrid} from '@eclipse-scout/core';
import {InfoTile} from '../../index';

export default (): FormModel => ({
  id: 'InfoFormModel',
  objectType: Form,
  displayHint: Form.DisplayHint.DIALOG,
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    scrollable: false,
    statusVisible: false,
    labelVisible: false,
    gridColumnCount: 1,
    fields: [{
      id: 'InfoTileField',
      objectType: TileField,
      labelVisible: false,
      statusVisible: false,
      tileGrid: {
        id: 'InfoTileGrid',
        objectType: TileGrid,
        cssClass: 'info-form-tile-grid',
        scrollable: false,
        gridColumnCount: 1,
        withPlaceholders: false,
        layoutConfig: {
          rowHeight: 600,
          columnWidth: 200,
          hgap: 200,
          vgap: 200
        },
      },
      gridDataHints: {
        fillVertical: true,
        h: 8
      }
    }]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type InfoFormWidgetMap = {
  'MainBox': GroupBox;
  'InfoTileField': TileField;
  'InfoTileGrid': TileGrid;
  'TestTile': InfoTile;
};
