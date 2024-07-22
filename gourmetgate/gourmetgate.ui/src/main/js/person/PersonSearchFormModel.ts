import {Action, FormModel, GroupBox, Menu, ResetMenu, StringField} from '@eclipse-scout/core';

export default (): FormModel => ({
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    fields: [
      {
        id: 'DetailBox',
        objectType: GroupBox,
        gridColumnCount: 2,
        fields: [
          {
            id: 'FirstNameField',
            objectType: StringField,
            maxLength: 200,
            label: '${textKey:FirstName}'
          },
          {
            id: 'LastNameField',
            objectType: StringField,
            maxLength: 200,
            label: '${textKey:LastName}'
          }
        ]
      }
    ],
    menus: [
      {
        id: 'SearchButton',
        objectType: Menu,
        actionStyle: Action.ActionStyle.BUTTON,
        text: '${textKey:Search}',
        keyStroke: 'ENTER'
      },
      {
        id: 'ResetMenu',
        objectType: ResetMenu
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type PersonSearchFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailBox': GroupBox;
  'FirstNameField': StringField;
  'LastNameField': StringField;
  'SearchButton': Menu;
  'ResetMenu': ResetMenu;
};
