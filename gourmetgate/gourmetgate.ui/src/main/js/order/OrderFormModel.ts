import {AccordionField, Button, FormModel, Group, GroupBox, HtmlTile, TileAccordion} from '@eclipse-scout/core';
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
          accordion: {
            id: 'OrderAcordion',
            objectType: TileAccordion,
            scrollable: true,
            textFilterEnabled: false,
            exclusiveExpand: true,
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
  'TestGroup': Group;
  'TestTile': HtmlTile;
  'OrderButtonBox': GroupBox;
  'OrderButton': Button;
};
