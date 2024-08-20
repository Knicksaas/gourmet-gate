import $ from "jquery";

export class ArticleTablePageEntry {

  id: string;
  parentId: string;
  name: string;
  unit: string;
  price: number;
  options: boolean;
  enabled: boolean;

  static ENTITY_TYPE = 'articleTablePageEntry';

  init(model: any) {
    $.extend(this, model);
  }
}
