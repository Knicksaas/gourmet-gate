import {Outline, OutlineModel} from '@eclipse-scout/core';
import {CartForm, OrderForm, PersonTablePage} from '../index';
import {PageWithData} from './PageWithData';

export default (): OutlineModel => ({
  id: 'gourmetgate.DataOutline',
  title: '${textKey:MyDataOutlineTitle}',
  objectType: Outline,
  nodes: [
    {
      objectType: PersonTablePage
    },
    {
      objectType: PageWithData,
      leaf: true,
      navigateButtonsVisible: false,
      text: '${textKey:Order}',
      detailForm: {
        objectType: OrderForm,
      },
      detailTableVisible: false
    },
    {
      objectType: PageWithData,
      leaf: true,
      navigateButtonsVisible: false,
      text: '${textKey:Pay}',
      detailForm: {
        objectType: CartForm,
      },
      detailTableVisible: false
    }
  ]
});

export type DataOutlineWidgetMap = {
  'gourmetgate.DataOutline': Outline;
};
