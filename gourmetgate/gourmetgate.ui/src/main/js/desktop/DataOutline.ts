import {Outline, OutlineModel} from '@eclipse-scout/core';
import DataOutlineModel from './DataOutlineModel';

export class DataOutline extends Outline {

  protected override _jsonModel(): OutlineModel {
    return DataOutlineModel();
  }
}
