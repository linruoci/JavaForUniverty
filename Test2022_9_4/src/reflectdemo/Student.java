package reflectdemo;

/**
 * @PROJECT_NAME: Test2022_9_4
 * @DESCRIPTION: 演示反射的使用。
 * @USER: 帅哥
 * @DATE: 2022/9/4 10:44
 */


class Student { //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18; //不带参数的构造方法

    public Student() {
        System.out.println("reflectdemo.Student()");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("reflectdemo.Student(String,name)");
    }

    private void eat() {
        System.out.println("i am eat");
    }

    public void sleep() {
        System.out.println("i am pig");
    }

    private void function(String str) {
        System.out.println(str);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
