import {Outline, OutlineModel} from '@eclipse-scout/core';
import {
  ArticleTablePage,
  CartForm,
  HallForm,
  InfoPage,
  KitchenClosedInfoForm,
  OrderForm,
  PageWithData,
  ParameterTablePage,
  PaymentStateInfoForm,
  ScanQrCodeInfoForm
} from '../index';


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
    },
    {
      id: HallForm.PageId,
      objectType: PageWithData,
      leaf: true,
      navigateButtonsVisible: false,
      text: '${textKey:Tables}',
      detailForm: {
        objectType: HallForm,
      },
      detailTableVisible: false
    },
    {
      objectType: ParameterTablePage
    },
    {
      text: '${textKey:PaymentState}',
      objectType: InfoPage,
      routeRef: 'paymentState',
      detailForm: {
        objectType: PaymentStateInfoForm
      }
    },
    {
      text: '${textKey:Pause}',
      objectType: InfoPage,
      routeRef: 'pause',
      detailForm: {
        objectType: KitchenClosedInfoForm
      }
    },
    {
      text: '${textKey:UserGuide}',
      objectType: InfoPage,
      routeRef: 'userGuide',
      detailForm: {
        objectType: ScanQrCodeInfoForm
      }
    }
  ]
});
