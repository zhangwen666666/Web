// 导入vue-router插件
import VueRouter from "vue-router";

// 导入组件
// 一般路由组件会放在一个pages文件夹下
import HeBei from '../pages/HeBei'
import HeNan from '../pages/HeNan'
import City from '../pages/City'

// 在这里创建路由器对象（在路由器对象中配置路由。）
const router = new VueRouter({
    // 在这里配置所有的路由规则
    routes: [
        // 这就是一个路由
        {
            path : '/hebei',
            component: HeBei,
            // 子路由
            children: [
                {
                    name: 'shi',
                    path: 'sjz/:a1/:a2/:a3',
                    component: City,
                    // 在路由当中进行配置。
                    // 写死的
                    // props: {
                    //     x: '张三',
                    //     y: '李四'
                    // }

                    // props还有一种函数式写法
                    // $route将来会被自动传过来，他代表了当前的路由对象。变量名随意
                    // props($route){
                    //     return {
                    //         // 如果是query传参，下面就是$route.query
                    //         a1: $route.params.a1,
                    //         a2: $route.params.a2,
                    //         a3: $route.params.a3,
                    //         x: '李四',
                    //         y: '王五'
                    //     }
                    // }

                    // 这种方式只支持params方式的传参，不支持query方式。
                    // 将params对象直接转换成props对象，内部直接转，不需要我们负责
                    props: true
                },
                {
                    name:'han',
                    path: 'hd/:a1/:a2/:a3',
                    component: City,
                    // props(t){
                    //     return {
                    //         a1: t.params.a1,
                    //         a2: t.params.a2,
                    //         a3: t.params.a3,
                    //         x : '邯郸李四',
                    //         y : '邯郸王五',
                    //     }
                    // }

                    props: true
                }
            ]
        },

        // 这是另一个路由
        {
            path : '/henan',
            component: HeNan
        }
    ]
})

// 导出路由器对象
export default router