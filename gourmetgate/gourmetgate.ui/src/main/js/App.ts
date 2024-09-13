import {App as ScoutApp, Desktop, router, Widget} from '@eclipse-scout/core';
import {AppRoute, Desktop as AppDesktop} from "./index";

export class App extends ScoutApp {
  apiUrl: string;

  constructor() {
    super();
    this.apiUrl = '../api/';
  }


  protected override _createDesktop(parent: Widget): Desktop {
    let desktop = super._createDesktop(parent);
    router.register(new AppRoute(desktop as AppDesktop));
    router.activate();
    return desktop;
  }

// @ts-expect-error
  static get(): App {
    return ScoutApp.get() as App;
  }
}
