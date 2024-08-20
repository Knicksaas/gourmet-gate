import {App, ArticleGroup, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ArticleGroupRepository;

export class ArticleGroupRepository extends Repository {
  constructor() {
    super();

    this.entityType = ArticleGroup.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}article/group/`;
  }

  getArticleGroup(articleGroupId: string): JQuery.Promise<ArticleGroup> {
    return this.getJson(this.targetUrl + articleGroupId)
      .then(data => this._first(data));
  }

  saveArticleGroup(data: ArticleGroup): JQuery.Promise<void> {
    return this.putJson(this.targetUrl + data.articleGroupId, data);
  }

  static get(): ArticleGroupRepository {
    if (!repository) {
      repository = scout.create(ArticleGroupRepository);
    }
    return repository;
  }
}
