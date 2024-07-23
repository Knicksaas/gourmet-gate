import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import OrderFormModel, {OrderFormWidgetMap} from './OrderFormModel';
import {ArticleTile, OrderFormData, OrderFormRepository} from "../index";

export class OrderForm extends Form {
  declare widgetMap: OrderFormWidgetMap;
  declare data: OrderFormData;

  protected override _jsonModel(): WidgetModel {
    return OrderFormModel();
  }

  override importData() {
    let tileGrid = this.widget('OrderAcordion').groups[0].body;
    let tiles = this.data.articles.map(article => {
      return scout.create(ArticleTile, {
        parent: tileGrid,
        bean: article,
        cartCount: 10
      });
    })
    tileGrid.insertTiles(tiles)
  }

  protected override _load(): JQuery.Promise<OrderFormData> {
    return OrderFormRepository.get().formData();
  }
}
