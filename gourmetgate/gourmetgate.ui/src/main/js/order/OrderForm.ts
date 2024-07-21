import {Form, WidgetModel} from "@eclipse-scout/core";
import OrderFormModel, {OrderFormWidgetMap} from './OrderFormModel';

export class OrderForm extends Form {
  declare widgetMap: OrderFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return OrderFormModel();
  }
}
