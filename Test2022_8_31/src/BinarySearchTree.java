/**
 * @PROJECT_NAME: Test2022_8_31
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/31 23:13
 */
public class BinarySearchTree {

    static class TreeNode{

        public int key;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    TreeNode root;

    public boolean insert(int data){


        if (root == null){

            root = new TreeNode(data);
            return true;
        }

        TreeNode pre = null;
        TreeNode cur = root;

        while (cur != null){

            if (cur.key < data){
                pre = cur;
                cur = cur.right;


            } else if (cur.key > data){

                pre = cur;
                cur = cur.left;

            } else {
                //二叉搜索树不允许出现重复的情况
                return false;

            }


        }

        //从这里出来之后， cur必定是一个空节点；

        TreeNode tmp = new TreeNode(data);
        if (pre.key < data){

            pre.right = tmp;


        } else {

            pre.left = tmp;

        }
        return true;

    }

    //接下来是二叉搜索树的查询
    public TreeNode toFind(int data){

        TreeNode cur = root;

        while (cur != null){

            if (cur.key == data){

                return cur;

            } else if (cur.key < data){

                cur = cur.right;

            } else {

                cur = cur.left;

            }


        }

        return null;


    }



}
