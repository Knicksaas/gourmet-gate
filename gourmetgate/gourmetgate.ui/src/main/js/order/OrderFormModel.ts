import {AccordionField, Button, FormModel, GroupBox, TileAccordion} from '@eclipse-scout/core';
import {ArticleAccordionGroup, ArticleTile, HeaderBarField, OrderHeaderBar} from '../index';

export default (): FormModel => ({
  id: 'gourmetgate.OrderForm',
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    cssClass: 'order-form-main-box',
    fields: [
      {
        id: 'OrderFormHeaderBar',
        objectType: HeaderBarField,
        headerBar: {
          objectType: OrderHeaderBar
        }
      },
      {
        id: 'TileAccordionBox',
        objectType: GroupBox,
        fields: [
          {
            id: 'OrderAccordionField',
            objectType: AccordionField,
            labelVisible: false,
            statusVisible: false,
            accordion: {
              id: 'OrderAcordion',
              objectType: TileAccordion<ArticleTile>,
              scrollable: true,
              textFilterEnabled: false,
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
          cssClass: 'order-form-order-button',
          gridDataHints: {
            fillHorizontal: true
          },
          defaultButton: true,
          preventInitialFocus: true
        }]
      }]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type OrderFormWidgetMap = {
  'MainBox': GroupBox;
  'OrderFormHeaderBar': HeaderBarField;
  'TileAccordionBox': GroupBox;
  'OrderAccordionField': AccordionField;
  'OrderAcordion': TileAccordion<ArticleTile>;
  'OrderButtonBox': GroupBox;
  'OrderButton': Button;
};
