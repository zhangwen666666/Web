<template>
    <div class="footer">
        <button class="small red button">清除已解决</button>
        <span>当前BUG总量2个, 已解决一个</span>
    </div>
</template>

<script>
    export default {
        name: 'BugFooter',
    }
</script>

<style scoped>
    /* footer */
    .footer{
        margin-top: 10px;
    }
    .footer span{
        font-size: 12px;
    }
</style>