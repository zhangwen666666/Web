export const mix1 = {
    methods:{
        printInfo(){
            console.log(this.name, ',', this.age);
        }
    }
}

// 1. 什么是混入：Vip.vue和User.vue中有公共的代码，
// 2. 怎样混入
//      (1).将公共代码提取出来写到一个js文件中，并暴露出去
//      (2).在需要的位置上引入，并在vc中添加 mixins: [mix1,mix2,mix3] （局部混入）
// 3. 混入不是覆盖, 如果本身有a方法，会走本身的a方法而不会走混入的a方法
// 4. 混入对生命周期的8个钩子函数有特殊的处理
//      对于生命周期的8个钩子函数不会产生覆盖问题，并且俩个钩子函数都会执行
//      先执行混入的钩子函数，再执行原来的钩子函数
// 5. 全局混入是在入口文件中引入，并使用Vue.mixin(mix1)方式使用。

export const mix2 = {
    methods: {
        a(){
            console.log('mixin a ...');
        }
    }
}

export const mix3 = {
    mounted(){
        console.log('mixin.js mounted...');
    },
}



