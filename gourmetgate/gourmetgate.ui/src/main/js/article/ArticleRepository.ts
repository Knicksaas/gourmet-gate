import {App, Article, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ArticleRepository;

export class ArticleRepository extends Repository {
  constructor() {
    super();

    this.entityType = Article.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}articles/`;
  }

  all(): JQuery.Promise<Article[]> {
    return this._all();
  }

  static get(): ArticleRepository {
    if (!repository) {
      repository = scout.create(ArticleRepository);
    }
    return repository;
  }
}
