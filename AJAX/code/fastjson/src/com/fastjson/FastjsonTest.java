package com.fastjson;
import com.alibaba.fastjson.JSON;

public class FastjsonTest {
    public static void main(String[] args) {
        // 创建一个User对象
        User user = new User(111, "zhangsan", 18);
        // 将以上的User对象转换成json格式的字符串
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
        // 将json格式的字符串转换成User对象
    }
}
