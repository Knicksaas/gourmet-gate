import {RestLookupCall} from "@eclipse-scout/core";

export class VatLookupCall extends RestLookupCall<string> {

  constructor() {
    super();
    this.resourceUrl = 'api/vat/lookup'
  }
}
