
class ComputeArea223Mid{
    // 给的都是左下和右上的点不是矩形任意两个点
    // 可能不重合,重合的话计算重合矩形的高度差和宽度差
    // w = min(aMaxY,bMaxY) - max(aMinY, bMinY);
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        int h = Math.min(ay2, by2) - Math.max(ay1, by1);
        int w = Math.min(bx2, ax2) - Math.max(ax1, bx1);
        return h < 0 || w < 0 ? area : area - h * w;
    }
}
