import {Article, ArticleCartCount, ArticleGroup} from "../index";
import $ from "jquery";

export class OrderFormData {
  articles: Article[];
  articleGroups: ArticleGroup[];
  articleCartCounts: ArticleCartCount[];

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

  setArticleCartCounts(articleCartCounts: ArticleCartCount[]) {
    this.articleCartCounts = articleCartCounts;
  }
}
