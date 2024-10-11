import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  el:'#app',
  beforeCreate(){
    // 安装全局事件总线
    Vue.prototype.$bus = this
  }
})
