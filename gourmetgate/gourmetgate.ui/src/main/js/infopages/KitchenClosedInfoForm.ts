import {InfoForm, InfoTileBean} from "../index";

export class KitchenClosedInfoForm extends InfoForm {

  protected override _load(): JQuery.Promise<InfoTileBean> {
    return $.resolvedPromise({
      iconClass: 'gg-icon-pause',
      title: 'Kurze pause...',
      description: 'Die Küche kann momentan keine weiteren Bestellungen entgegennehmen. Bitte haben Sie einen Moment Geduld.',
      infoColorClass: 'info-color-orange'
    });
  }
}
