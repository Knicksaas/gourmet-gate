import {Parameter} from "../index";

export class TablesPerRowParameter extends Parameter<number> {

  static override PARAMETER_NAME = 'TablesPerRowParameter';

  protected override _parseValue(stringValue: string): number {
    return Number.parseInt(stringValue);
  }

  protected override _prepareValue(value: number): string {
    return value.toString();
  }
}
