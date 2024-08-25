<template>
    <div>
        <div>
            <h1>省份</h1>
            <ul>
                <li><a href="./hebei.html" class="selected">河北省</a></li>
                <li><a href="./henan.html">河南省</a></li>
            </ul>
        </div>

        <!-- 这个位置将来是要显示对应的组件的 -->
        <!-- <HeBei></HeBei>
        <HeNan></HeNan> -->
    </div>
</template>

<script>
/*     import HeBei from './components/hebei.vue'
    import HeNan from './components/henan.vue' */
    export default {
        name: 'App',
        // components: {HeBei,HeNan}
    }
</script>

<style lang="css">
    .s1{
        margin-left: 100px;
    }
    .selected{
        background-color: aqua;
    }
</style>