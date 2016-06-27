public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        addOperators(num, 0, target, 0, 0, "", result);
        return result;
    }
    
    private void addOperators(String num, int start, int target, long sum, 
        long preNum, String curResult, List<String> result) {
        if (start == num.length()) {
            if (sum == target) result.add(curResult);
            return;
        }
        
        for (int i = start; i < num.length(); i++) {
            String curStr = num.substring(start, i + 1);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                break;
            }
            long curNum = Long.parseLong(curStr);
            if (curResult.isEmpty()) {
                addOperators(num, i + 1, target, curNum, curNum, curStr, result);
            } else {
                addOperators(num, i + 1, target, sum + curNum, curNum, curResult + "+" + curNum, result);
                addOperators(num, i + 1, target, sum - curNum, -curNum, curResult + "-" + curNum, result);
                addOperators(num, i + 1, target, preNum * curNum + sum - preNum, preNum * curNum, curResult + "*" + curNum, result);
            }
        }
    }
}