import {Button, FormModel, GroupBox, IntegerField, TileField, TileGrid} from '@eclipse-scout/core';
import {TableTile} from '../index';

export default (): FormModel => ({
  id: 'HallForm',
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    gridColumnCount: 1,
    fields: [
      {
        id: 'ConfigurationBox',
        objectType: GroupBox,
        label: '${textKey:Configuration}',
        fields: [
          {
            id: 'TablePerRowCountField',
            objectType: IntegerField,
            label: '${textKey:TablePerRowCount}'
          },
          {
            id: 'TableCountField',
            objectType: IntegerField,
            label: '${textKey:TableCount}'
          },
          {
            id: 'DownloadQrCodesButton',
            objectType: Button,
            processButton: false,
            label: '${textKey:DownloadQrCodes}',
          }]
      },
      {
        id: 'HallTileField',
        objectType: TileField,
        labelVisible: false,
        statusVisible: false,
        cssClass: 'hall-tile-field',
        tileGrid: {
          id: 'HallTileGrid',
          objectType: TileGrid,
          selectable: true,
          layoutConfig: {
            rowHeight: 60,
            columnWidth: 60,
            hgap: 10,
            vgap: 10
          },
          tiles: [
            {
              objectType: TableTile,
              bean: {name: 'test'}
            },
            {
              objectType: TableTile,
              bean: {name: 'test2'}
            },
            {
              objectType: TableTile,
              bean: {name: 'test2'}
            },
            {
              objectType: TableTile,
              bean: {name: 'test2'}
            },
            {
              objectType: TableTile,
              bean: {name: 'test2'}
            },
            {
              objectType: TableTile,
              bean: {name: 'test2'}
            },

          ]
        },
        gridDataHints: {
          fillVertical: true,
          h: 8
        }
      }
    ]
  }
})

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type HallFormWidgetMap = {
  'MainBox': GroupBox;
  'ConfigurationBox': GroupBox;
  'TablePerRowCountField': IntegerField;
  'TableCountField': IntegerField;
  'DownloadQrCodesButton': Button;
  'HallTileField': TileField;
  'HallTileGrid': TileGrid;
};
