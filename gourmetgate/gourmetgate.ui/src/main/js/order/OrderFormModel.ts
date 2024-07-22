import {AccordionField, Button, FormModel, GroupBox, TileAccordion} from '@eclipse-scout/core';
import {ArticleAccordionGroup} from '../index';

export default (): FormModel => ({
  id: 'gourmetgate.OrderForm',
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    fields: [
      {
        id: 'TileAccordionBox',
        objectType: GroupBox,
        fields: [{
          id: 'OrderAccordionField',
          objectType: AccordionField,
          labelVisible: false,
          statusVisible: false,
          accordion: {
            id: 'OrderAcordion',
            objectType: TileAccordion,
            scrollable: true,
            textFilterEnabled: false,
            exclusiveExpand: true,
            cssClass: 'order-accordion',
            groups: [{
              objectType: ArticleAccordionGroup
            }],
          },
          gridDataHints: {
            fillVertical: true,
            h: 8
          }
        }]
      },
      {
        id: 'OrderButtonBox',
        objectType: GroupBox,
        fields: [{
          id: 'OrderButton',
          objectType: Button,
          processButton: false,
          label: '${textKey:Order}',
          gridDataHints: {
            fillHorizontal: true
          }
        }]
      }]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type OrderFormWidgetMap = {
  'MainBox': GroupBox;
  'TileAccordionBox': GroupBox;
  'OrderAccordionField': AccordionField;
  'OrderAcordion': TileAccordion;
  'OrderButtonBox': GroupBox;
  'OrderButton': Button;
};
