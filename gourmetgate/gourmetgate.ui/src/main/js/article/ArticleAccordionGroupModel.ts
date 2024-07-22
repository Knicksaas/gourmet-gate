import {Group, GroupModel, TileGrid} from "@eclipse-scout/core";

export default (): GroupModel => ({
  id: 'ArticleAccordionGroup',
  objectType: Group,
  cssClass: 'article-accordion-group',
  body: {
    objectType: TileGrid,
    withPlaceholders: true,
    gridColumnCount: 3
  }
});
