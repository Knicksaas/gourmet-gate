import {StaticLookupCall} from "@eclipse-scout/core";
import {OrderPositionOption} from "../../index";

export class OrderPositionOptionsLookupCall extends StaticLookupCall<string> {
  orderPositionOptions: OrderPositionOption[];

  constructor() {
    super();
    this.orderPositionOptions = [];
  }

  setData(data: OrderPositionOption[]) {
    this.orderPositionOptions = data;
    this.refreshData();
  }

  protected override _data(): any[] {
    return this.orderPositionOptions.map(option => {
      return [option.orderPositionOptionId, option.description]
    })
  }
}
