import java.util.Arrays;

/**
 * @PROJECT_NAME: Test2022_8_23
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/23 16:31
 */
public class TestHeap {


    private int[] elem;
    private int usedSize;


    public TestHeap(){

        this.elem = new int[10];

    }



    public void createHeap(int[] array){

        for (int i = 0; i < array.length; i++){

            this.elem[i] = array[i];
            usedSize++;

        }

        for (int p = (usedSize - 1 - 1) / 2; p >= 0; p--){


            shiftDown(p, usedSize);

        }


    }

    private void shiftDown(int p, int len) {

        int parent = p;
        int children = 2 * p + 1;

        while (children < len){

            if (children + 1 < len && elem[children] < elem[children + 1]){

                children++;
            }
            //到这里的时候， 存储的是孩子中最大值的下标。

            if (elem[children] > elem[parent]){
                int tmp = elem[children];
                elem[children] = elem[parent];
                elem[parent] = tmp;
                parent = children;
                children = 2 * parent + 1;

            } else {
                break;
            }

        }



    }


    public void push(int val){
        if (isFull()){

            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);

        }

        this.elem[usedSize] = val;

        shiftUp(usedSize);

        usedSize++;

    }

    private void shiftUp(int children){

        int parent = (children - 1) / 2;

        while (children > 0){

            if (this.elem[children] > this.elem[parent]){
                int tmp = elem[children];
                elem[children] = elem[parent];
                elem[parent] = tmp;

                children = parent;
                parent = (children - 1) / 2;



            } else {
                break;
            }



        }


    }


    public boolean isFull(){

        return this.usedSize == this.elem.length;


    }

    /**
     * 删除元素
     */
    public void poll(){
        if (isEmpty()){
            System.out.println("堆为空！");
            return;
        }
        //将第一个元素和最后一个元素做交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize - 1];
        this.elem[usedSize - 1] = tmp;
        usedSize--;
        shiftDown(0, usedSize);


    }

    public boolean isEmpty(){

        return usedSize == 0;


    }


    //从小到大排序， 建一个大根堆
    public void sortHeap(){

        int end = usedSize - 1;

        while (end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end]  = tmp;
            shiftDown(0, end);
            end--;
        }




    }



}
