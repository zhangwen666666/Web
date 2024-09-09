<template>
    <div>
        <A/>
        <B/>
        <C/>
    </div>
</template>

<script>
    import A from './components/A.vue'
    import B from './components/B.vue'
    import C from './components/C.vue'
    export default {
        name: 'App',
        mounted(){
            // console.log(this.$store);
        },
        methods:{

        },
        components:{A, B, C}
    }
</script>
