import $ from "jquery";

export class ArticleGroup {
  articleGroupId: string;
  name: string;
  status: string;

  static ENTITY_TYPE = 'articleGroup';

  constructor() {
    this.articleGroupId = null;
    this.name = null;
    this.status = null;
  }

  init(model: any) {
    $.extend(this, model);
  }

  setArticleGroupId(id: string) {
    this.articleGroupId = id;
  }

  setName(name: string) {
    this.name = name;
  }

  setstatus(status: string) {
    this.status = status;
  }
}
