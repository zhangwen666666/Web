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
        // props:['bugList'],
        // 接收父组件传递的回调函数
        props: ['saveBugCallback'],
        methods:{
            save(){
                // 如果文本域去除空格之后是空串，则不用保存
                if(!(this.desc.trim())) return

                // console.log('save BUG'); 
                // 获取desc 使用v-model进行双向数据绑定即可

                // 创建bug对象
                let bugObj = {id: Date.now(), desc: this.desc, resolved:false}
                // console.log(bugObj);

                // 添加到bugList数组当中
                // 下面这种做法是不对的，因为props是不允许修改的
                // this.bugList.unshift(bugObj)

                // 下面这种是对的
                this.saveBugCallback(bugObj)

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
