import {Form, scout, TileAccordion, TileGrid, WidgetModel} from "@eclipse-scout/core";
import OrderFormModel, {OrderFormWidgetMap} from './OrderFormModel';
import {Article, ArticleAccordionGroup, ArticleGroup, ArticleTile, OrderFormData, OrderFormRepository} from "../index";

export class OrderForm extends Form {
  declare widgetMap: OrderFormWidgetMap;
  declare data: OrderFormData;

  protected override _jsonModel(): WidgetModel {
    return OrderFormModel();
  }

  protected override _load(): JQuery.Promise<OrderFormData> {
    return OrderFormRepository.get().formData();
  }

  override importData() {
    let accordion = this.widget('OrderAcordion');
    let groups = this.data.articleGroups
      .map(group => this._createArticleGroup(group, accordion));

    this.data.articles.forEach(article => {
      let tileGrid = this._getTileGridForArticleGroupId(groups, article.articleGroupId);
      let tile = this._createArticleTile(article, tileGrid);
      tileGrid.insertTile(tile);
    });
    accordion.setGroups(groups);
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
      bean: article,
      cartCount: 10
    });
  }
}
