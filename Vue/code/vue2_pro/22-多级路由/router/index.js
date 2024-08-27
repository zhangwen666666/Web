// 导入vue-router插件
import VueRouter from "vue-router";

// 导入组件
// 一般路由组件会放在一个pages文件夹下
import HeBei from '../pages/HeBei'
import HeNan from '../pages/HeNan'
import ShiJiaZhuang from '../pages/ShiJiaZhuang'
import HanDan from '../pages/HanDan'

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
                // 这是其中的一个子路由
                {
                    // 注意：对于子路由来说，这个patch不要以 / 开始，这个 / 系统会自动添加
                    path:'shijiazhuang',
                    component : ShiJiaZhuang
                },
                {
                    path: 'handan',
                    component: HanDan
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