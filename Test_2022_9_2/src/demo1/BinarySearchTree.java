package demo1;

public class BinarySearchTree {
 
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
 
        TreeNode(int key) {
            this.key = key;
        }
    }
 
    public TreeNode root;
 
    /**
     * 插入一个元素
     * @param key
     */
    public boolean insert(int key) {

        TreeNode node = new TreeNode(key);
        if (root == null){
            root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {

            if (cur.key < key) {
                pre = cur;
                cur = cur.right;

            } else if (cur.key == key) {

                return false;

            } else {

                pre = cur;
                cur = cur.left;

            }

        }
            //到这里之后， cur找到了一个空的位置，

            if (pre.key < key){

                pre.right = node;

            } else {

                pre.left = node;

            }
            return true;





    }
    //查找key是否存在
    public TreeNode search(int key) {

        TreeNode cur = root;

        while (cur != null){

            if (cur.key == key){

                return cur;

            } else if (cur.key > key){

                cur = cur.left;

            } else {

                cur = cur.right;

            }

        }
        return null;


    }
    //删除key的值
    public boolean remove(int key) {

        TreeNode cur = root;

        //首先得找到与key匹配的值，
        TreeNode parent = null;
        while (cur != null){

            if (cur.key == key){

                removeNode(cur, parent);
                return true;

            } else if (cur.key > key){
                parent = cur;
                cur = cur.left;

            } else {
                parent = cur;
                cur = cur.right;

            }


        }
        //到这里开始删除。
        return false;
    }

    private void removeNode(TreeNode cur, TreeNode parent) {


        if (cur.left == null){

            if (cur == root){

                root = root.right;

            } else if (parent.left == cur){

                parent.left = cur.right;

            } else {

                parent.right = cur.right;

            }

        } else if (cur.right == null){

            if (cur == root){
                root = root.left;

            } else if (parent.left == cur){

                parent.left = cur.left;

            } else {

                parent.right = cur.left;

            }



        }  else {

            TreeNode targetParent = null;
            TreeNode target = cur.right;

            while (target.left!= null){

                targetParent = target;
                target = target.left;


            }

            cur.key = target.key;

            //此时targe记载的就是右树最小的值。
            if (targetParent.left == target){

                targetParent.left = target.right;


            } else {

                targetParent.right = target.right;

            }
    }

    }
 
   
}