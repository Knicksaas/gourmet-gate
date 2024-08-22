import {RestLookupCall} from "@eclipse-scout/core";

export class ArticleGroupLookupCall extends RestLookupCall<string> {


  constructor() {
    super();
    this.resourceUrl = 'api/article/group/lookup'
  }
}
