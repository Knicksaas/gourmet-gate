import {App, ArticleGroup, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ArticleGroupRepository;

export class ArticleGroupRepository extends Repository {
  constructor() {
    super();

    this.entityType = ArticleGroup.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}article/group/`;
  }

  createArticleGroup(): JQuery.Promise<ArticleGroup> {
    let articleGroup = scout.create(ArticleGroup, {
      name: 'New article group',
      enabled: true
    });
    return this._create(articleGroup);
  }

  getArticleGroup(articleGroupId: string): JQuery.Promise<ArticleGroup> {
    return this.getJson(this.targetUrl + articleGroupId)
      .then(data => this._first(data))
      .catch(error => this._handleError(error));
  }

  saveArticleGroup(data: ArticleGroup): JQuery.Promise<void> {
    return this._store(data, this.targetUrl + data.articleGroupId)
      .then(() => undefined);
  }

  deleteArticleGroup(articleGroupId: string): JQuery.Promise<void> {
    return this._remove(articleGroupId);
  }

  static get(): ArticleGroupRepository {
    if (!repository) {
      repository = scout.create(ArticleGroupRepository);
    }
    return repository;
  }
}
