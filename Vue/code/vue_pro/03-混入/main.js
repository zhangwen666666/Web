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
 
  // 您正在使用Vue的仅运行时版本，其中模版编译器不可用
  // 目前使用的vue.js是一个缺失了模版编译器的vue.js文件。
  // 怎么解决?
  // 第一种：使用完成版的vue.js  import Vue from 'vue/dist/vue.js'
  // 第二种：使用render函数。
  // 为什么采用缺失模版编译器的vue.js?
  // 目的：减小体积。Vue.js包括两块：Vue核心 + 模版编译器
  // 将来程序员使用webpack进行打包处理之后，模版编译器就没有存在的必要了。
  // template: '<h1>render函数</h1>'
  
  // render: h => h(App),
  // render函数被自动调用
  // 这个函数被调用的时候会自动传过来一个参数：createElement。
  // createElement是一个函数,这个函数可以用来创建元素。

  // render(createElement){
  //   console.log(111, createElement);
  //   // 创建了一个div元素并返回
  //   // return createElement('div', 'render函数')
  //   return createElement(App)
  // }
  // 简写形式如下
  // render:createElement => createElement(App)
  render: h => h(App),
})
