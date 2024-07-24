import {Group, GroupModel, TileGrid} from "@eclipse-scout/core";

export default (): GroupModel => ({
  id: 'ArticleAccordionGroup',
  objectType: Group,
  cssClass: 'article-accordion-group',
  body: {
    objectType: TileGrid,
    withPlaceholders: true,
    gridColumnCount: 3,
    layoutConfig: {
      columnWidth: 50,
      rowHeight: 80,
      hgap: 10,
      vgap: 10
    }
  }
});
