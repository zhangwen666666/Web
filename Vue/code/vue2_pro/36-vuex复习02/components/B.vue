<template>
    <div>
        <h1>B组件</h1>
        <span>计数器2: {{counter}}</span><br>
        <span>计数器2加6666: {{counter + 6666}}, {{computedB}}</span><br>
        <button @click="SUBONE(1)">点我减一</button>
    </div>
</template>

<script>
import { mapGetters, mapMutations, mapState } from 'vuex'
    export default {
        name: 'B',
        computed:{
            ...mapState('b',['counter']),
            ...mapGetters('b',['computedB'])
        },
        methods:{
            ...mapMutations('b',['SUBONE'])
        }
    }
</script>