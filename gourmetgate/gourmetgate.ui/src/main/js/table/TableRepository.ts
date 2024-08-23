import {HallFormData, Repository} from "../index";
import {App} from "../App";
import {scout} from "@eclipse-scout/core";

let repository: TableRepository

export class TableRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}table/`;
  }

  regenerateTables(): JQuery.Promise<void> {
    return this.postJson(this.targetUrl + 'regenerate');
  }

  getHallFormData(): JQuery.Promise<HallFormData> {
    return this.getJson(this.targetUrl + 'hallFormData')
      .then(data => this._first(data));
  }

  static get(): TableRepository {
    if (!repository) {
      repository = scout.create(TableRepository);
    }
    return repository;
  }
}
