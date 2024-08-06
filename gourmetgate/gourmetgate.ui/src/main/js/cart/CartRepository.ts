import {App, CartFormData, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: CartRepository;

export class CartRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}cart/`;
  }

  getFormData(): JQuery.Promise<CartFormData> {
    return this.getJson(this.targetUrl + 'formData')
      .then(data => this._first(data));
  }

  static get(): CartRepository {
    if (!repository) {
      repository = scout.create(CartRepository);
    }
    return repository;
  }
}
