import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './repository/Repository';
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
export * from './order/OrderForm';
export * from './order/OrderFormData';
export * from './order/OrderFormRepository';
export * from './person/Person';
export * from './person/PersonForm';
export * from './person/PersonFormModel';
export * from './person/PersonRepository';
export * from './person/PersonRestriction';
export * from './person/PersonSearchForm';
export * from './person/PersonSearchFormModel';
export * from './person/PersonTablePage';
export * from './person/PersonTablePageModel';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
