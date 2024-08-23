import $ from "jquery";

export class Parameter<PValue = string> {

  parameterId: string;
  name: string;
  value: string;

  constructor(name: string) {
    this.name = name;
  }

  static ENTITY_TYPE = 'parameter';
  static PARAMETER_NAME = null;

  init(model: any) {
    $.extend(this, model);
  }

  getValue(): PValue {
    return this._parseValue(this.value);
  }

  setValue(value: PValue) {
    this.value = this._prepareValue(value);
  }

  protected _parseValue(stringValue: string): PValue {
    throw Error('Not implemented');
  }

  protected _prepareValue(value: PValue): string {
    throw Error('Not implemented');
  }
}
