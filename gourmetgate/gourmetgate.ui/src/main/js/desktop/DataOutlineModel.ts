import {Outline, OutlineModel} from '@eclipse-scout/core';
import {PersonTablePage} from '../index';

export default (): OutlineModel => ({
  id: 'gourmetgate.DataOutline',
  title: '${textKey:MyDataOutlineTitle}',
  objectType: Outline,
  nodes: [
    {
      objectType: PersonTablePage
    }
  ]
});

export type DataOutlineWidgetMap = {
  'gourmetgate.DataOutline': Outline;
};
