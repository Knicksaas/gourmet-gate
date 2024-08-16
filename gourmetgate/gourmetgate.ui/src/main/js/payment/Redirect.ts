import $ from "jquery";

export class Redirect {

  redirectUrl: string;

  static ENTITY_TYPE = 'redirect';

  init(model: any) {
    $.extend(this, model);
  }
}
