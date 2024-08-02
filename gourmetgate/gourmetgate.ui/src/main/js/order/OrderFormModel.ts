import {AccordionField, Button, FormModel, GroupBox, TileAccordion} from '@eclipse-scout/core';
import {ArticleAccordionGroup, ArticleTile, ggicons, HeaderBar, HeaderBarField} from '../index';

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
          objectType: HeaderBar,
          title: '${textKey:Order}',
          iconId: ggicons.SHOPPING_CART,
          cartCount: 10
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
