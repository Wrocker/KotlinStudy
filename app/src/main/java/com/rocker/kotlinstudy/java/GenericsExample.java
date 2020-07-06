package com.rocker.kotlinstudy.java;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rocker.kotlinstudy.StudyApplication;

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


        //? extends T 上界通配符, 表示能传入自身及子类
        SingleViewSurface<? extends View> extendsTemp = new SingleViewSurface<>(new TextView(StudyApplication.context));
        //限制：上界<? extends T>不能往里存，只能往外取
        //由于SingleViewSurface<? extends View>中的view可能为ImageView或View等，因此无法判断，set会报错
//        extendsTemp.setView(new ImageView(StudyApplication.context));

        //? super T 下界通配符 表示能传入自身及父类
        SingleViewSurface<? super Button> superTemp = new SingleViewSurface<>(new TextView(StudyApplication.context));
        //限制：下界<? super T>不影响往里存
        //由于SingleViewSurface<? super Button>中的view可能为Button、TextView或View等其他超类，因此无法判断，set会报错
//        superTemp.setView(new TextView(StudyApplication.context));
//        superTemp.setView(new View(StudyApplication.context));
        //由于SingleViewSurface<? super Button>中的view可能为Button、TextView或View等其他超类
        //但由于限定了超类至少是Button，因此，Button子类都能设置进去
        superTemp.setView(new Button(StudyApplication.context));
        superTemp.setView(new CheckBox(StudyApplication.context));
        superTemp.setView(new CompoundButton(StudyApplication.context) {
        });
        //但往外取只能放在Object对象里
//        Button button = superTemp.getView();
//        TextView textView = superTemp.getView();
        Object temp = superTemp.getView();
    }

}

class SingleViewSurface<T> { //不加out,下面方法编译报错

    private T view;

    public SingleViewSurface(T view) {//上界通配符 类似于kotlin中的out
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }
}
