<template>
    <div class="header">
        <textarea cols="105" rows="4" placeholder="请输入BUG的描述信息" v-model.lazy.trim="desc"></textarea>
        <!-- {{desc}} -->
        <br>
        <button class="small green button" @click="save">保存</button>
    </div>
</template>

<script>
    export default {
        name:'BugHeader',
        // props:['saveBugCallBack'],
        data(){
            return {
                desc:''
            }
        },
        methods: {
            save(){
                if(this.desc === '') return
                // this.saveBugCallBack({id: Date.now(), desc: this.desc, selected: false});
                
                // 触发事件
                this.$emit('saveBugCallBack', {id: Date.now(), desc: this.desc, selected: false})
                this.desc = ''
            }
        }
    }
</script>

<style>
    .header {
        margin-bottom: 20px;
        margin-top: 20px;
    }
</style>