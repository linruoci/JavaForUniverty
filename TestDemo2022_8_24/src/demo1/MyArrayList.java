package demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT_NAME: TestDemo2022_8_24
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/30 20:53
 */

// 看到实现List接口之后要实现的方法实在是有点多， 因此这里偷了一下懒， 只写了PPT上面的那些方法。

public class MyArrayList {

    private int[] elem;
    private int usedSize;


    public MyArrayList(){

        this.elem = new int[10];
        usedSize = 0;

    }




    // 打印顺序表

    public void display() {

        for (int i = 0; i < usedSize; i++){

            System.out.print(this.elem[i] + " ");

        }
        System.out.println();

    }

    private boolean isFull(){

        return this.elem.length == usedSize;

    }

    private void grow(){

        this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);

    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //如果满了， 就扩容。
        if (isFull()){

            grow();

        }

        this.elem[usedSize] = data;
        usedSize++;

    }

    //在pos位置插入元素
    public void add(int pos, int data) {
        //判断下标是否合法；
        if (pos < 0 || pos > usedSize){
            System.out.println("下标不合法！");
            return;

        }
        //判断数组是否已满， 满了则扩容。
        if (isFull()){
            grow();

        }
        //现在我们开始插入， 我们要进行挪动数组元素
        for (int i = usedSize - 1; i >= pos; i--){

            this.elem[i + 1] = this.elem[i];

        }

        this.elem[pos] = data;
        usedSize++;

    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++){

            if (this.elem[i] == toFind){

                return true;

            }


        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {

        for (int i = 0; i < usedSize; i++){

            if (this.elem[i] == toFind){
                return i;
            }

        }
        return -1;

    }
    // 获取 pos 位置的元素
    public int get(int pos) {
        //判断一下下标合不合法先
        if (pos < 0 || pos >= usedSize){
            throw new RuntimeException("该下标不合法！");
        }

        return this.elem[pos];

    }
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        //判断一下下标合不合法先。
        if (pos < 0 || pos >= usedSize){
            throw new RuntimeException("该下标不合法！");
        }
        this.elem[pos] = value;


    }

    private boolean isEmpty(){

        return this.usedSize == 0;


    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (isEmpty()){

            throw new RuntimeException("顺序表为空， 无法删除");

        }

        int index = indexOf(toRemove);

        if (index == -1){

            throw new RuntimeException("不存在你要删除的元素捏");

        }

        for (int i = index; i < usedSize - 1; i++){

            this.elem[i] = this.elem[i + 1];

        }
        this.usedSize--;

    }
    // 获取顺序表长度
    public int size() { return usedSize; }
    // 清空顺序表
    public void clear() {
        //这里如果是引用数据的话， 需要把所有的元素都置为null
//        for (int i = 0; i < usedSize; i++){
//
//            this.elem[i] = null;
//
//        }

        this.usedSize = 0;

    }


}
