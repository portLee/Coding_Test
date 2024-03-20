package algorithm.binary_search;

/* 이분 탐색 */
public class BinarySearch {

    static int[] arr;
    static int ans;

    public static void main(String[] args) {
        arr = new int[]{5, 7, 9, 15, 20, 38, 52, 58, 77};

        binarySearch(58);

        System.out.println("count : " + ans);
    }

    private static void binarySearch(int goal) {
        int low = 0;
        int high = arr.length - 1;

        while (high >= low) {

            int mid = (low + high) / 2;
            ans++;

            if (goal == arr[mid]) {
                System.out.println("Find!!");
                break;
            } else if (goal < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}
