import {access, App as ScoutApp, Desktop, router, Widget} from '@eclipse-scout/core';
import {AppRoute, Desktop as GouGaDesktop} from "./index";

export class App extends ScoutApp {
  apiUrl: string;

  constructor() {
    super();
    this.apiUrl = '../api/';
  }


  protected override _createDesktop(parent: Widget): Desktop {
    let desktop = super._createDesktop(parent);
    router.register(new AppRoute(desktop as GouGaDesktop));
    this._setDefaultLocation();
    router.activate();
    return desktop;
  }

  protected _setDefaultLocation() {
    if (!access.quickCheck('EscapeShopViewPermission')) {
      router.setDefaultLocation('order');
    }
  }

// @ts-expect-error
  static get(): App {
    return ScoutApp.get() as App;
  }
}
