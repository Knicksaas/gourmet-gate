import {Outline, OutlineModel, PageWithNodes} from '@eclipse-scout/core';
import {OrderForm, PersonTablePage} from '../index';

export default (): OutlineModel => ({
  id: 'gourmetgate.DataOutline',
  title: '${textKey:MyDataOutlineTitle}',
  objectType: Outline,
  nodes: [
    {
      objectType: PersonTablePage
    },
    {
      objectType: PageWithNodes,
      leaf: true,
      navigateButtonsVisible: false,
      text: '${textKey:Order}',
      detailForm: {
        objectType: OrderForm
      }
    }
  ]
});

export type DataOutlineWidgetMap = {
  'gourmetgate.DataOutline': Outline;
};
