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
    return this.getJson(this.targetUrl + 'tablePageData')
      .catch(error => this._handleError(error));
  }

  createArticle(articleGroupId: string): JQuery.Promise<Article> {
    let article = scout.create(Article, {
      articleGroupId: articleGroupId,
      name: 'New article',
      unit: '5 dl',
      price: 2,
      options: false,
      vatId: '74564073-3eaf-40bf-b60c-59cc1ecd1e67',
      enabled: true
    });
    return this._create(article);
  }

  getArticle(articleId: string) {
    return this.getJson(this.targetUrl + articleId)
      .then(data => this._first(data))
      .catch(error => this._handleError(error));
  }

  updateArticle(articleId: string, data: Article): JQuery.Promise<void> {
    return this._store(data, this.targetUrl + articleId)
      .then(() => undefined)
  }

  deleteArticle(articleId: string): JQuery.Promise<void> {
    return this._remove(articleId);
  }

  syncArticlesFromLoyverse(): JQuery.Promise<void> {
    return this.postJson(this.targetUrl + 'sync/loyverse')
      .then(() => this._triggerDataChange());
  }

  static get(): ArticleRepository {
    if (!repository) {
      repository = scout.create(ArticleRepository);
    }
    return repository;
  }
}
