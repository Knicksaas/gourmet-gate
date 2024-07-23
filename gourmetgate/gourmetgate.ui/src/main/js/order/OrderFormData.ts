import {Article, ArticleGroup} from "../index";
import $ from "jquery";

export class OrderFormData {
  articles: Article[];
  articleGroups: ArticleGroup[];

  static ENTITY_TYPE = 'orderFormData';

  init(model: any) {
    $.extend(this, model);
  }

  setArticles(articles: Article[]) {
    this.articles = articles;
  }

  setArticleGroups(articleGroups: ArticleGroup[]) {
    this.articleGroups = articleGroups;
  }
}
