import {Outline, OutlineModel} from '@eclipse-scout/core';
import DataOutlineModel from './ShopOutlineModel';

export class ShopOutline extends Outline {

  protected override _jsonModel(): OutlineModel {
    return DataOutlineModel();
  }
}
