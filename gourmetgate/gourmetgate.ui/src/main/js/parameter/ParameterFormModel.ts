import {CancelMenu, Form, FormModel, GroupBox, OkMenu, StringField} from '@eclipse-scout/core';

export default (): FormModel => ({
  id: 'ParameterForm',
  objectType: Form,
  title: '${textKey:Parameter}',
  displayHint: Form.DisplayHint.DIALOG,
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    gridColumnCount: 1,
    fields: [
      {
        id: 'ParameterNameField',
        objectType: StringField,
        label: '${textKey:Name}',
        enabled: false
      },
      {
        id: 'ParameterValueField',
        objectType: StringField,
        label: '${textKey:Value}'
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

export type ParameterFormWidgetMap = {
  'MainBox': GroupBox;
  'ParameterNameField': StringField;
  'ParameterValueField': StringField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
