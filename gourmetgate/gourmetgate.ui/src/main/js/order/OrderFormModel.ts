import {
  AccordionField,
  Button,
  FormModel,
  Group,
  GroupBox,
  HtmlTile,
  TileAccordion,
  TileGrid
} from '@eclipse-scout/core';

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
            groups: [{
              id: 'TestGroup',
              objectType: Group,
              title: '${textKey:All}',
              body: {
                objectType: TileGrid,
                gridColumnCount: 3,
                tiles: [{
                  id: 'TestTile',
                  objectType: HtmlTile,
                  content: '<h1>hoi</h1>'
                }]
              }
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
