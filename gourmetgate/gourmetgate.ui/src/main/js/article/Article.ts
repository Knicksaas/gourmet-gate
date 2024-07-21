export class Article {
  articleId: string;
  articleGroupId: string;
  name: string;
  description: string;
  price: number;
  options: boolean;
  status: string;
  cartCount: number;

  static ENTITY_TYPE = 'article';

  constructor() {
    this.price = 0;
    this.cartCount = 0;
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

  setDescription(description: string) {
    this.description = description;
  }

  setPrice(price: number) {
    this.price = price;
  }

  setOptions(options: boolean) {
    this.options = options;
  }

  setstatus(status: string) {
    this.status = status;
  }

  setCartCount(count: number) {
    this.cartCount = count;
  }
}
