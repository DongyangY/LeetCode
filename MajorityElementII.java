public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer m1 = null, m2 = null;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (m1 != null && i == m1) {
                c1++;
            } else if (m2 != null && i == m2) {
                c2++;
            } else if (c1 == 0) {
                c1++;
                m1 = i;
            } else if (c2 == 0) {
                c2++;
                m2 = i;
            } else {
                if (--c1 == 0) m1 = null;
                if (--c2 == 0) m2 = null;
            }
            //System.out.println(c1 + " " + c2);
        }
        
        //System.out.println(m1 + " " + m2);
        
        c1 = 0; c2 = 0;
        for (int i : nums) {
            if (m1 != null && i == m1) c1++;
            if (m2 != null && i == m2) c2++;
        }
        
        List<Integer> l = new ArrayList<>();
        if (c1 > nums.length / 3) l.add(m1);
        if (c2 > nums.length / 3) l.add(m2);
        return l;
    }
}