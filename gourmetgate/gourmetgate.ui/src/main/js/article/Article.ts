import $ from "jquery";

export class Article {
  articleId: string;
  articleGroupId: string;
  name: string;
  unit: string;
  price: number;
  options: boolean;
  vatId: string;
  cartCount: number;
  enabled: boolean;

  static ENTITY_TYPE = 'article';

  constructor() {
    this.articleId = null;
    this.articleGroupId = null;
    this.name = null;
    this.unit = null;
    this.price = 0;
    this.options = null;
    this.vatId = null;
    this.cartCount = 0;
    this.enabled = null;
  }

  init(model: any) {
    $.extend(this, model);
  }

  setArticleId(id: string) {
    this.articleId = id;
  }

  setArticleGroupId(id: string) {
    this.articleGroupId = id;
  }

  setName(name: string) {
    this.name = name;
  }

  setUnit(unit: string) {
    this.unit = unit;
  }

  setPrice(price: number) {
    this.price = price;
  }

  setOptions(options: boolean) {
    this.options = options;
  }

  setEnabled(status: boolean) {
    this.enabled = status;
  }

  setCartCount(count: number) {
    this.cartCount = count;
  }
}
