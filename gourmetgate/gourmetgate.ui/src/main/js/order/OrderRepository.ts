import {App, OrderPosition, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: OrderRepository;

export class OrderRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}order/`;
  }

  createOrderPosition(articleId: string): JQuery.Promise<OrderPosition> {
    return this.postJson(this.targetUrl + 'position/' + articleId);
  }

  static get(): OrderRepository {
    if (!repository) {
      repository = scout.create(OrderRepository);
    }
    return repository;
  }
}
