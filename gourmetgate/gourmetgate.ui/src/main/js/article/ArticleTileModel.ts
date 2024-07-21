import {BeanTile, BeanTileModel} from "@eclipse-scout/core";
import {Article} from "./Article";

export default (): BeanTileModel => ({
  id: 'ArticleTile',
  objectType: BeanTile<Article>,
  content: '<h1>hoi</h1>'
});
