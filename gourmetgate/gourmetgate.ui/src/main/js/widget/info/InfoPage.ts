import InfoPageModel, {InfoPageInfoForm} from './InfoPageModel';
import {PageWithData} from "../../index";

export class InfoPage extends PageWithData {
  declare detailForm: InfoPageInfoForm;

  routeRef: string; // Indicates deeplink route to access this page

  protected override _jsonModel(): Record<string, any> {
    return InfoPageModel();
  }
}
