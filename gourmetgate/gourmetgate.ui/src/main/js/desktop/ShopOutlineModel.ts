import {Outline, OutlineModel} from '@eclipse-scout/core';
import {CartForm, OrderForm} from '../index';
import {PageWithData} from './PageWithData';
import {ArticleTablePage} from '../article/ArticleTablePage';

export default (): OutlineModel => ({
  id: 'gourmetgate.DataOutline',
  title: '${textKey:Shop}',
  objectType: Outline,
  nodes: [
    {
      id: OrderForm.PageId,
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
      id: CartForm.PageId,
      objectType: PageWithData,
      leaf: true,
      navigateButtonsVisible: false,
      text: '${textKey:Pay}',
      detailForm: {
        objectType: CartForm,
      },
      detailTableVisible: false
    },
    {
      objectType: ArticleTablePage
    }
  ]
});

export type ShopOutlineWidgetMap = {
  'gourmetgate.DataOutline': Outline;
};
