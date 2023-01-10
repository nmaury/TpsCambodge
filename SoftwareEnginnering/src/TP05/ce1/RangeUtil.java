package TP05.ce1;

public class RangeUtil {
    private int start;
    private int end;
    private int step;

    public RangeUtil(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if(start<=end) {
            for (int i = this.start; i <= this.end; i += this.step) {
                res.append(i).append(", ");
            }
            return res.delete(res.length() - 2, res.length() - 1).toString();
        }else{
            for (int i = this.start; i >= this.end; i -= this.step) {
                res.append(i).append(", ");
            }
            return res.delete(res.length() - 2, res.length() - 1).toString();
        }
    }

    public static void main(String[] args) {
        RangeUtil rangeUtil =new RangeUtil(10,5,1);
        System.out.println(rangeUtil);
    }
}
