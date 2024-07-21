package org.gourmetgate.gourmetgate.core.article;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;
import org.gourmetgate.gourmetgate.data.article.IArticleRepository;

import java.util.stream.Stream;

public class ArticleService implements IService {

  public Stream<ArticleDo> all() {
    return BEANS.get(IArticleRepository.class).all();
  }
}
