import {FormModel, GroupBox} from '@eclipse-scout/core';
import {OrderPositionOptionsListBox, OrderPositionOptionsLookupCall} from '../../index';

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
        lookupCall: OrderPositionOptionsLookupCall,
        labelVisible: false,
        statusVisible: false,
        gridDataHints: {
          h: 3
        }
      }]
    }]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type OrderPositionOptionFormJsonWidgetMap = {
  'OptionsBox': GroupBox;
  'OptionsListField': OrderPositionOptionsListBox;
};
