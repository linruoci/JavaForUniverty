/**
 * @DATE: 2022/10/16 14:57
 * @PROJECT_NAME: Test_JDBC_Programming
 * @author: 帅哥
 * @DESCRIPTION: 复习一下单例模式的实现. 饿汉模式
 */

class SingleTon{

    private static SingleTon instance = new SingleTon();

    public static SingleTon getInstance(){
        return instance;
    }


    private SingleTon(){

    }
}


class SingleTonLazy{
    private static SingleTonLazy instance = null;

    public static SingleTonLazy getInstance(){

        if (instance == null){
            instance = new SingleTonLazy();
        }
        return instance;


    }

    private SingleTonLazy(){}


}


public class Test01 {



}
