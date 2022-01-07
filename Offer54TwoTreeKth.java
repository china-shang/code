import java.util.concurrent.atomic.AtomicInteger;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
     }
 }
class Offer54TwoTreeKth {
    private static int th;
    // 按深度从右往左遍历,遍历到一个k--;k==0 return
    // 一个节点的值=dfs(left), dfs(right), root之一
    // 找到后直接return,不再继续遍历
    // 设path为路径,那么path任何节点上的右边节点相连的节点都被遍历了
    // 依据path压栈
    // /\
    ///  \
    //   /\
   //   /\/\
    public static int kthLargest1(TreeNode root, int  k){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        th = k;
        return dfs(root);
    }
    private static int dfs(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int res = dfs(root.right);
        if(res != Integer.MIN_VALUE){
            return res;
        }
        if(--th == 0){
            return root.val;
        }
        return dfs(root.left);
    }


    public static int kthLargest(TreeNode root, int k) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        AtomicInteger th = new AtomicInteger(0);
        return kthLargest(root, k, th);

    }
    public static int kthLargest(TreeNode root, int k, AtomicInteger th){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int res = kthLargest(root.right, k, th);
        if(res != Integer.MIN_VALUE){
            return res;
        }
        if(th.incrementAndGet() == k){
            return root.val;
        }
        return kthLargest(root.left, k, th);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                    new TreeNode(2),
                    new TreeNode(4)
                    ),
                new TreeNode(8,
                    new TreeNode(6),
                    new TreeNode(12,
                        new TreeNode(9),
                        new TreeNode(14,
                            new TreeNode(13),
                            new TreeNode(15)
                            )
                        )

                    )
                );
        // 15
        System.out.println(kthLargest(root, 1));
        // 14
        System.out.println(kthLargest(root, 2));
        // 9
        System.out.println(kthLargest(root, 5));


        // 15
        System.out.println(kthLargest1(root, 1));
        // 14
        System.out.println(kthLargest1(root, 2));
        // 9
        System.out.println(kthLargest1(root, 5));

    }
}
