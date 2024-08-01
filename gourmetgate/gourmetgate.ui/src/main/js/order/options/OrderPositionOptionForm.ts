import {Form, FormModel, scout, WidgetModel} from "@eclipse-scout/core";
import OrderPositionOptionFormJsonModel, {
  OrderPositionOptionFormJsonWidgetMap
} from "./OrderPositionOptionFormJsonModel";
import $ from "jquery";
import {OrderPositionOption, OrderRepository} from "../../index";

export interface OrderPositionOptionFormModel extends FormModel {
  orderPositionId?: string;
}

export class OrderPositionOptionForm extends Form implements OrderPositionOptionFormModel {
  declare model: OrderPositionOptionFormModel;
  declare widgetMap: OrderPositionOptionFormJsonWidgetMap;
  declare data: OrderPositionOption[];

  orderPositionId: string;

  protected _documentMouseDownHandler: (event: MouseEvent) => void;

  protected override _jsonModel(): WidgetModel {
    return OrderPositionOptionFormJsonModel();
  }

  protected override _load(): JQuery.Promise<OrderPositionOption[]> {
    return OrderRepository.get().getOrderPositionOptions(this.orderPositionId);
  }

  override importData() {
    this.widget('OptionsListField').lookupCall.setData(this.data);
  }

  override exportData(): any {
    return this.data.map(option => {
      let selected = this.widget('OptionsListField').value.includes(option.orderPositionOptionId);
      option.setSelected(selected);
      return option;
    });
  }


  protected override _save(data: any): JQuery.Promise<void> {
    return OrderRepository.get().updateOrderPosition(this.orderPositionId, data);
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
      this.ok();
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
