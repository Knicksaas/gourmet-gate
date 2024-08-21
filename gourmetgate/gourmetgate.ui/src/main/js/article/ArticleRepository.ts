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
    return this.postJson(this.targetUrl, article)
      .then(data => this._first(data));
  }

  static get(): ArticleRepository {
    if (!repository) {
      repository = scout.create(ArticleRepository);
    }
    return repository;
  }
}
