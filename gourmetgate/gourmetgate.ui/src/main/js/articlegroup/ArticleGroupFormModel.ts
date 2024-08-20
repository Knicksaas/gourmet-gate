import {CancelMenu, CheckBoxField, Form, FormModel, GroupBox, OkMenu, StringField} from '@eclipse-scout/core';

export default (): FormModel => ({
  id: 'ArticleGroupForm',
  objectType: Form,
  title: '${textKey:ArticleGroup}',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    labelVisible: false,
    gridColumnCount: 1,
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
        maxLength: 80
      },
      {
        id: 'EnabledField',
        objectType: CheckBoxField,
        label: '${textKey:Enabled}'
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
})

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type ArticleGroupFormWidgetMap = {
  'MainBox': GroupBox;
  'IdField': StringField;
  'NameField': StringField;
  'EnabledField': CheckBoxField;
};
