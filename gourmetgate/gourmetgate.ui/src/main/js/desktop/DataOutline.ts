import {InitModelOf, Outline, OutlineModel} from '@eclipse-scout/core';
import DataOutlineModel from './DataOutlineModel';
import {OrderForm} from "../index";

export class DataOutline extends Outline {

  protected override _jsonModel(): OutlineModel {
    return DataOutlineModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.selectNode(this.nodes.find(page => page.id === OrderForm.PageId));
  }
}
