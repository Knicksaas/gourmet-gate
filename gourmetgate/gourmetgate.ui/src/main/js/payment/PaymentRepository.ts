import {App, Article, Redirect, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: PaymentRepository;

export class PaymentRepository extends Repository {

  constructor() {
    super();

    this.entityType = Article.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}payment/`;
  }

  createPayment(): JQuery.Promise<Redirect> {
    return this.postJson(this.targetUrl)
      .then(data => this._first(data))
      .catch(error => this._handleError(error));
  }

  static get(): PaymentRepository {
    if (!repository) {
      repository = scout.create(PaymentRepository);
    }
    return repository;
  }
}
