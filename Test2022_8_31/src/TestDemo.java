/**
 * @PROJECT_NAME: Test2022_8_31
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/31 23:13
 */


public class TestDemo {


    public static void main(String[] args) {

        BinarySearchTree tmp = new BinarySearchTree();

        int[] arr = {5, 3, 20, 1, 4, 0, 2, 20, 10, 30, 40};

        for (int i = 0; i < arr.length; i++){

            tmp.insert(arr[i]);

        }
        tmp.insert(8);

        BinarySearchTree.TreeNode ret = tmp.toFind(888);
        System.out.println("找到：" + ret.key);

        System.out.println("fafafafa");

    }


}
