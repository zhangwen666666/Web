<template>
    <div>
        <h1>B组件</h1>
        <button @click="doB1">doA1 BUTTON</button>
        <button @click="doB2">doA2 BUTTON</button>
        <h3>state: {{b}}</h3>
        <h3>getters: {{computedB}}</h3>
    </div>
</template>

<script>
    import {mapState,mapGetters, mapActions,mapMutations} from 'vuex'
    export default {
        name: 'B',
        methods: {
            ...mapActions('bModule',['doB1']),
            ...mapMutations('bModule',['doB2'])
        },
        computed: {
            ...mapState('bModule',['b']),
            ...mapGetters('bModule',['computedB'])
        }
    }
</script>

