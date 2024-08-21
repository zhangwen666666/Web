// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

// 导入混入
import {mix1} from './mixin.js'
import {mix2} from './mixin.js'
import {mix3} from './mixin.js'

// 导入插件
import {p1} from './plugins.js'

// 全局混入
Vue.mixin(mix1)
Vue.mixin(mix2)
Vue.mixin(mix3)

// 插件的使用通常放在创建Vue实例之前
// 插上插件
Vue.use(p1,1,2,3)

new Vue({
  el: '#app',
  render: h => h(App),
})
