<template>
    <div>
        <h1>计数器: {{counter}}</h1>
        <h1>计数器乘10: {{computedA}}</h1>
        <button @click="add(count)">点我加1</button>
    </div>
</template>

<script>
    import { mapActions, mapGetters, mapState } from 'vuex'
    export default {
        name: 'A',
        data(){
            return {
                count: 1,
            }
        },
        computed:{
            ...mapState('a',['counter']),
            ...mapGetters('a',['computedA'])
        },
        methods:{
            ...mapActions('a',['add'])
        }
    }
</script>