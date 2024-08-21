/*
    1. 插件是什么?
        插件是给Vue做功能增强的。
        插件是一个对象，这个对象中必须有install方法，这个方法会被自动调用。
    2. 插件一般都放到一个plugins.js文件中。
    3. 怎么定义插件
    4. 怎么导入插件
        在main.js中 import {p1} from './plugins.js'
    5. 怎么使用插件
        插件的使用通常放在创建Vue实例之前
        Vue.use(p1)
    6. 使用插件时可以传数据
*/


// 定义并暴露插件
export const p1 = {
    // 每一个插件对象中必须有一个install方法
    // 这个install方法会被自动调用
    // install方法上的参数包含两部分
    //      第一部分: Vue构造函数
    //      第二部分：可以接收用户在使用这个插件时传过来的数据，参数个数无限制
    install(Vue,a,b,c,d){
        console.log('插件正在工作');
        console.log(Vue);
        console.log(a,b,c,d);
        // 获取Vue的原型对象
        // 给Vue的原型对象扩展一个counter属性
        // 通过Vue的原型对象扩展的属性，通过vm和vc都能访问。
        Vue.prototype.counter = 1000
    }
}

