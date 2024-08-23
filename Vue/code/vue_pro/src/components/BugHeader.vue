<template>
    <div class="header">
        <textarea cols="105" rows="4" placeholder="请输入bug的描述信息" v-model="desc"></textarea>
        <br>
        <button class="small green button" @click="save()">保存</button>
    </div>
</template>

<script>
    export default {
        name: 'BugHeader',
        methods:{
            save(){
                // 如果文本域去除空格之后是空串，则不用保存
                if(!(this.desc.trim())) return

                // 创建bug对象
                let bugObj = {id: Date.now(), desc: this.desc, resolved:false}

                // 触发事件
                this.$emit('saveBugCallback', bugObj)

                // 清空文本域
                this.desc = ''
            }
        },
        data(){
            return {
                desc: ''
            }
        }
    }
</script>

<style scoped>
    /* header */
    .header {
        margin-bottom: 20px;
        margin-top: 20px;
    }
</style>
