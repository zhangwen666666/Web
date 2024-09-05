// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

import {mix1} from './mixin.js'
import {mix2} from './mixin.js'
import {mix3} from './mixin.js'

// 全局混入
Vue.mixin(mix1)
Vue.mixin(mix2)
Vue.mixin(mix3)

new Vue({
  el: '#app',
  render: h => h(App),
})
