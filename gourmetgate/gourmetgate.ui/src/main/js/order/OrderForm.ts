import {
  arrays,
  EventHandler,
  Form,
  InitModelOf,
  scout,
  TileAccordion,
  TileGrid,
  WidgetModel
} from "@eclipse-scout/core";
import OrderFormModel, {OrderFormWidgetMap} from './OrderFormModel';
import {
  Article,
  ArticleAccordionGroup,
  ArticleCartCount,
  ArticleGroup,
  ArticleTile,
  DataChangeEvent,
  OrderFormData,
  OrderFormRepository
} from "../index";

export class OrderForm extends Form {
  declare widgetMap: OrderFormWidgetMap;
  declare data: OrderFormData;

  protected _allGroups: ArticleAccordionGroup[];
  protected _allTiles: ArticleTile[];
  protected _dataChangeListener: EventHandler<DataChangeEvent>;

  protected override _jsonModel(): WidgetModel {
    return OrderFormModel();
  }

  override init(model: InitModelOf<this>) {
    super.init(model);

    this._dataChangeListener = this._onDataChange.bind(this);
    this.session.desktop.on('dataChange', this._dataChangeListener);
  }

  protected _onDataChange(event: DataChangeEvent) {
    if (event.dataType === ArticleCartCount.ENTITY_TYPE) {
      this._mapCartCounts(arrays.ensure(event.data));
    }
  }

  protected override _load(): JQuery.Promise<OrderFormData> {
    return OrderFormRepository.get().formData();
  }


  protected override _destroy() {
    this.session.desktop.off('dataChange', this._dataChangeListener);
    super._destroy();
  }

  override importData() {
    this._allGroups = [];
    this._allTiles = [];

    let accordion = this.widget('OrderAcordion');
    this._allGroups = this.data.articleGroups
      .map(group => this._createArticleGroup(group, accordion));

    this.data.articles.forEach(article => {
      let tileGrid = this._getTileGridForArticleGroupId(this._allGroups, article.articleGroupId);
      let tile = this._createArticleTile(article, tileGrid);
      this._allTiles.push(tile);
      tileGrid.insertTile(tile);
    });
    accordion.setGroups(this._allGroups);

    this._mapCartCounts(this.data.articleCartCounts);
  }

  protected _createArticleGroup(articleGroup: ArticleGroup, parent: TileAccordion): ArticleAccordionGroup {
    return scout.create(ArticleAccordionGroup, {
      parent: parent,
      articleGroupId: articleGroup.articleGroupId,
      title: articleGroup.name
    });
  }

  protected _getTileGridForArticleGroupId(groups: ArticleAccordionGroup[], articleGroupId: string): TileGrid {
    let group = groups.find(group => group.articleGroupId === articleGroupId);
    if (group) {
      return group.body;
    } else if (groups.length > 0) {
      return group[0].body;
    }
    return null;
  }

  protected _createArticleTile(article: Article, parent: TileGrid): ArticleTile {
    return scout.create(ArticleTile, {
      parent: parent,
      bean: article
    });
  }

  protected _mapCartCounts(cartCounts: ArticleCartCount[]) {
    cartCounts.forEach(cartCount => {
      let tile = this._allTiles.find(tile => tile.bean.articleId === cartCount.articleId);
      if (tile) {
        tile.setCartCount(cartCount.cartCount);
      }
    });
  }
}
