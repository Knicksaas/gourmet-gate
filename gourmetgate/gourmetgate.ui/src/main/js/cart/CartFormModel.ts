import {Button, FormModel, GroupBox, TileField, TileGrid} from '@eclipse-scout/core';
import {CartHeaderBar, HeaderBarField} from '../index';

export default (): FormModel => ({
  id: 'gourmetgate.CartForm',
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    cssClass: 'cart-form-main-box',
    gridColumnCount: 1,
    fields: [
      {
        id: 'CartFormHeaderBar',
        objectType: HeaderBarField,
        headerBar: {
          objectType: CartHeaderBar
        }
      },
      {
        id: 'CartTileField',
        objectType: TileField,
        labelVisible: false,
        statusVisible: false,
        tileGrid: {
          objectType: TileGrid,
          cssClass: 'cart-tile-grid',
          gridColumnCount: 1,
          withPlaceholders: false,
          layoutConfig: {
            rowHeight: 60,
            columnWidth: 200,
            hgap: 10,
            vgap: 10
          }
        },
        gridDataHints: {
          fillVertical: true,
          h: 8
        }
      },
      {
        id: 'OrderButtonBox',
        objectType: GroupBox,
        gridColumnCount: 1,
        fields: [
          {
            id: 'BackButton',
            objectType: Button,
            processButton: false,
            label: '${textKey:NavigationBackward}',
            cssClass: 'cart-form-order-button',
            gridDataHints: {
              fillHorizontal: true
            },
            preventInitialFocus: true
          },
          {
            id: 'PayButton',
            objectType: Button,
            processButton: false,
            label: '${textKey:Pay}',
            cssClass: 'cart-form-order-button',
            gridDataHints: {
              fillHorizontal: true
            },
            defaultButton: true,
            preventInitialFocus: true
          }]
      }
    ],
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type CartFormWidgetMap = {
  'MainBox': GroupBox;
  'CartFormHeaderBar': HeaderBarField;
  'CartTileField': TileField;
  'OrderButtonBox': GroupBox;
  'BackButton': Button;
  'PayButton': Button;
};
