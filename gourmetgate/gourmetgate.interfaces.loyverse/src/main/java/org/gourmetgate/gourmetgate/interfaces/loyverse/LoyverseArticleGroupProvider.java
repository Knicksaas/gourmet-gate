package org.gourmetgate.gourmetgate.interfaces.loyverse;

import org.eclipse.scout.rt.platform.BEANS;
import org.gourmetgate.gourmetgate.data.articlegroup.ArticleGroupDo;
import org.gourmetgate.gourmetgate.data.dataprovider.IArticleGroupProvider;
import org.gourmetgate.gourmetgate.interfaces.loyverse.data.category.LoyverseCategoryResponseDo;
import org.gourmetgate.gourmetgate.interfaces.loyverse.rest.LoyverseResourceClient;

import java.util.List;

public class LoyverseArticleGroupProvider implements IArticleGroupProvider {

  @Override
  public List<ArticleGroupDo> getArticleGroups() {
    LoyverseCategoryResponseDo categoryResponse = BEANS.get(LoyverseResourceClient.class).getAllCategories();
    return categoryResponse.getCategories().stream()
      .map(category -> BEANS.get(ArticleGroupDo.class)
        .withArticleGroupId(category.getId())
        .withName(category.getName())
        .withEnabled(true))
      .toList();
  }
}
