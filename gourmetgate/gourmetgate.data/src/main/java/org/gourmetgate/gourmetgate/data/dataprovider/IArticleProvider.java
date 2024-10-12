package org.gourmetgate.gourmetgate.data.dataprovider;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.article.ArticleDo;

import java.util.List;

@ApplicationScoped
public interface IArticleProvider {

  List<ArticleDo> getArticles();
}
