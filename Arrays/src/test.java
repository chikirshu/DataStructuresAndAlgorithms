
public class test {

	public static void main(String[] args) {
		// System.out.println(solution(966));
		// System.out.println(solutionII(new int[] {1,1,0,1,1}));
		// System.out.println(solutionIII(new int[] {1,1,0,1,1}));
		// System.out.println(solutionII(new int[] {1,1,1,1,1}));
		System.out.println(solutionIV(new int[] {0,1,1,1,0}));

	}
	private static int solutionIII(int[] arr) {
		int ans=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				ans++;
				arr[i]=arr[i-1]==0?1:0;
			}
		}
		return ans;
	}
	public static int solution(int N) {
        // write your code in Java SE 8
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        String s = String.valueOf(N);
        String res=s;
        for(int i=0;i<s.length();i++){
        	s=res;
            if(s.charAt(0)=='-'){
                if(i==0) continue;
                s=s.substring(1,i)+"5"+s.substring(i);
                //min
                min = Math.min(min,Integer.parseInt(s));
            }
            else{
                s=s.substring(0,i)+"5"+s.substring(i);
                //max
                max = Math.max(max,Integer.parseInt(s));
            }
            
        }
        s=res;
        return s.charAt(0)=='-'?min:max;
    }
	public static int solutionII(int[] A) {
        // write your code in Java SE 8
        int[] a = new int[2];
        int maxInA=Integer.MIN_VALUE, res=0;
        for(int i=0;i<A.length;i++){
            maxInA = Math.max(maxInA, ++a[A[i]]);
            if(maxInA>(i/2)+1) {
                if(i%2==0) res=Math.max(res, maxInA-(i/2));
                else res=Math.max(res, maxInA-(i/2)-1);   
            }
        }
        return res;
    }
	
	// Qs. Minimum number of bits you'll flip to make an alternate sequence
	//written on 12/06/2022
	public static int solutionIV(int[] arr) {
		int res=0;
		//if arr is empty or has 1 value
		if(arr.length==0 || arr.length==1) return res;
		
		//else
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i]==arr[i-1]) {
				if(arr[i]==arr[i+1]) {
					arr[i]=arr[i]==0?1:0;
				}
				res++;
			}
		}
		return arr[arr.length-1]==arr[arr.length-2]?++res:res;
	}

}
