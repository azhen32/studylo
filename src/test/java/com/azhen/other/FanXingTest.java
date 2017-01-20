package com.azhen.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azhen on 17-1-18.
 */
class Function{
    public <T> List<T> reduct(List<T> list) {
        return list;
    }
}
class Plant {}
class Fruit extends Plant{}
class Apple extends Fruit {}
class Banana extends Apple{}
class Cat {}
class Box<T> {
    private List<T> item;
    public List<T> get() {return item;}
    public void set(List<T> t) {item = t;}
    public void getSet(Box<?> box){helper(box);}
    public <V> void helper(Box<V> box){box.set(box.get());}

}
public class FanXingTest<T> {
    /**
     *
     */
    public static void test1(String[] args) {
        List<?> apples = new ArrayList<Apple>();
        List<?> plants = new ArrayList<Plant>();
        List<?> cats = new ArrayList<Cat>();
        //1.不同的List<?>之间可以相互赋值
        plants = apples;
        apples = plants;
        cats = plants;
        //2.给List<?>初始化后就不能往里面再添加任何东西了，Object也不可以，但是可以添加null
        plants.add(null);
        //fruits.add(new Apple());
        //apples.add(new Apple());
        //fruits.add(new Object());
        plants.add(null);
        //3.List<?>与List<Object>的区别：
        //List<?>只能容纳一种类型的对象，是一个同构集合
        //List<Object>可以容纳任意Object类型或Object子类的对象，是一个异构集合
    }

    /**
     *
     */
    public static void test2(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        List<? extends Fruit> fruits = new ArrayList<Fruit>();
        List<Cat> cats = new ArrayList<Cat>();
        fruits = apples;    //1.子类型可以赋值给父类型
        //fruits = cats; //没有继承关系的类型不能赋值
        //3.可以读取T类型或其父类型，不能写
        //fruits.add(new Fruit());
        //fruits.add(new Apple());
        Fruit fruit = fruits.get(0);
        Plant plant = fruits.get(0);
        //Apple apple = fruits.get(0);
        //3.泛型父类可以下转型
        //apples = fruits;
        apples = (List<Apple>)fruits;
    }

    public static void test3(String[] args) {
        List<Fruit> fruits = new ArrayList<Fruit>();
        List<? super Apple> apples = new ArrayList<Apple>();
        List<Cat> cats = new ArrayList<Cat>();
        //1.父泛型可以赋值给下界
        apples = fruits;
        //apples = cats;
        //2.可以写入T类型或其子类型,这样可以确保向上转型成功
        apples.add(new Apple());
        apples.add(new Banana());
        //apples.add(new Fruit());
        //Apple apple = apples.get(0);
    }

    /**
     * 可以加入任何类型，使容器失去泛型能力，不能进行类型检查
     */
    public static void test4(String[] args) {
        List fruits = new ArrayList<Fruit>();
        fruits.add(new Apple());
        fruits.add(new Cat());
        fruits.add(new Banana());
    }

    public static void test5(String[] args) {
        List<?> fruits = new ArrayList();
    }

    public static void main(String[] args) {

    }
}
