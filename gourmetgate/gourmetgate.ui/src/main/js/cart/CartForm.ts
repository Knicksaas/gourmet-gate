import {Form, scout, texts, TileGrid, WidgetModel} from "@eclipse-scout/core";
import {CartFormData, CartItem, CartRepository, OrderPositionTile} from "../index";
import CartFormModel, {CartFormWidgetMap} from './CartFormModel';

export class CartForm extends Form {
  declare widgetMap: CartFormWidgetMap;
  declare data: CartFormData;

  protected override _jsonModel(): WidgetModel {
    return CartFormModel();
  }

  protected override _load(): JQuery.Promise<any> {
    return CartRepository.get().getFormData();
  }

  override importData() {
    let tileGrid = this.widget('CartTileField').tileGrid;
    let tiles = this.data.cartItems
      .map(i => this._createOrderPositionTile(tileGrid, i));
    tileGrid.setTiles(tiles);
    this.widget('PayButton').setLabel(texts.resolveKey('Pay') + ' (' + this.data.price + ' CHF)')
  }

  protected _createOrderPositionTile(parent: TileGrid, data: CartItem): OrderPositionTile {
    return scout.create(OrderPositionTile, {
      parent: parent,
      bean: data
    });
  }
}
