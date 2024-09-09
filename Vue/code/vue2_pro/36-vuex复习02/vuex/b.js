export default {
    namespaced: true,
    actions:{},
    mutations:{
        SUBONE(state, value){
            state.counter -= value
        }
    },
    state:{
        counter: 1000
    },
    getters: {
        computedB(state){
            return state.counter + 6666
        }
    }
}