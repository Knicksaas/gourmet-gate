import {PageModel} from "@eclipse-scout/core";
import {InfoForm, PageWithData} from '../../index';

export default (): PageModel => ({
  id: 'InfoPage',
  objectType: PageWithData,
  text: '${textKey:Info}',
  leaf: true,
  navigateButtonsVisible: false,
  detailTableVisible: false,
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class InfoPageInfoForm extends InfoForm {

}
