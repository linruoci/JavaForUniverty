/**
 * @PROJECT_NAME: Test_2022_8_19
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/19 10:23
 */
public class Demo1 {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode node = binaryTree.createTree();


        System.out.println(binaryTree.isCompleteTree(node));

    }


}
