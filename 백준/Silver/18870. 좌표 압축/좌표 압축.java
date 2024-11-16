import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> save = new ArrayList<>();
        for (int i =0;i<N;i++) {
        	int value = Integer.parseInt(st.nextToken());
        	arr[i] = value;
        	save.add(value);
        }
        Arrays.sort(arr);
        int[] newArr = Arrays.stream(arr).distinct().toArray();
       
        for (int find : save) {
        	sb.append(lowerBound(newArr, find)).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static int lowerBound(int[] arr,int find) {
    	int lt = 0; int rt = arr.length;
    	while (lt < rt) {
    		int mid = (lt+rt) / 2;
    		if (arr[mid] >= find) rt = mid;
    		else lt = mid + 1;    		
    	}
 
    	return lt;
    }
    
}
