import Vue from 'vue'

import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    counter: 1
}

const a = {
    namespaced:true,
    actions:{
        add(context, value){
            // console.log(value);
            value = value + 0
            context.commit('ADD', value)
        }
    },
    mutations:{
        ADD(state, value){
            state.counter += value
        }
    },
    state: state,
    getters: {
        computedA(state){
            return state.counter * 10
        }
    }
}

const b = {
    namespaced: true,
    actions:{},
    mutations: {
        ADD2(state,value){
            state.counter += 2
        }
    },
    state: state,
    getters: {
        computedB(state){
            return state.counter * 100
        }
    }
}

const c = {
    namespaced: true,
    actions: {},
    mutations: {},
    state:{
        counter : 1
    },
    getters: {}
}

export default new Vuex.Store({
    modules:{a,b,c}
})