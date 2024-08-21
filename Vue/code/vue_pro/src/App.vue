<template>
    <div>
        <!-- <BugHeader :bugList="bugList"></BugHeader> -->
        <BugHeader :saveBugCallback="saveBugCallback"></BugHeader>
        <BugList :bugList="bugList"></BugList>
        <BugFooter></BugFooter>
    </div>
</template>

<script>
    import BugHeader from './components/BugHeader.vue'
    import BugList from './components/BugList.vue'
    import BugFooter from './components/BugFooter.vue'
    export default {
        //注册组件
        name: 'App',
        data(){
            return {
                bugList:[
                    {id: '001', desc: 'BUG描述信息100',resovled: false},
                    {id: '002', desc: 'BUG描述信息2',resovled: true},
                    {id: '003', desc: 'BUG描述信息3',resovled: false},
                ]
            }
        },
        components: {
            BugHeader,BugList,BugFooter,
        },
        methods:{
            // 保存bug对象的回调方法
            // 函数也是一个对象，可以传给子组件，子组件使用props接收
            saveBugCallback(bug){
                this.bugList.unshift(bug)
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