import $ from "jquery";

export class ArticleOption {

  articleOptionId: string;
  articleId: string;
  description: string;

  static ENTITY_TYPE = 'articleOption';

  init(model: any) {
    $.extend(this, model);
  }
}
