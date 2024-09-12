import {PageWithData} from "../../desktop/PageWithData";
import InfoPageModel from "./InfoPageModel";

export class InfoPage extends PageWithData {

  protected override _jsonModel(): Record<string, any> {
    return InfoPageModel();
  }
}
