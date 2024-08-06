import {
  App,
  Desktop as ScoutDesktop,
  DesktopModel as ScoutDesktopModel,
  Event,
  Form,
  GroupBox,
  icons,
  InitModelOf,
  LabelField,
  scout
} from '@eclipse-scout/core';
import DesktopModel, {DesktopWidgetMap} from './DesktopModel';
import {OrderForm} from "../order/OrderForm";
import {DataOutline} from "./DataOutline";
import {CartForm} from "../cart/CartForm";

export class Desktop extends ScoutDesktop {
  declare widgetMap: DesktopWidgetMap;

  protected override _jsonModel(): ScoutDesktopModel {
    return DesktopModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    let aboutMenu = this.widget('AboutMenu');
    aboutMenu.on('action', this._onAboutMenuAction.bind(this));

    let defaultThemeMenu = this.widget('DefaultThemeMenu');
    defaultThemeMenu.on('action', this._onDefaultThemeMenuAction.bind(this));

    let darkThemeMenu = this.widget('DarkThemeMenu');
    darkThemeMenu.on('action', this._onDarkThemeMenuAction.bind(this));

    if (this.theme === 'dark') {
      darkThemeMenu.setIconId(icons.CHECKED_BOLD);
    } else {
      defaultThemeMenu.setIconId(icons.CHECKED_BOLD);
    }
  }

  activateOrderPage() {
    let outline = this.getOutlines().find(o => o instanceof DataOutline);
    let cartPage = outline.nodes.find(page => page.id === OrderForm.PageId);
    outline.selectNode(cartPage);
  }

  activateCartPage() {
    let outline = this.getOutlines().find(o => o instanceof DataOutline);
    let cartPage = outline.nodes.find(page => page.id === CartForm.PageId);
    outline.selectNode(cartPage);
  }

  protected _onDefaultThemeMenuAction() {
    this.setTheme('default');
  }

  protected _onDarkThemeMenuAction() {
    this.setTheme('dark');
  }

  protected _onAboutMenuAction() {
    let form = scout.create(Form, {
      parent: this,
      resizable: false,
      title: this.session.text('ApplicationTitle'),
      rootGroupBox: {
        objectType: GroupBox,
        borderDecoration: 'empty',
        fields: [{
          objectType: LabelField,
          value: this.session.text('AboutText', this.session.text('ApplicationTitle'), App.get().version),
          labelVisible: false,
          wrapText: true,
          htmlEnabled: true,
          cssClass: 'about-info',
          statusVisible: false,
          gridDataHints: {
            h: 3
          }
        }]
      }
    });
    form.open();
  }
}

export interface DataChangeEvent<T = Desktop> extends Event<T> {
  dataType: string;
  data: any;
}
