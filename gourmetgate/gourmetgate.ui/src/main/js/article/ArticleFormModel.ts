import {
  CancelMenu,
  CheckBoxField,
  Form,
  FormModel,
  GroupBox,
  NumberField,
  OkMenu,
  SmartField,
  StringField
} from '@eclipse-scout/core';
import {ArticleGroupLookupCall, ArticleOptionTableField, VatLookupCall} from '../index';

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
            objectType: SmartField<string>,
            label: '${textKey:ArticleGroup}',
            mandatory: true,
            lookupCall: ArticleGroupLookupCall
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
            objectType: SmartField<string>,
            label: '${textKey:Vat}',
            mandatory: true,
            lookupCall: VatLookupCall
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
        fields: [
          {
            id: 'ArticleOptionTableField',
            objectType: ArticleOptionTableField
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

export type ArticleFormWidgetMap = {
  'MainBox': GroupBox;
  'ArticleConfigBox': GroupBox;
  'IdField': StringField;
  'NameField': StringField;
  'ArticleGroupField': SmartField<string>;
  'UnitField': StringField;
  'PriceField': NumberField;
  'VatField': SmartField<string>;
  'EnabledField': CheckBoxField;
  'HasOptionsField': CheckBoxField;
  'ArticleOptionsConfigBox': GroupBox;
  'ArticleOptionTableField': ArticleOptionTableField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
