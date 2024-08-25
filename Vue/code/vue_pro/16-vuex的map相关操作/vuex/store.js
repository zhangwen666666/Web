import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions = {
    // actions代码逻辑非常简单，可以直接进入mutation环节
    saveUser(context, value){
        context.commit('SAVE_USER', {id: Date.now(), name:value})
    },
    // saveVip(context, value){
    //     context.commit('SAVE_VIP', value)
    // }
}
const mutations = {
    SAVE_USER(state, value){
        state.users.unshift(value)
    },
    SAVE_VIP(state, value){
        state.vips.unshift({id: Date.now(), name: value})
    }
}
const state = {
    users: [
        {id:'001', name: '孙悟空'},
        {id:'002', name: '猪八戒'},
        {id:'003', name: '沙和尚'}
    ],
    vips: [
        {id:'001', name: '高启强'},
        {id:'002', name: '高启盛'},
        {id:'003', name: '高启兰'}
    ],
    uname: ''  // 可以看做是Vue中的data
}

// 全新的配置项 getters
const getters = {
    reversedName(state){ // 可以看做Vue中的computed
        return state.uname.split('').reverse().join('')
    }
}

export default new Vuex.Store({actions, mutations, state, getters})