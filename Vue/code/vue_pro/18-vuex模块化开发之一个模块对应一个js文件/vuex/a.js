// a模块
export default {
    // 开启命名空间
    namespaced: true,
    actions: {
        doA1(){
            console.log('doA1 action...');
        }
    },
    mutations: {
        doA2(){
            console.log('doA2 mutation...');
        },
    },
    state:{
        a : 1,
    },
    getters:{
        computedA(){
            return 1
        },
    },
}