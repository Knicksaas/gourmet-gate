package org.gourmetgate.gourmetgate.core.articlegroup;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.articlegroup.IArticleGroupRepository;

import java.util.stream.Stream;

public class ArticleGroupService implements IService {

  public Stream<ArticleGroupDo> all() {
    return BEANS.get(IArticleGroupRepository.class).all();
  }
}
