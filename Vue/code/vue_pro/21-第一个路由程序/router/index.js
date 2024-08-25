// 导入vue-router插件
import VueRouter from "vue-router";

// 导入组件
import HeBei from '../components/hebei'
import HeNan from '../components/henan'

// 在这里创建路由器对象（在路由器对象中配置路由。）
const router = new VueRouter({
    // 在这里配置所有的路由规则
    routes: [
        // 这就是一个路由
        {
            // 这个可以看做是路由的key
            // 只要路径监测到的是 /hebei, 就切换到HeBei组件
            // 注意： 这个路径要以 / 开始
            path : '/hebei',
            // 这个可以看做就是路由的value，路由的value就是一个组件。
            component: HeBei
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