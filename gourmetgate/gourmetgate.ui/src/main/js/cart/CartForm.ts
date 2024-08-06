import {Form, InitModelOf, scout, texts, TileGrid, WidgetModel} from "@eclipse-scout/core";
import {CartFormData, CartItem, CartRepository, Desktop, OrderPositionTile} from "../index";
import CartFormModel, {CartFormWidgetMap} from './CartFormModel';

export class CartForm extends Form {
  declare widgetMap: CartFormWidgetMap;
  declare data: CartFormData;

  static PageId: string = 'CartPage';

  protected override _jsonModel(): WidgetModel {
    return CartFormModel();
  }


  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this.widget('BackButton').on('click', this._onBackButtonClick.bind(this))
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

  protected _onBackButtonClick() {
    (<Desktop>this.findDesktop()).activateOrderPage();
  }
}
