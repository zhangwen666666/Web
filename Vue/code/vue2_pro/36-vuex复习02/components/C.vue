<template>
    <div>
        <h1>C组件</h1>
        <span>计数器3: {{counter}}</span><br>
        <span>计数器加8888: {{counter + 8888}} , {{computedC}}</span><br>
        <button @click="mulTwo(2)">点我乘二</button>
    </div>
</template>

<script>
import { mapActions, mapGetters, mapState } from 'vuex'
export default {
    name: 'C',
    computed: {
        ...mapState('c',['counter']),
        ...mapGetters('c',['computedC'])
    },
    methods:{
        ...mapActions('c',['mulTwo']),
    }
}
</script>

<style>

</style>