import {InfoPage, InfoTileBean} from "../index";

export class KitchenClosedInfoPage extends InfoPage {
  routeRef = 'pause'

  protected override _createInfoTileBean(): InfoTileBean {
    return {
      iconClass: 'gg-icon-pause',
      title: 'Kurze pause...',
      description: 'Die Küche kann momentan keine weiteren Bestellungen entgegennehmen. Bitte haben Sie einen Moment Geduld.',
      infoColorClass: 'info-color-orange'
    }
  }
}
