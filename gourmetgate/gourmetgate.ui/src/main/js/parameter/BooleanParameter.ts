import {Parameter} from "./Parameter";

export class BooleanParameter extends Parameter<boolean> {

  protected override _parseValue(stringValue: string): boolean {
    return stringValue.toLowerCase() == 'true'
  }

  protected override _prepareValue(value: boolean): string {
    return value.toString();
  }
}
