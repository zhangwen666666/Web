<template>
    <div>
        <!-- 绑定事件 -->
        <BugHeader @saveBugCallback="saveBugCallback"></BugHeader>
        <BugList :bugList="bugList" @selectAllCallback="selectAllCallback"></BugList>
        <BugFooter :bugList="bugList" @clearResolvedCallback="clearResolvedCallback"></BugFooter>
    </div>
</template>

<script>
    import pubsub from 'pubsub-js'
    import BugHeader from './components/BugHeader.vue'
    import BugList from './components/BugList.vue'
    import BugFooter from './components/BugFooter.vue'
    export default {
        //注册组件
        name: 'App',
        mounted(){
            // 订阅消息
            this.pid1 = pubsub.subscribe('modifyResolvedCallback', this.modifyResolvedCallback)
            this.pid2 = pubsub.subscribe('deleteByIdCallback', this.deleteByIdCallback)
            this.pid3 = pubsub.subscribe('updateDescCallback',this.updateDescCallback)
        },
        // 取消订阅
        beforeDestroy(){
            pubsub.unsubscribe(pid1)
            pubsub.unsubscribe(pid2)
            pubsub.unsubscribe(pid3)
        },
        data(){
            return {
                bugList:[
                    {id: '001', desc: 'BUG描述信息100',resolved: false},
                    {id: '002', desc: 'BUG描述信息2',resolved: true},
                    {id: '003', desc: 'BUG描述信息3',resolved: false},
                ]
            }
        },
        components: {
            BugHeader,BugList,BugFooter,
        },
        methods:{
            // 事件saveBugCallback所绑定的回调函数
            saveBugCallback(bug){
                this.bugList.unshift(bug)
            },

            // 修改某个bug对象的resolved值
            modifyResolvedCallback(messageName, id){
                this.bugList.forEach((bug) => {
                    if(bug.id === id){
                        bug.resolved = !bug.resolved
                        return
                    }
                })
            },

            // 根据id删除某个bug对象
            deleteByIdCallback(messageName, id){
                // filter方法返回的是一个全新的数组。
                this.bugList = this.bugList.filter((bug) => {
                    // 过滤条件，满足条件的被保留
                    return bug.id !== id
                })
            },

            // 全选或者取消全选
            selectAllCallback(flag){
                this.bugList.forEach((bug) => {
                    bug.resolved = flag
                })
            },

            // 清除已解决
            clearResolvedCallback(){
                this.bugList = this.bugList.filter((bug) => {
                    return bug.resolved !== true
                })
            },

            // 更新描述信息
            updateDescCallback(messageName, bugObj){
                this.bugList.forEach((bug) => {
                    if(bug.id === bugObj.id){
                        bug.desc = bugObj.desc
                        return
                    }
                })
            }
        },
    }
</script>


<style>
        /* 共享 */
    .button{
        display: inline-block;
        zoom: 1;
        padding: 6px 20px;
        margin: 0;
        cursor: pointer;
        border: 1px solid #bbb;
        overflow: visible;
        font: bold 13px arial, helvetica, sans-serif;
        text-decoration: none;
        white-space: nowrap;
        color: #555;
        background-color: #ddd;
        background-image: -webkit-gradient(linear, to right top, to right bottom, from(rgba(255,255,255,1)), to(rgba(255,255,255,0)));
        background-image: -webkit-linear-gradient(to bottom, rgba(255,255,255,1), rgba(255,255,255,0));
        background-image: -moz-linear-gradient(to bottom, rgba(255,255,255,1), rgba(255,255,255,0));
        background-image: -ms-linear-gradient(to bottom, rgba(255,255,255,1), rgba(255,255,255,0));
        background-image: -o-linear-gradient(to bottom, rgba(255,255,255,1), rgba(255,255,255,0));
        background-image: linear-gradient(to bottom, rgba(255,255,255,1), rgba(255,255,255,0));
        -webkit-transition: background-color .2s ease-out;
        -moz-transition: background-color .2s ease-out;
        -ms-transition: background-color .2s ease-out;
        -o-transition: background-color .2s ease-out;
        transition: background-color .2s ease-out;
        background-clip: padding-box; /* Fix bleeding */
        -moz-border-radius: 3px;
        -webkit-border-radius: 3px;
        border-radius: 3px;
        -moz-box-shadow: 0 1px 0 rgba(0, 0, 0, .3), 0 2px 2px -1px rgba(0, 0, 0, .5), 0 1px 0 rgba(255, 255, 255, .3) inset;
        -webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, .3), 0 2px 2px -1px rgba(0, 0, 0, .5), 0 1px 0 rgba(255, 255, 255, .3) inset;
        box-shadow: 0 1px 0 rgba(0, 0, 0, .3), 0 2px 2px -1px rgba(0, 0, 0, .5), 0 1px 0 rgba(255, 255, 255, .3) inset;
        text-shadow: 0 1px 0 rgba(255,255,255, .9);
        -webkit-touch-callout: none;
        -webkit-user-select: none;
        -khtml-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
    .button:active{
        background: #e9e9e9;
        position: relative;
        top: 1px;
        text-shadow: none;
        -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, .3) inset;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .3) inset;
        box-shadow: 0 1px 1px rgba(0, 0, 0, .3) inset;
    }
    .button.red{
        color: #fff;
        text-shadow: 0 1px 0 rgba(0,0,0,.2);
        background-image: -webkit-gradient(linear, to right top, to right bottom, from(rgba(255,255,255,.3)), to(rgba(255,255,255,0)));
        background-image: -webkit-linear-gradient(to bottom, rgba(255,255,255,.3), rgba(255,255,255,0));
        background-image: -moz-linear-gradient(to bottom, rgba(255,255,255,.3), rgba(255,255,255,0));
        background-image: -ms-linear-gradient(to bottom, rgba(255,255,255,.3), rgba(255,255,255,0));
        background-image: -o-linear-gradient(to bottom, rgba(255,255,255,.3), rgba(255,255,255,0));
        background-image: linear-gradient(to bottom, rgba(255,255,255,.3), rgba(255,255,255,0));
    }
    .button.red{
        background-color: #ca3535;
        border-color: #c43c35;
    }
    .button.red:hover{
        background-color: #ee5f5b;
    }
    .button.red:active{
        background: #c43c35;
    }
    .button.green{
        background-color: #57a957;
        border-color: #57a957;
    }
    .button.green:hover{
        background-color: #62c462;
    }
    .button.green:active{
        background: #57a957;
    }
</style>