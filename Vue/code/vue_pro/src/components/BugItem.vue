<template>
    <tr>
        <td><input type="checkbox" :checked="bug.resovled" @click="modifyResolved"></td>
        <td>{{bug.desc}}</td>
        <td><button class="small red button">删除</button></td>
    </tr>
</template>

<script>
    export default {
        name: 'BugItem',
        props: ['bug'],
        methods: {
            
        }
    }
</script>

<style scoped>
    /* item */
    table tbody tr:nth-child(odd){
        background-color: #eee;
    }
    table tbody tr:hover{
        background-color: #ccc;
    }
    table tbody tr td:first-child{
        color: #f40;
    }
    td{
        border: 1px solid #999;
        text-align: center;
        padding: 5px 0;
    }
</style>