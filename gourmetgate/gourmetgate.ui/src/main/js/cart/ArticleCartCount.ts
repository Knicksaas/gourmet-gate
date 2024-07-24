import $ from "jquery";

export class ArticleCartCount {

  articleId: string;
  cartCount: number;

  static ENTITY_TYPE = 'articleCartCount';

  init(model: any) {
    $.extend(this, model);
  }
}
