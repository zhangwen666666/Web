import Vue from 'vue'
import App from './App.vue'

// 导入插件
import VueResource from 'vue-resource'

Vue.config.productionTip = false

// 使用插件
Vue.use(VueResource)

new Vue({
  render: h => h(App),
  el:'#app',
  // 使用全局事件总线
  beforeCreate(){
    Vue.prototype.$bus = this
  }
})
