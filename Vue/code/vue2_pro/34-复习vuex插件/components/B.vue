<template>
    <div>
        <h1>计数器: {{counter}}</h1>
        <h1>计数器乘100: {{computedB}}</h1>
        <button @click="ADD2(count)">点我加2</button>
    </div>
</template>

<script>
    import { mapMutations } from "vuex"

    import { mapGetters } from "vuex"

    import { mapState } from "vuex"

    export default {
        name: 'B',
        data(){
            return {
                count: 2,
            }
        },
        computed:{
            ...mapState('b',['counter']),
            ...mapGetters('b',['computedB'])
        },
        methods:{
            ...mapMutations('b',['ADD2'])
        }
    }
</script>

<style>

</style>