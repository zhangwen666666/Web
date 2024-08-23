// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

// // 获取VueComponent构造函数
// const VueComponentConstructor = Vue.extend({})
// // 创建一个共享的vc对象
// const globalvc = new VueComponentConstructor()
// // 给Vue的原型对象扩展一个x属性，x属性指向了这个共享的vc对象
// // 给Vue的原型对象扩展的这个x属性，其他组件vc都是可以直接访问的。
// Vue.prototype.x = globalvc

new Vue({
  el: '#app',
  render: h => h(App),
  beforeCreate(){
    // vm上也有$on 和 $emit方法，且当前的这个vm也是所有组件共享的
    // 即当前的Vue实例vm可以做为共享对象
    // 一般这个共享对象有个专业的名字 $bus 全局事件总线
    Vue.prototype.$bus=this
  }
})
