import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const a = {
    namespaced: true,
    actions : {
        doA1(){
            console.log('doA1 actions');
        }
    },
    mutations : {
        doA2(){
            console.log('doA2 mutation...');
        },
    },
    state : {
        a : 1
    },
    getters : {
        computedA(){
            return 1
        },
    }, 
}

const b = {
    namespaced: true,
    actions : {
        doB1(){
            console.log('doB1 aciton...');
        }
    },
    mutations : {
        doB2(){
            console.log('doB2 mutations...');
        }
    },
    state : {
        b : 10
    },
    getters : {
        computedB(){
            return 10
        }
    }, 
}

export default new Vuex.Store({
    modules: {
        aModule: a,
        bModule: b
    }
})