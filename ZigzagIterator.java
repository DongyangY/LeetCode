public class ZigzagIterator {
    List<Iterator<Integer>> iters;
    int cur;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iters = new LinkedList<>();
        Iterator<Integer> iter1 = v1.iterator();
        if (iter1.hasNext()) iters.add(iter1);
        Iterator<Integer> iter2 = v2.iterator();
        if (iter2.hasNext()) iters.add(iter2);
    }

    public int next() {
        cur = cur % iters.size();
        int next = iters.get(cur).next();
        if (!iters.get(cur).hasNext()) {
            iters.remove(cur);
        } else {
            cur++;
        }
        return next;
    }

    public boolean hasNext() {
        return iters.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */