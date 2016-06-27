/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        Map<Double, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                double slope = 0;
                if (points[j].y != points[i].y) {
                    slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                }
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }
            
            for (Integer count : map.values()) {
                int num = count + duplicate;
                max = Math.max(max, num);
            }
            
            max = Math.max(vertical + duplicate, max);
            
            map.clear();
        }
        
        return max;
    }
}