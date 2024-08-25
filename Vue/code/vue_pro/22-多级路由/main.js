// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

// 导入vue-router插件
import VueRouter from 'vue-router'

// 导入路由器对象
import router from './router'

// 使用vue-router插件
Vue.use(VueRouter)

const vm = new Vue({
  el: '#app',
  router: router,
  render: h => h(App),
})
