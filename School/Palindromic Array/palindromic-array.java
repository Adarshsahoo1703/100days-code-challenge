//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n){
        int flag = 1;
        
        for (int g = 0; g < n; g++) {
            int rev = 0;
            int x = a[g];
            
            while (x > 0) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            
            if (rev != a[g]) {
                flag = 0;
            }
        }
        
        return flag == 0 ? 0 : 1;
           }
}