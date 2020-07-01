package com.rocker.kotlinstudy.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛性例子
 */
class GenericsExample {

    void example(){

        List<String> strs = new ArrayList<String>();
//        List<Object> objs = strs; // ！！！此处的编译器错误让我们避免了之后的运行时异常
//        objs.add(1); // 这里我们把一个整数放入一个字符串列表
//        String s = strs.get(0); // ！！！ ClassCastException：无法将整数转换为字符串

    }


}
