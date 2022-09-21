package demo2;

public enum TestEnum{

    RED("红色", 0),BLACK, GREEN, WHITE;


    private String name;
    private int num;

    TestEnum(){



    }

    //要注意的是，这里默认会有两个隐式参数给我的父类。
    TestEnum(String name, int num){
        this.name = name;
        this.num = num;

    }





    public static void main(String[] args) {

        TestEnum test = TestEnum.valueOf("RED");
        System.out.println(test);

    }



    public static void main2(String[] args) {

        TestEnum[] array = TestEnum.values();

        System.out.println(array[0].compareTo(array[1]));


        for (TestEnum x : array){


            System.out.println("颜色为 : " + x + "序号为: " + x.ordinal());

        }


    }






    public static void main1(String[] args) {

        TestEnum testEnum = TestEnum.BLACK;


        switch (testEnum){

            case RED:
                System.out.println("nihao");
                System.out.println("nihao");
            case BLACK:
                System.out.println("BLACK");
                break;
            default:
                System.out.println("fafafafafaf");


        }

    }







}
