import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

import a from './a.js'
import b from './b.js'
import c from './c.js'
export default new Vuex.Store({
    modules:{a,b,c}
})