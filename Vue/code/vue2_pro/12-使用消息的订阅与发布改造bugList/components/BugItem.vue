<template>
    <tr>
        <!-- <td><input type="checkbox" :checked="bug.resovled" @click="modifyResolved"></td> -->
        <!-- 也可以使用change事件 -->
        <td><input type="checkbox" :checked="bug.resolved" @change="modifyResolved(bug.id)"></td>
        <!-- 以下这种方式也能实现打钩与resovled属性的关联，但是不建议 -->
        <!-- <td><input type="checkbox" v-model="bug.resovled"></td> -->
        <td>
            <span class="desc" v-show="!bug.editState" @click="enterEdit(bug)">{{bug.desc}}</span>
            <input ref="inputDesc" type="text" :value="bug.desc" v-show="bug.editState" @blur="updateDesc(bug, $event)">
        </td>
        <td><button class="small red button" @click="deleteById(bug.id)">删除</button></td>
    </tr>
</template>

<script>
    import pubsub from 'pubsub-js'
    export default {
        name: 'BugItem',
        props: ['bug',],
        methods: {
            modifyResolved(id){
                // console.log(666);
                // console.log(id);
                // this.modifyResolvedCallback(id)
                // this.$bus.$emit('modifyResolvedCallback', id)
                pubsub.publish('modifyResolvedCallback', id)
            },
            deleteById(id){
                // console.log(id);
                // this.deleteByIdCallback(id)
                // this.$bus.$emit('deleteByIdCallback', id)
                pubsub.publish('deleteByIdCallback', id)
            },

            // 进入编辑状态
            enterEdit(bug){
                // console.log(666);
                // 显示input框，隐藏span
                // 增加属性editState，并且该属性要具备响应式
                if(bug.hasOwnProperty('editState')){
                    bug.editState = true
                }else {
                    // 这里的代码只执行一次
                    this.$set(bug,'editState',true)
                }
                // 获取文本框，并且让文本框获取焦点
                // 由于Vue为了效率，在整个enterEdit()方法执行结束，才会进行渲染
                // 也就是说，enterEdit()执行到这里时，this.$refs.inputDesc压根不存在
                // this.$refs.inputDesc.focus()
                // 解决方案一：定时任务
                // setTimeout(() => {
                //     this.$refs.inputDesc.focus()
                // }, 100)
                // 方案二：使用Vue提供好的API就行了
                // $nextTick()方法会绑定一个回调函数，这个回调函数在下一次DOM元素全部渲染完成之后执行
                this.$nextTick(function(){
                    this.$refs.inputDesc.focus()
                })
            },

            updateDesc(bug, event){
                // console.log(bugId);
                // 最新描述信息怎么获取？
                let newDesc = event.target.value.trim()
                if(!newDesc) return
                // console.log(event.target.value);
                // 更新
                // this.updateDescCallback(bug.id, event.target.value)
                // this.$bus.$emit('updateDescCallback',bug.id, event.target.value)
                bug.desc = newDesc
                pubsub.publish('updateDescCallback',bug)
                // 更新之后要隐藏文本框
                bug.editState = false
            }
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
    .desc{
        cursor:pointer
    }
</style>