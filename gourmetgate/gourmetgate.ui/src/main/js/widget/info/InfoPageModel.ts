import {PageModel} from "@eclipse-scout/core";
import {InfoForm} from './InfoForm';
import {PageWithData} from "../../desktop/PageWithData";

export default (): PageModel => ({
  id: 'InfoPage',
  objectType: PageWithData,
  text: '${textKey:Info}',
  leaf: true,
  navigateButtonsVisible: false,
  detailTableVisible: false,
  detailForm: {
    id: 'InfoForm',
    objectType: InfoForm
  }
});
