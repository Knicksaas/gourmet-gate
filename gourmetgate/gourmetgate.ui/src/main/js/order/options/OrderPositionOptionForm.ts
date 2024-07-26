import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import OrderPositionOptionFormModel from "./OrderPositionOptionFormModel";
import $ from "jquery";

export class OrderPositionOptionForm extends Form {

  protected _documentMouseDownHandler: (event: MouseEvent) => void;

  protected override _jsonModel(): WidgetModel {
    return OrderPositionOptionFormModel();
  }


  protected override _render() {
    super._render();

    this._documentMouseDownHandler = this._onDocumentMouseDown.bind(this);
    this.$container.document(true).addEventListener('mousedown', this._documentMouseDownHandler, true);
  }

  protected _onDocumentMouseDown(event: MouseEvent) {
    if (!this._rendered) {
      return;
    }
    let targetWidget = scout.widget($(event.target as HTMLElement));
    if (!this.isOrHas(targetWidget)) {
      this.close();
    }
  }


  protected override _remove() {
    // First remove mouse handler
    if (this._documentMouseDownHandler) {
      this.$container.document(true).removeEventListener('mousedown', this._documentMouseDownHandler, true);
      this._documentMouseDownHandler = null;
    }
    super._remove();
  }
}
