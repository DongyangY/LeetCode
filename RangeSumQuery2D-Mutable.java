public class NumMatrix {
    
    class TreeNode {
        int sum;
        int row1, col1, row2, col2;
        TreeNode leftUp, leftDown, rightUp, rightDown;
        public TreeNode(int sum, int row1, int col1, int row2, int col2) {
            this.sum = sum;
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
        }
        public TreeNode(int row1, int col1, int row2, int col2) {
            this.sum = 0;
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
        }
    }
    
    TreeNode root;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        root = build(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    public TreeNode build(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) return null;
        //System.out.println(row1 + "," + col1 + "," + row2 + "," + col2);
        if (row1 == row2 && col1 == col2) {
            return new TreeNode(matrix[row1][col1], row1, col1, row2, col2);
        }
        int rowMid = row1 + (row2 - row1) / 2;
        int colMid = col1 + (col2 - col1) / 2;
        TreeNode current = new TreeNode(row1, col1, row2, col2);
        current.leftUp = build(matrix, row1, col1, rowMid, colMid);
        current.leftDown = build(matrix, rowMid + 1, col1, row2, colMid);
        current.rightUp = build(matrix, row1, colMid + 1, rowMid, col2);
        current.rightDown = build(matrix, rowMid + 1, colMid + 1, row2, col2);
        if (current.leftUp != null) current.sum += current.leftUp.sum;
        if (current.leftDown != null) current.sum += current.leftDown.sum;
        if (current.rightUp != null) current.sum += current.rightUp.sum;
        if (current.rightDown != null) current.sum += current.rightDown.sum;
        return current;
    }

    public void update(int row, int col, int val) {
        if (root == null) return;
        update(root, row, col, val);
    }
    
    public void update(TreeNode root, int row, int col, int val) {
        if (row == root.row1 && row == root.row2 && col == root.col1 && col == root.col2) {
            root.sum = val;
            return;
        }
        int rowMid = root.row1 + (root.row2 - root.row1) / 2;
        int colMid = root.col1 + (root.col2 - root.col1) / 2;
        //System.out.println(row + "," + col + ":" + root.row1 + "," + root.col1 + "," + root.row2 + "," + root.col2 + ":" + rowMid + "," + colMid);
        if (row <= rowMid) {
            if (col <= colMid) {
                update(root.leftUp, row, col, val);
            } else {
                update(root.rightUp, row, col, val);
            }
        } else {
            if (col <= colMid) {
                update(root.leftDown, row, col, val);
            } else {
                update(root.rightDown, row, col, val);
            }
        }
        root.sum = 0;
        if (root.leftUp != null) root.sum += root.leftUp.sum;
        if (root.leftDown != null) root.sum += root.leftDown.sum;
        if (root.rightUp != null) root.sum += root.rightUp.sum;
        if (root.rightDown != null) root.sum += root.rightDown.sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (root == null) return 0;
        return sumRegion(root, row1, col1, row2, col2);
    }
    
    public int sumRegion(TreeNode root, int row1, int col1, int row2, int col2) {
        if (root == null || row1 > root.row2 || col1 > root.col2 || row2 < root.row1 || col2 < root.col1) {
            return 0;
        }
        if (root.row1 >= row1 && root.col1 >= col1 && root.row2 <= row2 && root.col2 <= col2) {
            return root.sum;
        }
        int rowMid = row1 + (row2 - row1) / 2;
        int colMid = col1 + (col2 - col1) / 2;
        return sumRegion(root.leftUp, row1, col1, row2, col2) + sumRegion(root.leftDown, row1, col1, row2, col2) +
        sumRegion(root.rightUp, row1, col1, row2, col2) + sumRegion(root.rightDown, row1, col1, row2, col2);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);