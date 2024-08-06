import {
  Event,
  EventHandler,
  Group,
  GroupEventMap,
  GroupModel,
  InitModelOf,
  scout,
  TileClickEvent,
  TileGrid,
  WidgetModel
} from "@eclipse-scout/core";
import ArticleAccordionGroupJsonModel from "./ArticleAccordionGroupJsonModel";
import {ArticleTile, OrderPositionOptionForm, OrderRepository} from "../index";

export interface ArticleAccordionGroupModel extends GroupModel<TileGrid<ArticleTile>> {
  articleGroupId?: string;
}

export interface ArticleAccordionGroupEventMap extends GroupEventMap {
  'incrementCartCount': Event;
}

export class ArticleAccordionGroup extends Group<TileGrid<ArticleTile>> implements ArticleAccordionGroupModel {
  declare model: ArticleAccordionGroupModel;
  declare eventMap: ArticleAccordionGroupEventMap;
  declare self: ArticleAccordionGroup;

  articleGroupId: string;
  protected _tileClickListener: EventHandler<TileClickEvent>;

  protected override _jsonModel(): WidgetModel {
    return ArticleAccordionGroupJsonModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this._tileClickListener = this._onTileClick.bind(this)
    this.body.on('tileClick', this._tileClickListener);
  }

  protected _onTileClick(event: TileClickEvent) {
    let tile = event.tile as ArticleTile;
    OrderRepository.get().createOrderPosition(tile.bean.articleId)
      .then(data => {
        if (tile.bean.options) {
          let optionsForm = this._showOptionsForm(tile, data.orderPositionId);
          optionsForm.one('close', () => this._incrementCartCount(tile));
        } else {
          this._incrementCartCount(tile);
        }
      });
  }

  protected _showOptionsForm(tile: ArticleTile, orderPositionId: string): OrderPositionOptionForm {
    let optionsForm = this._createOptionsForm(orderPositionId);
    optionsForm.setTitle('Optionen: ' + tile.bean.name);
    optionsForm.open();
    return optionsForm;
  }

  protected _createOptionsForm(orderPositionId: string): OrderPositionOptionForm {
    return scout.create(OrderPositionOptionForm, {
      parent: this,
      orderPositionId: orderPositionId
    });
  }

  protected _incrementCartCount(tile: ArticleTile) {
    tile.incrementCartCount();
    this.trigger('incrementCartCount');
  }

  override destroy() {
    this.body.off('tileClick', this._tileClickListener);
    super.destroy();
  }
}

