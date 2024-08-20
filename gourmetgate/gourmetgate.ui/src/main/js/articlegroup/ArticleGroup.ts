import $ from "jquery";

export class ArticleGroup {
  articleGroupId: string;
  name: string;
  enabled: boolean;

  static ENTITY_TYPE = 'articleGroup';

  init(model: any) {
    $.extend(this, model);
  }

  setArticleGroupId(id: string) {
    this.articleGroupId = id;
  }

  setName(name: string) {
    this.name = name;
  }

  setEnabled(status: boolean) {
    this.enabled = status;
  }
}
