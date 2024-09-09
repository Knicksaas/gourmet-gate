import {Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  id: 'ParameterTablePage',
  objectType: PageWithTable,
  text: '${textKey:Settings}',
  leaf: true,
  detailTable: {
    id: 'ParameterTable',
    objectType: Table,
    autoResizeColumns: true,
    columns: [
      {
        id: 'IdColumn',
        objectType: Column<string>,
        visible: false,
        text: '${textKey:Id}',
        width: 100
      },
      {
        id: 'NameColumn',
        objectType: Column<string>,
        text: '${textKey:Name}',
        width: 100
      },
      {
        id: 'ValueColumn',
        objectType: Column<string>,
        text: '${textKey:Value}',
        width: 500
      }
    ],
    menus: [{
      id: 'EditMenu',
      objectType: Menu,
      text: '${textKey:Edit}',
      iconId: icons.PENCIL,
      menuTypes: [Table.MenuType.SingleSelection],
      defaultMenu: true
    }]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class ParameterTable extends Table {
  declare widgetMap: ParameterTableWidgetMap;
  declare columnMap: ParameterTableColumnMap;
}

export type ParameterTableWidgetMap = {
  'EditMenu': Menu;
};

export type ParameterTableColumnMap = {
  'IdColumn': Column<string>;
  'NameColumn': Column<string>;
  'ValueColumn': Column<string>;
};
