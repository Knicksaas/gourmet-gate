package org.gourmetgate.gourmetgate.data.dataprovider;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;

import java.util.List;

@ApplicationScoped
public interface IArticleGroupProvider {

  List<ArticleGroupDo> getArticleGroups();
}
