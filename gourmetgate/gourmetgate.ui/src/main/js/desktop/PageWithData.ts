import {PageWithNodes} from "@eclipse-scout/core";

export class PageWithData extends PageWithNodes {

  override loadChildren(): JQuery.Promise<any> {
    return super.loadChildren()
      .then(p => this.detailForm.load())
  }
}
