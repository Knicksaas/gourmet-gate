import {Form, InitModelOf, scout, texts, Tile, TileGrid, WidgetModel} from "@eclipse-scout/core";
import {CartFormData, CartItem, CartRepository, Desktop, OrderPositionTile, PaymentRepository} from "../index";
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

    this.widget('BackButton').on('click', this._onBackButtonClick.bind(this));
    this.widget('PayButton').on('click', this._onPayButtonClick.bind(this));
    this.widget('CartTileGrid').on('propertyChange:tiles', event => this._recalculatePrice(event.newValue));
  }

  protected override _load(): JQuery.Promise<any> {
    return CartRepository.get().getFormData();
  }

  override importData() {
    let tileGrid = this.widget('CartTileField').tileGrid;
    let tiles = this.data.cartItems
      .map(i => this._createOrderPositionTile(tileGrid, i));
    tileGrid.setTiles(tiles);
    let labelText = texts.resolveText('${textKey:Pay}', this.session.locale.languageTag) + ` (${this.data.price} CHF)`;
    this.widget('PayButton').setLabel(labelText)
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

  protected _onPayButtonClick() {
    this.widget('PayButton').setLoading(true);
    PaymentRepository.get().createPayment()
      .then(redirect => {
        window.location.href = redirect.redirectUrl;
      })
  }

  protected _recalculatePrice(newValue: Tile[]) {
    let tiles = newValue as OrderPositionTile[];
    let price = tiles.map(t => t.bean.price).reduce((acc, val) => acc + val, 0);
    let labelText = texts.resolveText('${textKey:Pay}', this.session.locale.languageTag) + ` (${price} CHF)`;
    this.widget('PayButton').setLabel(labelText)
  }
}
