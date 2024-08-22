<template>
    <div v-show="bugList.length">
        <table>
            <thead>
                <tr>
                    <!-- <th class="c1">全选 <input type="checkbox" :checked="isAll" @change="selectAll"></th> -->
                    <!-- 
                        使用双向数据绑定关联计算属性isAll 
                        input框中type="checkbox" 是复选框 不指定value时，会拿标签的checked属性值做为value
                        当点击复选框时，就会修改checked属性值，由于未指定value，value也会随着checked发生变化
                        而value发生改变，双向数据绑定导致计算属性isAll改变，就会自动调用其set方法
                    -->
                    <th class="c1">全选 <input type="checkbox" v-model="isAll"></th>
                    <th>bug描述</th>
                    <th class="c2">操作</th>
                </tr>
            </thead>
            <tbody>
                <BugItem v-for="bug in bugList" :key="bug.id" :bug="bug" 
                :deleteByIdCallback="deleteByIdCallback" 
                :modifyResolvedCallback="modifyResolvedCallback"
                :updateDescCallback="updateDescCallback"></BugItem>
            </tbody>
        </table>
    </div>
</template>

<script>
    import BugItem from './BugItem.vue'
    export default {
        name: 'BugList',
        components: {BugItem},
        props:['bugList','modifyResolvedCallback','deleteByIdCallback','selectAllCallback','updateDescCallback'],
        computed: {
            resolvedCount(){
                return this.bugList.reduce((a, b) => a + (b.resolved ? 1 : 0), 0)
            },
            // isAll(){
            //     return this.bugList.length === this.resolvedCount && this.bugList.length > 0
            // }

            // 双向数据绑定
            isAll: {
                get(){
                    // console.log('getter');
                    return this.bugList.length === this.resolvedCount && this.bugList.length > 0
                },
                set(value){
                    // console.log('setter');
                    this.selectAllCallback(value)
                }
            }
        },
        methods: {
            selectAll(event){
                // console.log(666);
                // 获取全选框是选中还是未选中
                // console.log(event.target.checked);
                this.selectAllCallback(event.target.checked)
            }
        }
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