import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 在开发中，一个vuex的模块对应一个js文件
// 导入js文件
import aModule from './a'
import bModule from './b'
import cModule from './c'

export default new Vuex.Store({
    // modules :{
    //     // 模块名：模块
    //     aModule: aModule,
    //     bModule: bModule,
    //     cModule: cModule,
    // }

    // 简写
    modules:{aModule, bModule, cModule}
})