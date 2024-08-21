<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th class="c1">全选 <input type="checkbox"></th>
                    <th>bug描述</th>
                    <th class="c2">操作</th>
                </tr>
            </thead>
            <tbody>
                <BugItem v-for="bug in bugList" :key="bug.id" :bug="bug"></BugItem>
            </tbody>
        </table>
    </div>
</template>

<script>
    import BugItem from './BugItem.vue'
    export default {
        name: 'BugList',
        components: {BugItem},
        props:['bugList']
    }
</script>

<style scoped>
  /* list */
    table{
        width: 40%;
        border-collapse: collapse;
    }
    table caption{
        font-size: 1em;
        font-weight: bold;
        margin: 1em 0;
    }
    .c1,.c2{
        width: 100px;
    }
    th {
        border: 1px solid #999;
        text-align: center;
        padding: 5px 0;
    }
    table thead tr{
        background-color: #008c8c;
        color: #fff;
    }
</style>