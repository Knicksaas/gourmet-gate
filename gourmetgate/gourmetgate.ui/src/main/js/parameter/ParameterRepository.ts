import {App, Parameter, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ParameterRepository;

export class ParameterRepository extends Repository {

  constructor() {
    super();

    this.targetUrl = `${App.get().apiUrl}parameter/`;
  }

  getParameterValueByName<T>(parameterClassName: string): JQuery.Promise<T> {
    return this.getJson(this.targetUrl + parameterClassName)
      .then(data => {
        return scout.create(this._parseClassName(parameterClassName), data).getValue();
      });
  }

  getParameterValue<T>(parameterClass: typeof Parameter<T>): JQuery.Promise<T> {
    return this.getParameterValueByName(parameterClass.PARAMETER_NAME)
  }

  setParameterValueByName(parameterClassName: string, value: string): JQuery.Promise<void> {
    let data = scout.create(this._parseClassName(parameterClassName));
    data.setValue(value);
    return this.putJson(this.targetUrl + parameterClassName, data);
  }

  setParameterValue<T>(parameterClass: typeof Parameter<T>, value: T): JQuery.Promise<void> {
    // @ts-expect-error
    let data = scout.create(parameterClass);
    data.setValue(value);
    return this.putJson(this.targetUrl + parameterClass.PARAMETER_NAME, data);
  }

  getParameterTablePageData(): JQuery.Promise<Parameter[]> {
    return this.getJson(this.targetUrl)
  }

  protected _parseClassName(name: string) {
    let prefix = 'gourmetgate.';
    if (!name.startsWith(prefix)) {
      name = prefix + name;
    }
    return name;
  }

  static get(): ParameterRepository {
    if (!repository) {
      repository = scout.create(ParameterRepository);
    }
    return repository;
  }
}
