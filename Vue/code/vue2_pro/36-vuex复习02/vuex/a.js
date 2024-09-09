export default {
    namespaced:true,
    actions: {
        plusOne(context, value){
            value = value + 1
            context.commit('PLUSONE',value)
        }
    },
    mutations: {
        PLUSONE(state, value){
            state.counter += value
        }
    },
    state: {
        counter: 1
    },
    getters: {
        computedA(state){
            return state.counter + 1111
        }
    }
}