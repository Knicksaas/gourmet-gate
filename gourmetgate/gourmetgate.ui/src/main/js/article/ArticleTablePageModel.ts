import {BooleanColumn, Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

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
        width: 100,
        mandatory: true
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
        text: '${textKey:Options}',
        width: 30
      },
      {
        id: 'ActiveColumn',
        objectType: BooleanColumn,
        text: '${textKey:Active}',
        width: 30
      }
    ],
    menus: [
      {
        id: 'CreateArticleGroupMenu',
        objectType: Menu,
        text: '${textKey:CreateArticleGroup}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'CreateArticleMenu',
        objectType: Menu,
        text: '${textKey:CreateArticle}',
        iconId: icons.PLUS,
        visible: false,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditEntryMenu',
        objectType: Menu,
        defaultMenu: true,
        text: '${textKey:Edit}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'ChangeStatusMenu',
        objectType: Menu,
        text: '${textKey:ChangeStatus}',
        iconId: icons.ROTATE_RIGHT,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteEntryMenu',
        objectType: Menu,
        text: '${textKey:Delete}',
        iconId: icons.REMOVE,
        menuTypes: [Table.MenuType.SingleSelection]
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class ArticleTable extends Table {
  declare widgetMap: ArticleTableWidgetMap;
  declare columnMap: ArticleTableColumnMap;
}

export type ArticleTableWidgetMap = {
  'CreateArticleGroupMenu': Menu;
  'CreateArticleMenu': Menu;
  'EditEntryMenu': Menu;
  'ChangeStatusMenu': Menu;
  'DeleteEntryMenu': Menu;
};

export type ArticleTableColumnMap = {
  'IdColumn': Column;
  'ParentKeyColumn': Column;
  'NameColumn': Column;
  'UnitColumn': Column;
  'PriceColumn': Column;
  'HasOptionsColumn': BooleanColumn;
  'ActiveColumn': BooleanColumn;
};
