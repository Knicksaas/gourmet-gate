import {App} from '@gourmetgate/ui';

new App().init({
  bootstrap: {
    textsUrl: 'texts.json',
    permissionsUrl: `${App.get().apiUrl}permissions`
  }
});

