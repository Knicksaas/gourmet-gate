import {Group, GroupModel, TileGrid} from "@eclipse-scout/core";
import {ArticleTile} from '../index';

export default (): GroupModel => ({
  id: 'ArticleAccordionGroup',
  objectType: Group,
  body: {
    objectType: TileGrid,
    gridColumnCount: 3,
    tiles: [{
      objectType: ArticleTile
    }]
  }
});
