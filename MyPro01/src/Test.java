import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {		// TODO Auto-generated method stub
		int[] arr = { 30,20,50,10,80,9,7,12,100,40,8};
	  
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		
		//Arrays.parallelSort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		
		Scanner sc=new Scanner(System.in);
		System.out.print("输入要查找的数字:");
		String s=sc.nextLine();
		
		
		int sz=Integer.parseInt(s);
		System.out.println("result:"+sfind(arr,sz));
	
	}

	     static int sfind(int[] arr, int sz) {
		// TODO Auto-generated method stub
	    	 int high=arr.length-1;
	    	 int low=0;
	    	 while(low<=high)
	    	 {
	    		int mid=(low+high)/2;
	    		if(arr[mid]==sz){
	    			return mid;
	    		}else if(sz<arr[mid]){
	    			high=mid-1;
	    		}else if(sz>arr[mid]){
	    			low=mid+1;
	    		}
	    		 
	    	 }
	    	 
		
	    	 return -1;
	}


	
	
	
	
	
	
	
	
/*		int[] arr = { 30,20,50,10,80,9,7,12,100,40,8};
		int searchWord = 20; // 所要查找的数
		Arrays.sort(arr); //二分法查找之前，一定要对数组元素排序
		System.out.println(Arrays.toString(arr));
		System.out.println(searchWord+"元素的索引："+binarySearch(arr,searchWord));
		
		
		
		int low = 0;
		int high = array.length - 1;

		while(low<=high){
			int mid=(low+high)/2;
			if(value==array[mid])
			{
				return mid;
			}else if(value>array[mid]){
				low=mid+1;
			}else if(value<array[mid]){
				high=mid-1;
			}
		}

		return -1;*/

	


}



	/*		  int[] a= {1,2,323,23,543,12,59};
	        System.out.println(Arrays.toString(a));
	        Arrays.fill(a,2,5,100); //将2到5索引的元素替换为100 2<=x<5;
	        System.out.println(Arrays.toString(a));



	 */


	/*
		int[] a = {1,2,323,23,543,12,59};   //2分查找

		System.out.println("原本顺序："+Arrays.toString(a));
		Arrays.parallelSort(a);    				//使用二分法查找，必须先对数组进行排序;
		System.out.println("排序后顺序："+Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 12));  //返回排序后新的索引位置,若未找到返回负数
	 */

	/*		int []a={1,2,323,23,543,12,59};
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		Arrays.parallelSort(a);
		System.out.println(Arrays.toString(a));*/


	/*	  // 数组拷贝
		String s[]={"aa","bb","cc","dd","ee"};
		String sa[]=new String[8];
		System.arraycopy(s,0,sa,0,s.length);
		for(int i=0;i<sa.length;i++)
		{System.out.println(sa[i]);}*/

