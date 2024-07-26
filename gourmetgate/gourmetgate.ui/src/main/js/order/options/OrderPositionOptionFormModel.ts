import {FormModel, GroupBox} from '@eclipse-scout/core';
import {OrderPositionOptionsListBox} from '../../index';

export default (): FormModel => ({
  id: 'gourmetgate.OrderPositionOptionForm',
  displayHint: 'dialog',
  resizable: false,
  movable: false,
  rootGroupBox: {
    id: 'MainBox',
    objectType: 'GroupBox',
    gridColumnCount: 1,
    fields: [{
      id: 'OptionsBox',
      objectType: GroupBox,
      fields: [{
        id: 'OptionsListField',
        objectType: OrderPositionOptionsListBox,
        labelVisible: false,
        statusVisible: false,
        gridDataHints: {
          h: 3
        }
      }]
    }]
  }
});
