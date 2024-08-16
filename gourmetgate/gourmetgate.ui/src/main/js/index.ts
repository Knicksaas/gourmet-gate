import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './ggicons';
export * from './repository/Repository';
export * from './repository/GenericRequestBody';
export * from './widget/HeaderBar';
export * from './widget/HeaderBarEventMap';
export * from './widget/HeaderBarModel';
export * from './widget/HeaderBarField';
export * from './widget/HeaderBarFieldModel';
export * from './desktop/Desktop';
export * from './desktop/DesktopModel';
export * from './desktop/DataOutline';
export * from './desktop/DataOutlineModel';
export * from './article/Article';
export * from './article/ArticleAccordionGroup';
export * from './article/ArticleRepository';
export * from './article/ArticleTile';
export * from './articlegroup/ArticleGroup';
export * from './cart/ArticleCartCount';
export * from './cart/CartForm';
export * from './cart/CartFormData';
export * from './cart/CartHeaderBar';
export * from './cart/OrderPositionTile';
export * from './cart/CartItem';
export * from './cart/CartRepository';
export * from './order/OrderForm';
export * from './order/OrderFormData';
export * from './order/OrderFormRepository';
export * from './order/OrderHeaderBar';
export * from './order/OrderPosition';
export * from './order/OrderRepository';
export * from './order/options/OrderPositionOption';
export * from './order/options/OrderPositionOptionForm';
export * from './order/options/OrderPositionOptionsListBox';
export * from './order/options/OrderPositionOptionsLookupCall';
export * from './payment/PaymentRepository';
export * from './payment/Redirect';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
