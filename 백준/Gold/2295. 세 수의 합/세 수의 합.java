import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr); // 정렬 필수
        
        ArrayList<Integer> two = new ArrayList<>();
        
        // 두 수의 합으로 `two` 배열 생성
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) { // 중복 허용
                two.add(arr[i] + arr[j]);
            }
        }
        
        // 두 수의 합 배열 정렬
        int[] two_arr = two.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(two_arr);

        // 가장 큰 k 찾기
        for (int k = N - 1; k >= 0; k--) {
            for (int l = 0; l < k; l++) {
                int target = arr[k] - arr[l];
                if (binarySearch(two_arr, target)) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(int[] arr, int find) {
        int lt = 0, rt = arr.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == find) {
                return true;
            } else if (arr[mid] > find) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return false;
    }
}
