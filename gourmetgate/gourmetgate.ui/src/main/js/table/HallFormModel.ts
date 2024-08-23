import {
  FormModel,
  GroupBox,
  icons,
  Menu,
  StringField,
  TileField,
  TileGrid,
  VerticalSmartGrid,
  Widget
} from '@eclipse-scout/core';

export default (): FormModel => ({
  id: 'HallForm',
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    gridColumnCount: 1,
    fields: [
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
          logicalGrid: VerticalSmartGrid,
          withPlaceholders: true,
          layoutConfig: {
            rowHeight: 60,
            columnWidth: 10,
            hgap: 10,
            vgap: 10,
          },
        },
        gridDataHints: {
          fillVertical: true,
          h: 8
        }
      },
      {
        id: 'EventLogBox',
        objectType: GroupBox,
        expandable: true,
        expanded: true,
        label: '${textKey:EventLog}',
        fields: [{
          id: 'EventLogTextField',
          objectType: StringField,
          disabledStyle: Widget.DisabledStyle.READ_ONLY,
          enabled: false,
          multilineText: true,
          labelVisible: false,
          statusVisible: false,
          gridDataHints: {
            h: 5
          }
        }]
      }
    ],
    menus: [
      {
        id: 'EditTableLayoutMenu',
        objectType: Menu,
        text: '${textKey:EditTableLayout}',
        iconId: icons.PENCIL
      },
      {
        id: 'DownloadTableQrCodesMenu',
        objectType: Menu,
        text: '${textKey:DownloadQrCodes}',
        iconId: icons.LONG_ARROW_DOWN
      }]
  }
})

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type HallFormWidgetMap = {
  'MainBox': GroupBox;
  'HallTileField': TileField;
  'HallTileGrid': TileGrid;
  'EventLogBox': GroupBox;
  'EventLogTextField': StringField;
  'EditTableLayoutMenu': Menu;
  'DownloadTableQrCodesMenu': Menu;
};
