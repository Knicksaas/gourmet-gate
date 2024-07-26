import {
  EventHandler,
  Group,
  GroupModel,
  InitModelOf,
  scout,
  TileClickEvent,
  TileGrid,
  WidgetModel
} from "@eclipse-scout/core";
import ArticleAccordionGroupJsonModel from "./ArticleAccordionGroupJsonModel";
import {ArticleTile, OrderRepository} from "../index";
import {OrderPositionOptionForm} from "../order/options/OrderPositionOptionForm";

export interface ArticleAccordionGroupModel extends GroupModel<TileGrid<ArticleTile>> {
  articleGroupId?: string;
}

export class ArticleAccordionGroup extends Group<TileGrid<ArticleTile>> implements ArticleAccordionGroupModel {
  declare model: ArticleAccordionGroupModel;

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
    OrderRepository.get().addArticle(tile.bean.articleId);
    if (tile.bean.options) {
      let optionsForm = this._createOptionsForm(tile.bean.articleId);
      optionsForm.setTitle('Optionen: ' + tile.bean.name);
      optionsForm.open();
    }
  }

  protected _createOptionsForm(articleId: string): OrderPositionOptionForm {
    return scout.create(OrderPositionOptionForm, {
      parent: this
    });
  }

  override destroy() {
    this.body.off('tileClick', this._tileClickListener);
    super.destroy();
  }
}

