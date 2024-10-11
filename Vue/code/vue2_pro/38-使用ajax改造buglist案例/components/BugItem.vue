<template>
    <tr>
        <td><input type="checkbox" :checked="bug.selected" @change="modifySelected(bug.id)"></td>
        <td>
            <span class="desc" @click="edit" v-show="!isEdit">{{bug.desc}}</span>
            <input ref="inputDesc" type="text" v-show="isEdit" v-model="newDesc" @blur="update(bug.id)" @keydown.enter="$event.target.blur()" placeholder="请输入bug描述信息">
        </td>
        <td><button class="small red button" @click="del(bug.id)">删除</button></td>
    </tr>
</template>

<script>
    export default {
        name: 'BugItem',
        props:['bug'],
        data(){
            return {
                newDesc:'',
                isEdit:false
            }
        },
        methods: {
            del(bugId){
                // this.deleteBugCallBack(this.bug.id)
                this.$bus.$emit('deleteBugCallBack', bugId)
            },
            modifySelected(bugId){
                // this.modifySelectedCallBack(this.bug.id)
                this.$bus.$emit('modifySelectedCallBack', bugId)
            },
            edit(){
                this.isEdit=true
                this.$nextTick(function(){
                    this.$refs.inputDesc.focus()
                })
                

            },
            update(bugId){
                console.log('update');
                if(this.newDesc.trim() !== ''){
                    // console.log(6666);
                    // console.log(this.newDesc.trim());
                    // this.updateBugCallBack(this.bug.id, this.newDesc)

                    this.$bus.$emit('updateBugCallBack', bugId, this.newDesc)
                }
                this.isEdit = false
            },
        }
    }
</script>

<style>
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