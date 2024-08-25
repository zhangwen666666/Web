// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

import store from './vuex/store'

const vm = new Vue({
  el: '#app',
  store,
  render: h => h(App),
})
