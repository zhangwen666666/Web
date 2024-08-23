<template>
  <div class="footer" v-show="bugList.length">
    <button class="small red button" @click="clearResolved">清除已解决</button>
    <span>当前BUG总量{{ bugList.length }}个, 已解决{{ resolvedCount }}个</span>
  </div>
</template>

<script>
    export default {
        name: "BugFooter",
        props: ["bugList",],
        computed: {
            resolvedCount() {
                // 方案一 采用普通的计数器方式
                // console.log(111);
                // let count = 0;
                // this.bugList.forEach((bug) => {
                //     // console.log(bug.resolved);
                //     if (bug.resolved) {
                //         // console.log(333);
                //         count++;
                //     }
                // });
                // return count;

                // 方案二 采用数组的过滤器方法
                // return this.bugList.filter((bug) => {
                //     return bug.resolved === true
                // }).length

                // 方案三 使用ES6数组的reduce方法进行对数组条件统计
                // this.bugList.reduce(回调函数, 统计起点)
                // 统计起点从0开始。(统计起点就是第一次调用回调函数时a的值)
                // 回调函数有两个参数：a, b
                // 回调函数的调用次数和数组中元素总数有关系。数组中有三个元素，则这个回调函数被调用3次
                // 每一次回调函数都有一个返回值，本次的返回值会做为下一次调用回调函数时的a参数
                // a是什么? 上一次回调函数调用之后的返回值
                // b是什么? 当前被统计的对象 (bug对象)
                // return this.bugList.reduce((a, b) => {
                //     return a + (b.resolved ? 1 : 0)
                // }, 0)
                // 简写
                return this.bugList.reduce((a, b) => a + (b.resolved? 1 : 0), 0)
            },
        },
        methods: {
            clearResolved(){
                // console.log(666);
                // this.clearResolvedCallback()
				this.$emit('clearResolvedCallback')
            }
        }
    };
</script>

<style scoped>
/* footer */
.footer {
  margin-top: 10px;
}
.footer span {
  font-size: 12px;
}
</style>