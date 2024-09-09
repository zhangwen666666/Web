export default {
    namespaced: true,
    actions: {
        mulTwo(context,value){
            value += 2
            context.commit('MULTWO', 2)
        }
    },
    mutations: {
        MULTWO(state, value){
            state.counter *= value
        }
    },
    state:{
        counter: 2
    },
    getters:{
        computedC(state){
            return 8888 + state.counter
        }
    }
}