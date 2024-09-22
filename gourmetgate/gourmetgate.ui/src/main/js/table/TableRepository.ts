import {HallFormData, Repository} from "../index";
import {App} from "../App";
import {scout} from "@eclipse-scout/core";

let repository: TableRepository

export class TableRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}table/`;
  }

  regenerateTables(): JQuery.Promise<HallFormData> {
    return this.postJson(this.targetUrl + 'regenerate')
      .then(data => this._first(data) as HallFormData)
      .then(data => this._triggerDataChange(data, HallFormData.ENTITY_TYPE))
      .catch(error => this._handleError(error));
  }

  getHallFormData(): JQuery.Promise<HallFormData> {
    return this.getJson(this.targetUrl + 'hallFormData')
      .then(data => this._first(data))
      .catch(error => this._handleError(error));
  }

  static get(): TableRepository {
    if (!repository) {
      repository = scout.create(TableRepository);
    }
    return repository;
  }
}
