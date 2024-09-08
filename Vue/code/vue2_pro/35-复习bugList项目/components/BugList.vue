<template>
    <div>
        <table>
            <thead>
                <tr>
                    <!-- <th class="c1">全选 <input type="checkbox" :checked="isAll" @change="selectAll"></th> -->
                    <th class="c1">全选 <input type="checkbox" v-model="isAll"></th>
                    <th>bug描述</th>
                    <th class="c2">操作</th>
                </tr>
            </thead>
            <tbody>
                <!-- <BugItem v-for="bug in bugList" :key="bug.id" :bug="bug" :deleteBugCallBack="deleteBugCallBack"
                :modifySelectedCallBack="modifySelectedCallBack" :updateBugCallBack="updateBugCallBack"/> -->

                <BugItem v-for="bug in bugList" :key="bug.id" :bug="bug"/>
            </tbody>
        </table>
    </div>
</template>

<script>
    import BugItem from './BugItem.vue'
    export default {
        name: 'BugList',
        components: {BugItem},
        // props: ['bugList','deleteBugCallBack', 'modifySelectedCallBack','updateBugCallBack', 'selectAllCallBack', 'selectedCount'],
        // props: ['bugList','deleteBugCallBack', 'modifySelectedCallBack','updateBugCallBack', 'selectedCount'],
        props: ['bugList', 'selectedCount'],
        computed:{
            // isAll(){
            //     if(this.bugList.length === 0) return false
            //     let selectedCount = 0
            //     this.bugList.forEach((bug) => {
            //         if(bug.selected === true){
            //             // console.log(666);
            //             selectedCount++
            //         }
            //     })
            //     // console.log(selectedCount);
            //     if(selectedCount === this.bugList.length){
            //         return true
            //     }
            //     return false
            // },

            isAll:{
                get(){
                    // if(this.bugList.length === 0) return false
                    // let selectedCount = 0
                    // this.bugList.forEach((bug) => {
                    //     if(bug.selected === true){
                    //         selectedCount++;
                    //     }
                    // })
                    // if(selectedCount === this.bugList.length)
                    //     return true
                    // return false
                    if(this.selectedCount === 0 || this.selectedCount !== this.bugList.length)
                        return false
                    return true
                },
                set(value){
                    // this.selectAllCallBack(value)
                    // 触发事件
                    this.$emit('selectAllCallBack',value)
                }
            }
        },
        methods: {
            selectAll(event){
                // console.log(this.isAll);
                // console.log(event.target.checked);
                // if(this.isAll === true){
                //     this.selectAllCallBack(true)
                // }else{
                //     this.selectAllCallBack(false)
                // }
                this.selectAllCallBack(event.target.checked)
            }
        }
    }
</script>

<style>
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