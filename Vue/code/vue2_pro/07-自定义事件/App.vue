<template>
    <div>
        <!-- 
        1.内置事件的实现步骤
            第一步：提供事件源（以下这个按钮就是一个事件源）
            第二步：给事件源绑定事件
                v-on:事件名  或者  @事件名
            第三步：编写回调函数，将回调函数和事件绑定
            第四步：等待事件的触发，只要事件触发，则执行回调函数。

2. 关于组件的自定义事件，实现步骤
    第一步：提供事件源（这个事件源是一个组件）
    第二步：给组件绑定事件
        v-on:事件名  或者  @事件名
    第三步：编写回调函数，将回调函数和事件绑定
    第四步：等待事件的触发，只要事件触发，则执行回调函数。
        注意：对于组件自定义事件来说，要想让事件发生，需要去执行一段代码。
        这段代码负责去触发这个事件，让这个事件发生。
        这段代码在哪里写？
            事件绑定在A组件上，则触发这个事件的代码要再A组件当中编写
            triggerEvent1(){
                // 编写触发事件event1的事件
                // 用vc的$emit()方法, 以下this就是组件对象vc
                // 触发事件的同时，可以给这个事件event1绑定的回调函数dosome传数据
                this.$emit('event1', this.name, this.age, this.gender)
            },

        3. 总结到目前为止，父子组件之间如何通信？
            父 ===> 子:
                props
            子 ===> 父:
                第一种方式：在父中定义一个方法，将方法传递给子，在子中调用父传过来的方法，
                           这样给父传递数据。（这种方式以后很少使用）
                第二种方式：使用组件自定义事件的方式，也可以向父传递数据
                    App组件是父组件，User组件是子组件。
                    子组件向父组件中传递数据 (User给App传递数据)
                        在父组件中绑定事件，在子组件中触发事件。

        4. 自定义事件也是支持once修饰符的（只触发一次）

        5. 通过写代码的方式也能完成自定义事件的绑定
            第一步：准备事件源，使用ref进行标记  <User ref="user"></User>
            第二步：在父组件的mounted()方法中完成绑定。mounted方法执行，页面生成了真实DOM，子组件就存在了
                mounted(){
                    // 给ref="user"的组件绑定event1事件，并且给event1事件绑定一个回调函数
                    this.$refs.user.$on('event1', this.dosome)
                    // 保证事件只触发一次
                    this.$refs.user.$once('event1', this.dosome)
                },
            第三步：编写回调函数，将回调函数和事件绑定。
            第四步：等待事件触发

        6. 解绑事件
            注意：解绑事件要在事件所绑定的组件上进行解绑（在组件的methods中编写解绑的代码）
                unbinding(){
                    // 仅仅解绑this所指向的这个组件实例上的event1事件。
                    this.$off('event1')
                    // 解绑多个事件，用数组的形式传参
                    // this.$off(['event1', 'event2'])
                    // 无参数表示解绑全部事件
                    // this.$off()
                }

        7. 销毁组件对象后，事件也会解绑

        8. 绑定事件时的回调函数
            第一种：this.$refs.user.$once('event1', this.dosome)，
                    this.dosome提前在组件的methods中定义好了,这个dosome方法里的this是App组件实例
            第二种：回调函数是普通函数
                    // 如果回调函数是普通函数：函数体当中的this是User组件实例，不是App组件实例
                    // 以下代码表示将这个普通函数交给this.$refs.user去管理，即User组件去管理
                    this.$refs.user.$on('event1', function(){
                        console.log(this);
                    })
            第三种：回调函数是箭头函数，函数体当中的this是App组件
        -->
        <button @click.once="hello">内置事件的实现步骤</button>

        <!-- 给User组件绑定一个自定义的事件 -->
        <!-- <User v-on:event1.once="dosome"></User> -->

        <!-- 绑定多个事件的组件 -->
        <User v-on:event1="dosome" @event2="doOther"></User>

        <!-- 简写形式 -->
        <User @event1="dosome" @event2="doOther"></User>

        <!-- 准备一个组件(事件源) -->
        <User ref="user"></User>
    </div>
</template>

<script>
    import User from './components/User.vue'
    export default {
        name:'App',
        mounted(){
            // this.$refs.user.$on('event1', this.dosome)
            // this.$refs.user.$once('event1', this.dosome)

            // 如果回调函数是普通函数：函数体当中的this是User组件实例，不是App组件实例
            // 以下代码表示将这个普通函数交给this.$refs.user去管理，即User组件去管理
            // this.$refs.user.$on('event1', function(){
            //     console.log(this);
            // })

            // 如果回调函数是箭头函数，函数体当中的this是App组件实例
            // 箭头函数没有this，只能往外找，外面是mounted,而mounted是App组件的一个生命周期钩子函数
            this.$refs.user.$on('event1', () => {
                console.log(this);
            })
            this.$refs.user.$once('event2',this.doOther)
        },
        components:{User},
        methods:{
            hello(){
                console.log('hello Vue');
            },
            // dosome(name, age, gender){
            //     // console.log(666);
            //     console.log(name, age, gender);
            // }

            // ES6新语法， ...params可以看做是一个数组，以数组的形式接收多个参数。
            dosome(name, ...params){
                // console.log(666);
                console.log(name, params);
            },
            doOther(){
                console.log('doOther....');
            }
        }
    }
</script>
