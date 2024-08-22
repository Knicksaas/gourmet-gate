import $ from "jquery";

export class Vat {

  vatId: string;
  percent: number;

  static ENTITY_TYPE = 'vat';

  init(model: any) {
    $.extend(this, model);
  }

}
