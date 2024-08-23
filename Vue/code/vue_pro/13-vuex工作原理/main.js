// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

// 引入Vuex插件中的核心对象store
import store from './vuex/store'


new Vue({
  el: '#app',
  // 一个全新的配置项，名字叫store
  // 加上这个配置项之后，vm以及所有的vc对象上都会多一个属性：$store
  // store: store,
  store,
  render: h => h(App),
})
