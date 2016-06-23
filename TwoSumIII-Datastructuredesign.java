public class TwoSum {
    
    // Store the numbers and their frequency
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int key = entry.getKey();
	        int target = value - key;
	        if (target == key) {
	            if (map.get(key) >= 2) return true;
	        } else {
	            if (map.containsKey(target)) return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);