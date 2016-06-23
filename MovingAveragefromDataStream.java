public class MovingAverage {
    
    Queue<Integer> window = new LinkedList<>();
    int size;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        window.offer(val);
        sum += val;
        if (window.size() > size) {
            sum -= window.poll();
        }
        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */