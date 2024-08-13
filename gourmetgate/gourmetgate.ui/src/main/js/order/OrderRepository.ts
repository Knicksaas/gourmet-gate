import {App, GenericRequestBody, OrderPosition, OrderPositionOption, Repository} from "../index";
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

  deleteOrderPosition(orderPositionId: string): JQuery.Promise<void> {
    return this.removeJson(this.targetUrl + 'position/' + orderPositionId);
  }

  getOrderPositionOptions(orderPositionId: string): JQuery.Promise<OrderPositionOption[]> {
    return this.getJson(this.targetUrl + 'position/' + orderPositionId + '/options');
  }

  updateOrderPositionOptions(orderPositionId: string, orderPositionOptions: OrderPositionOption[]): JQuery.Promise<void> {
    let body = new GenericRequestBody();
    body.withItems(orderPositionOptions);
    return this.postJson(this.targetUrl + 'position/' + orderPositionId + '/options', this.jsonStringify(body));
  }

  static get(): OrderRepository {
    if (!repository) {
      repository = scout.create(OrderRepository);
    }
    return repository;
  }
}
