import {Column, icons, Menu, Table, TableField, TableFieldModel} from "@eclipse-scout/core";

export default (): TableFieldModel => ({
  id: 'ArticleOptionTableField',
  objectType: TableField,
  labelVisible: false,
  enabled: false,
  gridDataHints: {
    h: 5
  },
  table: {
    id: 'ArticleOptionTable',
    objectType: Table,
    autoResizeColumns: true,
    columns: [
      {
        id: 'ArticleOptionIdColumn',
        objectType: Column,
        text: '${textKey:Id}',
        visible: false
      },
      {
        id: 'ArticleIdColumn',
        objectType: Column,
        text: '${textKey:ArticleId}',
        visible: false
      },
      {
        id: 'ArticleOptionDescriptionColumn',
        objectType: Column,
        text: '${textKey:Name}',
        editable: true
      }
    ],
    menus: [
      {
        id: 'AddArticleOptionMenu',
        objectType: Menu,
        text: '${textKey:New}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'DeleteArticleOptionMenu',
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

export type ArticleOptionTableFieldWidgetMap = {
  'ArticleOptionTable': ArticleOptionTable;
} & ArticleOptionTableWidgetMap;

export class ArticleOptionTable extends Table {
  declare widgetMap: ArticleOptionTableWidgetMap;
  declare columnMap: ArticleOptionTableColumnMap;
}

export type ArticleOptionTableWidgetMap = {
  'AddArticleOptionMenu': Menu;
  'DeleteArticleOptionMenu': Menu;
};

export type ArticleOptionTableColumnMap = {
  'ArticleOptionIdColumn': Column;
  'ArticleIdColumn': Column;
  'ArticleOptionDescriptionColumn': Column;
};
