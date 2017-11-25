export const environment = {
  production: false,
  appId: 'frontend_id',
  apiHost: 'localhost:8080',
  enableSecurity: true,

  get apiUrl() {
    return 'http://' + this.apiHost + '/';
  }
};
