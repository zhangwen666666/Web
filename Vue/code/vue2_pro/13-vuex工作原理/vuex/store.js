// 引入Vue，因为使用Vuex插件的时候需要Vue
import Vue from 'vue'

// 引入vuex插件
import Vuex from 'vuex'

// 使用插件
Vue.use(Vuex)

// 创建三个对象：actions对象，mutations对象，state对象
const actions = {
    // N多个actions
    // 每一个action都是一个callback(回调函数)
    // 在action这种回调函数中编写复杂的业务逻辑代码
    // 有个原则：action是专门用来处理业务逻辑，或者说是发送AJAX请求的。
    // plusOne: function(){}

    // 简写
    // context 参数： vuex的上下文 （可以看做是一个store对象的缩小版）
    // value参数： 传过来的数据
    plusOne(context, value){
        // 处理业务
        value = value + 1
        // 调用其他的action这个回调函数
        context.dispatch('otherAction', value)
        // 业务逻辑处理完成之后，继续向下一个环节走，就轮到了数据的更新
        // 提交上下文环境
        context.commit('PLUS_ONE', value)
    },

    // 这里还有其他的action
    otherAction(){
        console.log(666);
    }
}
 
const mutations = {
    // N多个mutations
    // 每一个mutation都是一个callback(回调函数)
    // 每一个mutation回调函数的作用就是：更新state
    // 只要state一更新，因为是响应式的，所以页面就重新渲染了。
    // state 参数：状态对象，
    // value参数: 上一个缓解传过来的数据 
    PLUS_ONE(state, value){
        state.num += value
    } 
}

// 等同于Vue中的data(只不过这里不叫做数据，叫做状态)
// 状态对象(数据对象)，已经做了响应式处理的。
const state = {
    num : 0
}


// 简写形式 (创建store对象并导出)
export default new Vuex.Store({actions,mutations,state})


/*
// 创建store对象
// 这个store对象是vuex插件的老大，用来管理actions对象、mutations对象，state对象
const store = new Vuex.Store({
    // 配置项不能随便写

    // actions是一个负责执行某一个行为的对象
    actions: actions,
    // mutations是一个负责更新的对象
    mutations: mutations,
    // state是一个状态对象
    state: state,
})

// 导出store对象(暴露之后，别人想用可以使用import进行引入)
export default store
*/