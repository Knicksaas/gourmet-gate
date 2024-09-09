import {Parameter} from "./Parameter";

export class NumberParameter extends Parameter<number> {

  protected override _parseValue(stringValue: string): number {
    return Number.parseInt(stringValue);
  }

  protected override _prepareValue(value: number): string {
    return value.toString();
  }
}
