public abstract class Person {
    // 模板方法
    // 添加了final之后，这个方法无法被覆盖，这样核心的算法也可以得到保护
    // 模版方法定义核心的算法骨架，但具体的实现步骤可以延迟到子类中去实现
    // 模版算法得到保护，不能被改变，且算法得到了重复使用
    public final void day(){
        getUp();    // 起床
        freshenUp();    // 洗漱
        haveBreakfast();    // 吃早饭
        doSome();    // 做工作
        haveDinner();   // 吃晚餐
        sleep();    // 睡觉
    }

    void getUp(){
        System.out.println("起床");
    };

    void freshenUp(){
        System.out.println("洗漱");
    };

    void haveBreakfast(){
        System.out.println("吃早餐");
    };

    // 这一步骤具体怎么做，交给子类去完成
    abstract void doSome();

    void haveDinner(){
        System.out.println("吃晚餐");
    };

    void sleep(){
        System.out.println("睡觉");
    };
}
