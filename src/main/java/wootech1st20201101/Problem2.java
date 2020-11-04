package wootech1st20201101;

public class Problem2 {
    public boolean solution(int[][] lands, int[][] wells, int[] point) {
        for (int[] land: lands) {
            if (duplicateLand(land, point)) {
                return false;
            }
        }

        for (int[] well : wells) {
            if (containWell(well, point)) {
                return true;
            }
        }

        return false;
    }

    private boolean duplicateLand(int[] land, int[] point) {
        if (land[2] < point[0] || land[0] > point[2]) {
            if (land[3] < point[1] || land[1] > point[3]) {
                return true;
            }
        }
        return false;
    }

    private boolean containWell(int[] well, int[] point) {
        if (well[2] > point[0] && well[0] < point[2]) {
            if (well[3] > point[1] && well[1] < point[3]) {
                return true;
            }
        }
        return false;
    }
}
