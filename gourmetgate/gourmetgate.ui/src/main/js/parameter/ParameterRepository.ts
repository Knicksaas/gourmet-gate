import {App, Parameter, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ParameterRepository;

export class ParameterRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}parameter/`;
  }

  getParameterValue<T>(parameterClass: typeof Parameter<T>): JQuery.Promise<T> {
    return this.getJson(this.targetUrl + parameterClass.PARAMETER_NAME)
      .then(data => {
        // @ts-expect-error
        return scout.create(parameterClass, data).getValue();
      });
  }

  setParameterValue<T>(parameterClass: typeof Parameter<T>, value: T): JQuery.Promise<void> {
    return this.putJson(this.targetUrl + parameterClass.PARAMETER_NAME, value);
  }

  static get(): ParameterRepository {
    if (!repository) {
      repository = scout.create(ParameterRepository);
    }
    return repository;
  }
}
