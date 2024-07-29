import {App, OrderPosition, OrderPositionOption, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: OrderRepository;

export class OrderRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}order/`;
  }

  createOrderPosition(articleId: string): JQuery.Promise<OrderPosition> {
    return this.postJson(this.targetUrl + 'position/' + articleId)
      .then(data => this._first(data) as OrderPosition);
  }

  getOrderPositionOptions(orderPositionId: string): JQuery.Promise<OrderPositionOption[]> {
    return this.getJson(this.targetUrl + 'position/' + orderPositionId + '/options');
  }

  static get(): OrderRepository {
    if (!repository) {
      repository = scout.create(OrderRepository);
    }
    return repository;
  }
}
