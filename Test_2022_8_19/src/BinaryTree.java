import java.util.*;

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

    // 获取二叉树的高度
    int getHeight(TreeNode root){
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        return leftH > rightH? leftH + 1: rightH+1;


    }

    TreeNode find(TreeNode root, char val){
        if (root == null) return null;

        if (root.value == val) return root;


        TreeNode tmp = find(root.left, val);

        if (tmp != null) return tmp;

        tmp = find(root.right, val);
        if (tmp != null) return tmp;

        return null;



    }

    void levelOrder(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            TreeNode tmp = queue.poll();
            System.out.print(tmp.value + " ");

            if (tmp.left != null) {

                queue.offer(tmp.left);
            }

            if (tmp.right != null) {

                queue.offer(tmp.right);
            }

        }

    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if (root == null) return true;


        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();

            if (cur != null){

                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }

        }

        while (!queue.isEmpty()){

            TreeNode tmp = queue.peek();

            if (tmp != null){
                return false;
            } else {
                queue.poll();
            }

        }

        return true;

    }





//    public int preIndex;
//    public TreeNode buildTreeChild(int[] preorder, inorder, inbegin, inend){
//        if (inbegin > inend) return null;
//
//        int rootIndex = findPreorderIndex(preorder, preorder[preIndex]);
//        preIndex++;
//
//
//        root.left = buildTreeChild(preorder, inorder, inbegin, rootIndex - 1);
//        root.right = buildTreeChild(preorder, inorder, rootIndex + 1, inend );
//
//
//        return root;
//    }
//
//
//    public int findPreorderIndex(int[] preorder, int val){
//
//        for (int i = 0; i < preorder.length - 1, i++){
//
//            if (preorder[i] == val){
//                return i;
//            }
//
//        }
//        return -1;
//
//    }
//
//


//    public int preIndex;
//    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend){
//        if (inbegin > inend) return null;
//
//        int rootIndex = findPreorderIndex(preorder, preorder[preIndex]);
//        TreeNode root = new TreeNode(preorder[rootIndex]);
//        preIndex++;
//
//
//        root.left = buildTreeChild(preorder, inorder, inbegin, rootIndex - 1);
//        root.right = buildTreeChild(preorder, inorder, rootIndex + 1, inend );
//
//
//        return root;
//    }
//
//
//    public int findPreorderIndex(int[] preorder, int val){
//
//        for (int i = 0; i < preorder.length - 1, i++){
//
//            if (preorder[i] == val){
//                return i;
//            }
//
//        }
//        return -1;
//
//    }
//
//
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//
//        buildTreeChild(preorder, inorder, 0, inorder.length - 1);
//
//    }



//    public void tree2strChild(StringBuilder sb, TreeNode root){
//        if (root == null) return;
//
//        sb.append(root.val);
//
//        if (root.left != null){
//            sb.append("(");
//            tree2strChild(sb, root.left);
//            sb.append(")");
//        } else {
//
//            if (root.right == null){
//                return;
//            } else {
//                sb.append("()");
//            }
//
//        }
//
//        if (root.right != null){
//            sb.append("(");
//            tree2strChild(sb, root.right);
//            sb.append(")");
//        } else {
//            return;
//        }
//
//
//    }
//
//
//    public String tree2str(TreeNode root) {
//        if (root == null) return null;
//
//        StringBulider sb = new StringBulider();
//
//        tree2strChild(sb, root);
//
//        return sb.toString();
//
//    }


}
