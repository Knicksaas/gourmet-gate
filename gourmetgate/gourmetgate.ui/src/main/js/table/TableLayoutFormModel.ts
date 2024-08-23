import {CancelMenu, FormModel, GroupBox, IntegerField, OkMenu} from '@eclipse-scout/core';

export default (): FormModel => ({
  id: 'TableLayoutForm',
  displayHint: 'dialog',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    gridColumnCount: 1,
    fields: [
      {
        id: 'ConfigurationBox',
        objectType: GroupBox,
        gridColumnCount: 1,
        label: '${textKey:TableLayout}',
        fields: [
          {
            id: 'TableRowCountField',
            objectType: IntegerField,
            label: '${textKey:TableRowCount}',
            mandatory: true
          },
          {
            id: 'TablesPerRowCountField',
            objectType: IntegerField,
            label: '${textKey:TablesPerRowCount}',
            mandatory: true
          }
        ]
      }
    ],
    menus: [
      {
        id: 'OkMenu',
        objectType: OkMenu,
        tooltipText: '${textKey:OkMenuTooltip}'
      },
      {
        id: 'CancelMenu',
        objectType: CancelMenu,
        tooltipText: '${textKey:CancelMenuTooltip}'
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type TableLayoutFormWidgetMap = {
  'MainBox': GroupBox;
  'ConfigurationBox': GroupBox;
  'TableRowCountField': IntegerField;
  'TablesPerRowCountField': IntegerField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
