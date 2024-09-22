import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './ggicons';
export * from './repository/Repository';
export * from './repository/GenericRequestBody';
export * from './desktop/PageWithData';
export * from './widget/headerbar/HeaderBar';
export * from './widget/headerbar/HeaderBarEventMap';
export * from './widget/headerbar/HeaderBarModel';
export * from './widget/headerbar/HeaderBarField';
export * from './widget/headerbar/HeaderBarFieldModel';
export * from './widget/info/InfoForm';
export * from './widget/info/InfoPage';
export * from './widget/info/InfoTile';
export * from './widget/info/InfoTileBean';
export * from './desktop/AppRoute';
export * from './desktop/Desktop';
export * from './desktop/DesktopModel';
export * from './desktop/ShopOutline';
export * from './desktop/ShopOutlineModel';
export * from './parameter/Parameter';
export * from './parameter/BooleanParameter';
export * from './parameter/NumberParameter';
export * from './parameter/ParameterForm';
export * from './parameter/ParameterRepository';
export * from './parameter/ParameterTablePage';
export * from './application/ApplicationPausedParameter';
export * from './article/Article';
export * from './article/ArticleAccordionGroup';
export * from './article/ArticleForm';
export * from './article/ArticleRepository';
export * from './article/ArticleTablePage';
export * from './article/ArticleTablePageEntry';
export * from './article/ArticleTablePageModel';
export * from './article/ArticleTile';
export * from './article/options/ArticleOption';
export * from './article/options/ArticleOptionTableField';
export * from './articlegroup/ArticleGroup';
export * from './articlegroup/ArticleGroupRepository';
export * from './articlegroup/ArticleGroupForm';
export * from './articlegroup/ArticleGroupLookupCall';
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
export * from './infopages/KitchenClosedInfoPage';
export * from './infopages/PaymentStateInfoPage';
export * from './infopages/ScanQrCodeInfoPage';
export * from './payment/Redirect';
export * from './table/HallForm';
export * from './table/HallFormData';
export * from './table/Table';
export * from './table/TableTile';
export * from './table/TableRepository';
export * from './table/TableRowCountParameter';
export * from './table/TablesPerRowParameter';
export * from './table/TableLayoutForm';
export * from './vat/Vat';
export * from './vat/VatLookupCall';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
