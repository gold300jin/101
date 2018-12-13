package issue;

public class search_a_2d_matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        int[] leftCol = new int[row];
        for (int r = 0; r < row; r++) {
            if (matrix[r].length != col) return false;
            leftCol[r] = matrix[r][0];
        }
        int leftSearch = binaryInsert(leftCol, target);
        if (leftCol[leftSearch] == target) return true;
        boolean result = false;
        for (int r = 0; r <= leftSearch; r++) {
            result = result || binarySearch(matrix[r], target);
        }
        return result;
    }

    private int binaryInsert(int[] eles, int data) {
        int len = eles.length;
        if (len == 0) return 0;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (data > eles[mid]) l = mid + 1;
            else if (data < eles[mid]) r = mid - 1;
            else return mid;
        }
        return l;
    }

    private boolean binarySearch(int [] eles, int data) {
        int result = binaryInsert(eles, data);
        if (result < 0) return false;
        return eles[result] == data;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1},
                {3}
        };
        int target = 0;
        search_a_2d_matrix solution = new search_a_2d_matrix();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println(result);
    }


}
