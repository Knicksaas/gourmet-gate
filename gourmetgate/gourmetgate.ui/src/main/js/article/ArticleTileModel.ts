import {BeanTile, BeanTileModel} from "@eclipse-scout/core";

export default (): BeanTileModel => ({
  id: 'TestTile',
  objectType: BeanTile,
  content: '<h1>hoi</h1>'
});
