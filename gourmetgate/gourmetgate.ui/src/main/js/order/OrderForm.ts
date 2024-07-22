import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import OrderFormModel, {OrderFormWidgetMap} from './OrderFormModel';
import {Article, ArticleRepository, ArticleTile} from "../index";

export class OrderForm extends Form {
  declare widgetMap: OrderFormWidgetMap;
  declare data: Article[];

  protected override _jsonModel(): WidgetModel {
    return OrderFormModel();
  }

  override importData() {
    let tileGrid = this.widget('OrderAcordion').groups[0].body;
    let tiles = this.data.map(article => {
      return scout.create(ArticleTile, {
        parent: tileGrid,
        bean: article,
        cartCount: 10
      });
    })
    tileGrid.insertTiles(tiles)
  }

  override open(): JQuery.Promise<void> {
    return super.open();
  }

  override load(allowReload?: boolean): JQuery.Promise<void> {
    return super.load(allowReload);
  }

  protected override _load(): JQuery.Promise<Article[]> {
    return ArticleRepository.get().all();
  }
}
