import {Article, Repository} from "../index";
import {App} from "../App";
import {scout} from "@eclipse-scout/core";
import {OrderFormData} from "./OrderFormData";

let repository: OrderFormRepository;

export class OrderFormRepository extends Repository {

  constructor() {
    super();

    this.entityType = Article.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}orderForm/`;
  }

  formData(): JQuery.Promise<OrderFormData> {
    return this.getJson(this.targetUrl + 'formData')
      .then(data => this._first(data) as OrderFormData);
  }

  static get(): OrderFormRepository {
    if (!repository) {
      repository = scout.create(OrderFormRepository);
    }
    return repository;
  }
}
