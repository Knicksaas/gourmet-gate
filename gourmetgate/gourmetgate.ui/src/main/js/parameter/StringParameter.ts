import {Parameter} from "./Parameter";

export class StringParameter extends Parameter {

  protected override _parseValue(stringValue: string): string {
    return stringValue;
  }


  protected override _prepareValue(value: string): string {
    return value;
  }
}
