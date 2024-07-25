import {EventHandler, Group, GroupModel, InitModelOf, TileClickEvent, TileGrid, WidgetModel} from "@eclipse-scout/core";
import ArticleAccordionGroupJsonModel from "./ArticleAccordionGroupJsonModel";
import {ArticleTile, OrderRepository} from "../index";

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
    OrderRepository.get().addArticle((<ArticleTile>event.tile).bean.articleId);
  }

  override destroy() {
    this.body.off('tileClick', this._tileClickListener);
    super.destroy();
  }
}
