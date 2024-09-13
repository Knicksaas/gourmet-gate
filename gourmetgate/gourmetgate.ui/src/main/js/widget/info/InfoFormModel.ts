import {Form, FormModel, GroupBox, TileField, TileGrid} from '@eclipse-scout/core';
import {InfoTile} from "./InfoTile";

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
        tiles: [{
          id: 'TestTile',
          objectType: InfoTile,
          bean: {
            iconClass: 'gg-icon-qr-code',
            title: 'QR Code scannen',
            description: 'Scannen Sie den QR Code auf Ihrem Tisch, um mit der Bestellung zu starten.',
            buttonLabel: 'Code scannen',
            infoColorClass: 'info-color-orange'
          }
        }]
      },
      gridDataHints: {
        fillVertical: true,
        h: 8
      }
    }]
  }
});
