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
                // {
                //     path:'city',
                //     component : City
                // },

                {
                    // 给路由命名 ，链接时路径就可以使用名字来代替
                    name: 'shi',
                    // 使用params传参时, 参数位置需要使用 : 标注
                    path: 'sjz/:a1/:a2/:a3',
                    component: City
                },
                {
                    name:'han',
                    path: 'hd/:a1/:a2/:a3',
                    component: City
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