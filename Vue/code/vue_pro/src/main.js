// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

// 导入vue-router插件
import VueRouter from 'vue-router'
// 导入路由器对象

// 使用vue-router插件
Vue.use(VueRouter)

const vm = new Vue({
  el: '#app',
  // 一但使用了vue-router插件，那么new Vue的时候就可以直接传递一个配置项:router
  // router配置项用来接收一个路由器对象

  render: h => h(App),
})
