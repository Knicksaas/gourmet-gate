import {BooleanColumn, Column, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  id: 'ArticleTablePage',
  objectType: PageWithTable,
  text: '${textKey:Articles}',
  alwaysCreateChildPage: true,
  detailTable: {
    id: 'ArticleTable',
    objectType: Table,
    autoResizeColumns: true,
    columns: [
      {
        id: 'IdColumn',
        objectType: Column,
        visible: false,
        primaryKey: true
      },
      {
        id: 'ParentKeyColumn',
        objectType: Column,
        visible: false
      },
      {
        id: 'NameColumn',
        objectType: Column,
        text: '${textKey:Name}',
        width: 100
      },
      {
        id: 'UnitColumn',
        objectType: Column,
        text: '${textKey:Unit}',
        width: 50
      },
      {
        id: 'PriceColumn',
        objectType: Column,
        text: '${textKey:Price}',
        width: 50
      },
      {
        id: 'HasOptionsColumn',
        objectType: BooleanColumn,
        text: '${textKey:HasOptions}',
        width: 30
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class ArticleTable extends Table {
  declare columnMap: ArticleTableColumnMap;
}

export type ArticleTableColumnMap = {
  'IdColumn': Column;
  'ParentKeyColumn': Column;
  'NameColumn': Column;
  'UnitColumn': Column;
  'PriceColumn': Column;
  'HasOptionsColumn': Column;
};
