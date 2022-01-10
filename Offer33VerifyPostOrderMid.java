class Offer33VerifyPostOrderMid {
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder == null){
            return false;
        }
        if(postorder.length < 2){
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);

    }

    //
    // 后序遍历,前一部分小于n[r],后一部分大于n[r],然后前后部分也满足该条件
    // 从左往右比较,如果 n[i] < n[r] then i++;得到前半部分全是小于的节点
    // 然后保存mid=i;然后n[i] > n[r],i++,如果后半部分全部大于,那么i==r
    public static boolean verifyPostorder(int[] postorder, int l, int r) {
        if(l >= r){
            return true;
        }
        int i = l;
        while(postorder[i] < postorder[r]){
            i++;
        }
        int mid = i;
        while(postorder[i] > postorder[r]){
            i++;
        }

        return i == r && verifyPostorder(postorder, l, mid-1) && verifyPostorder(postorder, mid, r - 1);
    }

    public static void main(String[] args) {
        // false
        System.out.println(verifyPostorder(new int[]{1,6,3,2,5}));

        // true
        System.out.println(verifyPostorder(new int[]{1,3,2,6,5}));

    }
}
