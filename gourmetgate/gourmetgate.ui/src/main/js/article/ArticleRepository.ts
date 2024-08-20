import {App, Article, ArticleTablePageEntry, Repository} from "../index";
import {scout} from "@eclipse-scout/core";

let repository: ArticleRepository;

export class ArticleRepository extends Repository {
  constructor() {
    super();

    this.entityType = Article.ENTITY_TYPE;
    this.targetUrl = `${App.get().apiUrl}article/`;
  }

  getArticleTablePageData(): JQuery.Promise<ArticleTablePageEntry[]> {
    return this.getJson(this.targetUrl + 'tablePageData');
  }

  static get(): ArticleRepository {
    if (!repository) {
      repository = scout.create(ArticleRepository);
    }
    return repository;
  }
}
