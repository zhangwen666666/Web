// b模块
export default {
    namespaced: true,
    actions: {
        doB1(){
            console.log('doB1 action...');
        }
    },
    mutations: {
        doB2(){
            console.log('doB2 mutation...');
        }
    },
    state:{
        b : 10,
    },
    getters:{
        computedB(){
            return 10
        }
    },
}