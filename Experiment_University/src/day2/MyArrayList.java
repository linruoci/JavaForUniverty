package day2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @DATE: 2022/10/12 8:06
 * @PROJECT_NAME: Experiment_University
 * @author: 帅哥
 * @DESCRIPTION:实现一个有序顺序表
 */



public class MyArrayList {

   private int[] array;
   private int size;

   public MyArrayList(){

      array = new int[10];

   }



   private boolean ifFull(){

      return this.array.length == size;

   }

   private void grow(){

      this.array = Arrays.copyOf(array, 2 * array.length);

   }


   private void pushOfRest(int index){

      for (int i = size - 1; i >= index; i--){

         array[i + 1] = array[i];


      }


   }

   /**
    * 有序顺序表添加元素
    * @param value
    */
   public void add(int value){
//      如果数组满了， 就扩容
      if (ifFull()){

         grow();

      }

      //判断是否为第一次插入， 如果是， 直接加在数组中即可。

      if (size == 0){

         array[size++] = value;
         return;

      }

      //如果不是， 则需要进行判断， 判断需要将该值插在哪里。

      for (int i = 0; i < size; i++){

         if (value <= array[i]){

            //需要判断插入的这个位置上是否有值， 有值数组剩下的元素需要从此处向右移动一位。

            pushOfRest(i);
            array[i] = value;
            size++;
            return;

         }


      }

      array[size++] = value;

      //增加完毕。


   }


   private boolean isEmpty(){

      return this.size == 0;

   }

   /**
    * 该元素是要被删除的元素， 因此我们把这个位置后面所有的元素向前挪一位
    * @param index
    */
   private void pushBack(int index){

      for (int i = index;i < size - 1; i++){

         array[i] = array[i + 1];

      }


   }

   public void remove(int value){
      if (isEmpty()){
         RuntimeException e = new RuntimeException("顺序表为空，无法删除!");
         e.printStackTrace();
         return;
      }


      //如果不为空， 则开始寻找是否顺序表中有元素可以被删除
      boolean flag = false;
      for (int i = 0; i < size; i++){

         if (array[i] == value){
            flag = true;
            pushBack(i);
            size--;
            break;
         }

      }
      //如果flag为false，说明没有被删除， 因此需要进声明
      if (flag == false){

         RuntimeException e = new RuntimeException("没有找到你要删除的元素");
         e.printStackTrace();

      } else {

         System.out.println("删除成功");

      }


   }


   /**
    * 对数组的展示
    */
   public void display(){

      for (int i = 0; i < size; i++){

         System.out.print(array[i] + " ");

      }

   }




   @Override
   public String toString() {
      return "MyArrayList{" +
              "array=" + Arrays.toString(array) +
              '}';
   }
}
