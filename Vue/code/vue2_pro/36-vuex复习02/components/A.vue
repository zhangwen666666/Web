<template>
    <div>
        <h1>A组件</h1>
        <span>计数器1: {{counter}}</span><br>
        <span>计数器加1111: {{counter + 1111}} , {{computedA}}</span><br>
        <button @click="plusOne(0)">点我加一</button>
    </div>
</template>

<script>
import { mapActions, mapGetters, mapState } from 'vuex'
    export default {
        name: 'A',
        computed:{
            ...mapState('a',['counter']),
            ...mapGetters('a',['computedA'])
        },
        methods:{
            ...mapActions('a',['plusOne']),
        }
    }
</script>

<style>

</style>