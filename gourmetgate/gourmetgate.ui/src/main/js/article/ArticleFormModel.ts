import {
  CancelMenu,
  CheckBoxField,
  Column,
  Form,
  FormModel,
  GroupBox,
  icons,
  Menu,
  NumberField,
  OkMenu,
  SmartField,
  StringField,
  Table,
  TableField
} from '@eclipse-scout/core';

export default (): FormModel => ({
  id: 'ArticleForm',
  objectType: Form,
  title: '${textKey:Articles}',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    fields: [
      {
        id: 'ArticleConfigBox',
        objectType: GroupBox,
        labelVisible: false,
        fields: [
          {
            id: 'IdField',
            objectType: StringField,
            label: '${textKey:Id}',
            enabled: false
          },
          {
            id: 'NameField',
            objectType: StringField,
            label: '${textKey:Name}',
            maxLength: 80,
            mandatory: true
          },
          {
            id: 'ArticleGroupField',
            objectType: SmartField,
            label: '${textKey:ArticleGroup}',
            mandatory: true
          },
          {
            id: 'UnitField',
            objectType: StringField,
            label: '${textKey:Unit}',
            maxLength: 80,
            mandatory: true
          },
          {
            id: 'PriceField',
            objectType: NumberField,
            label: '${textKey:Price}',
            mandatory: true,
          },
          {
            id: 'VatField',
            objectType: SmartField,
            label: '${textKey:Vat}',
            mandatory: true
          },
          {
            id: 'EnabledField',
            objectType: CheckBoxField,
            label: '${textKey:Enabled}'
          },
          {
            id: 'HasOptionsField',
            objectType: CheckBoxField,
            label: '${textKey:HasOptions}',
          }
        ]
      },
      {
        id: 'ArticleOptionsConfigBox',
        objectType: GroupBox,
        label: '${textKey:ArticleOptions}',
        labelVisible: true,
        enabled: false,
        fields: [{
          id: 'ArticleOptionTableField',
          objectType: TableField,
          labelVisible: false,
          table: {
            id: 'ArticleOptionTable',
            objectType: Table,
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
        }]
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

export type ArticleFormWidgetMap = {
  'MainBox': GroupBox;
  'ArticleConfigBox': GroupBox;
  'IdField': StringField;
  'NameField': StringField;
  'ArticleGroupField': SmartField<any>;
  'UnitField': StringField;
  'PriceField': NumberField;
  'VatField': SmartField<any>;
  'EnabledField': CheckBoxField;
  'HasOptionsField': CheckBoxField;
  'ArticleOptionsConfigBox': GroupBox;
  'ArticleOptionTableField': TableField;
  'ArticleOptionTable': ArticleOptionTable;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
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
