package Singleton;
//java单例模式

//懒汉模式
class SingletonDemo1{
    private static SingletonDemo1 instance;
    private SingletonDemo1(){}

    public static SingletonDemo1 getInstance(){
        if(instance == null)
            instance = new SingletonDemo1();
        return instance;
    }
}

//线程安全的懒汉模式
class SingletonDemo2{
    private static SingletonDemo2 instance;
    private SingletonDemo2(){}

    public static synchronized SingletonDemo2 getInstance(){
        if(instance == null)
            instance = new SingletonDemo2();
        return instance;
    }
}

//饿汉模式
class SingletonDemo3{
    private static SingletonDemo3 instance;
    private SingletonDemo3(){}

    public static SingletonDemo3 getInstance(){
        return instance;
    }
}

//静态类内部加载
class SingletonDemo4{
    private static class SingletonHolder{
        private static SingletonDemo4 instance = new SingletonDemo4();
    }
    private SingletonDemo4(){
    }

    public static SingletonDemo4 getInstcnce(){
        return SingletonHolder.instance;
    }
}

//枚举方法
enum SingletonDemo{
    INSTANCE;
    public void otherMethods(){
        System.out.println("Something");
    }
}

//双重校验锁法
class SingletonDemo5{
    private volatile static SingletonDemo5 instance;
    private SingletonDemo5(){}

    public static SingletonDemo5 getInstance(){
        if(instance == null){
            synchronized (SingletonDemo5.class){
                if(instance == null)
                    instance = new SingletonDemo5();
            }
        }
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args){
        SingletonDemo.INSTANCE.otherMethods();
    }
}
