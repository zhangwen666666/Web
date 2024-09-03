<template>
    <div class="s3">
        <h2>ErZi组件 ({{counter}})</h2>
        <SunZi></SunZi>
    </div>
</template>

<script>
    import { inject } from 'vue';
    import SunZi from "./SunZi.vue";
    export default {
        name: 'ErZi',
        components: {SunZi},
        setup(){
            // 注入
            let counter = inject('c')
            return {counter}
        }
    }
</script>

<style lang="css" scoped>
	.s3{
		width: 300px;
		height: 300px;
		background-color: chartreuse;
	}
</style>