import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i< N;i++) {
        	int value = Integer.parseInt(st.nextToken());
        	arr[i] = value;
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        ArrayList<Integer> find = new ArrayList<>();
        for (int i = 0; i < M; i++) {
        	int value = Integer.parseInt(st.nextToken());
        	find.add(value);
        }
        for (int next : find) {
        	int lt = 0;
        	int rt = arr.length - 1;
        	boolean flag = false;
        	while (lt <= rt) {
        		int mid = (lt+rt+1)/ 2;
        		if (arr[mid] == next) {
        			sb.append(1).append("\n");
        			flag = true;
        			break;
        		}
        		if (arr[mid] < next) {
        			lt = mid+1;
        		}
        		else if (arr[mid] > next) {
        			rt = mid -1;
        		}
        		
        	}
        	if (!flag) sb.append(0).append("\n");
        }
        
        
        System.out.println(sb);
    }
}
