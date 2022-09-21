package day7;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/21 8:40
 */
public class Solution2 {

    static class A{
        protected  int value;
        public A(int v){

            setValue(v);

        }


        public void setValue(int value){


            this.value = value;


        }

        public int getValue(){

            try{
                value++;
                return value;

            } catch(Exception e){

                e.printStackTrace();

            } finally {

                this.setValue(value);
                System.out.println(value);

            }
            return value;


        }



        static class B extends A{
            public B(){

                super(5);
                setValue(getValue() - 3);

            }

            public void setValue(int value){

                super.setValue(2 * value);

            }



        }

        public static void main(String[] args) {

            System.out.println(new B().getValue());

        }



    }



}
