import {App, ArticleCartCount, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: OrderRepository;

export class OrderRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}order/`;
  }

  addArticle(articleId: string) {
    this.postJson(this.targetUrl + 'position/' + articleId)
      .then(data => this._first(data) as ArticleCartCount)
      .then(data => this._triggerDataChange(data, ArticleCartCount.ENTITY_TYPE));
  }

  static get(): OrderRepository {
    if (!repository) {
      repository = scout.create(OrderRepository);
    }
    return repository;
  }
}
