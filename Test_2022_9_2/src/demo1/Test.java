package demo1;

/**
 * @PROJECT_NAME: Test_2022_9_2
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/3 13:21
 */
public class Test {


    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,3,4,1,7,8,2,6,0,9};

        for (int i = 0; i < array.length; i++){

            binarySearchTree.insert(array[i]);

        }
//
//
//        BinarySearchTree.TreeNode node = binarySearchTree.search(8);
//        System.out.println(node.key);

        binarySearchTree.remove(5);

        System.out.println("fafafafa");



    }



}
