public class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] traces = path.split("/");
        for (String t : traces) {
            //System.out.println("t: " + t);
            if (t.equals("..")) {
                if (!s.isEmpty())
                    //System.out.println("pop: " + s.pop());
                    s.pop();
                continue;
            }
            if (t.equals(".")) continue;
            if (t.equals("")) continue;
            //System.out.println("push: " + t);
            s.push(t);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, "/");
        }
        
        if (sb.length() == 0) sb.append("/");
        
        return sb.toString();
    }
}