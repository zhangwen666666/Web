import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions = {
    // actions代码逻辑非常简单，可以直接进入mutation环节
/*     saveUser(context, value){
        context.commit('SAVE_USER', value)
    },
    saveVip(context, value){
        context.commit('SAVE_VIP', value)
    } */
}
const mutations = {
    SAVE_USER(state, value){
        state.users.unshift(value)
    },
    SAVE_VIP(state, value){
        state.vips.unshift(value)
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
    username: ''  // 可以看做是Vue中的data
}

// 全新的配置项 getters
const getters = {
    // 有很多getter， 每一个getter可以看做是一个计算属性
    // 每一个getter方法会自动接收一个state对象
    reversedName(state){ // 可以看做Vue中的computed
        return state.username.split('').reverse().join('')
    }
}

export default new Vuex.Store({actions, mutations, state, getters})