/**
 * @PROJECT_NAME: Test_2022_8_19
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/19 10:16
 */
public class BinaryTree {


    public class TreeNode{

        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value) {

            this.value = value;

        }
    }

    public TreeNode createTree(){

        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');



        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        E.right = H;

        C.left = F;
        C.right = G;

        return A;
    }


    public void preOrder(TreeNode root){
        if (root == null) return;

        System.out.print(root.value + " ");

        preOrder(root.left);
        preOrder(root.right);


    }


    public int leafSize;

    // 获取叶子节点的个数
    int getLeafNodeCount(TreeNode root){
        if (root == null) return 0;

        if (root.left == null && root.right == null){
            leafSize++;
        }

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);

        return leafSize;

    }



    int getLeafNodeCount1(TreeNode root){

        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.right);

    }

}
