import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import store from './vuex/store.js'

new Vue({
  render: h => h(App),
  el:'#app',
  store,
})
