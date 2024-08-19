import {DesktopModel, Menu} from '@eclipse-scout/core';
import {Desktop, ShopOutline} from '../index';

export default (): DesktopModel => ({
  id: 'gourmetgate.Desktop',
  title: '${textKey:ApplicationTitle}',
  objectType: Desktop,
  logoUrl: 'img/eclipse_scout_logo.svg',
  nativeNotificationDefaults: {
    iconId: 'img/eclipse_scout_logo.png'
  },
  outline: {
    objectType: ShopOutline
  },
  navigationHandleVisible: false,
  navigationVisible: false,
  headerVisible: false
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type DesktopWidgetMap = {
  'ThemeMenu': Menu;
  'DefaultThemeMenu': Menu;
  'DarkThemeMenu': Menu;
  'AboutMenu': Menu;
};
