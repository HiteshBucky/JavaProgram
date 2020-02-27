import java.util.*;
import java.io.File;
class Algorithim
{
	String filename;
  int size = 0 ;
  int  noComp = 0;
  Integer a[];

  /*
  ***************  Constructor ****************
  */
	Algorithim(String str)
	{
		filename = str;
	
		try{
			Scanner sc = new Scanner(new File(this.filename));
			ArrayList<Integer> list = new ArrayList<>();

			while( sc.hasNextInt()){
				list.add(sc.nextInt());
				size++;
			}
			a = new Integer[size];
			a = list.toArray(a);
		}catch(Exception e){}

	}
/*
    ************************ Swap ********************
*/
  private void swap(int ind1, int ind2){
      int tmp = a[ind1];
      a[ind1] = a[ind2];
      a[ind2] = tmp;
  }

  /*
    ******************* Print *******************
  */

  public void printArray(){
    for (Integer x : a) 
          System.out.print(x + " ");  
        System.out.println("\n\nNumber of comarsion/Size Of Array : "+noComp + "/" + size + " \n\n\n\n\n");
  }






  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Bubble Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
	public void bubbleSort()
	{
      noComp = 0;
    	boolean sorted = false;
    	int temp ;
    	while(!sorted)
    	{
     	  sorted = true;
        for (int i = 0; i < size-1; i++)
          if (a[i] > a[i+1])
          {
            swap(i,i+1);
            sorted = false;
            noComp++;
          }  	
   		}
      printArray();
	}















  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Insertion Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
	public void insertionSort()
	{
    noComp = 0;
    for (int i = 1; i < size; i++)
    {
      int current = a[i];
      int j = i - 1;
      while(j >= 0 && current < a[j]) {
        a[j+1] = a[j];
        j--;
        noComp++;
      }
      // at this point we've exited, so j is either -1
      // or it's at the first element where current >= a[j]
      a[j+1] = current;
    }	
    printArray();
	}





















  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Selection Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
	public void selectionSort()
	{
      noComp = 0;
     // One by one move boundary of unsorted subarray
      for (int i = 0; i < size-1; i++)
      {
       // Find the minimum element in unsorted array
        int min_idx = i;
        for (int j = i+1; j < size; j++)
           if (a[j] < a[min_idx]){
            min_idx = j;
            noComp++;
          } 
        // Swap the found minimum element with the first element
        swap(min_idx,i);
      }  
    printArray();
	}






















  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Merge Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
	public  void mergesort() {
    mergesort(a, 0, size-1);
    printArray();
  }

  private void mergesort(Integer[] a, int start, int end)
  {
      // break problem into smaller structurally identical problems
      int mid = (start + end) / 2;
      if (start < end)
      {
        mergesort(a, start, mid);
        mergesort(a, mid + 1, end);
      }

      // merge solved pieces to get solution to original problem
      int i = 0, first = start, last = mid + 1;
      int[] tmp = new int[end - start + 1];

      while (first <= mid && last <= end){
        tmp[i++] = a[first] < a[last] ? a[first++] : a[last++];
        noComp++;
      }
      
      while (first <= mid){
        tmp[i++] = a[first++];
        noComp++;
      }
      
      while (last <= end){
        tmp[i++] = a[last++];
        noComp++;
      }
      
      i = 0;
      while (start <= end){
        noComp++;
        a[start++] = tmp[i++];
      }
  }



































  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Quick Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
  public void quicksort(){
    quicksort(a,0,a.length-1);
    printArray();
  }

  void quicksort(Integer a[], int low, int high) 
  { 
    if (low < high) 
    { 
      /* pi is partitioning index, a[pi] is now at right place */
      int pi = partition(a, low, high); 

      // Recursively sort elements before partition and after partition 
      quicksort(a, low, pi-1); 
      quicksort(a, pi+1, high); 
    } 
  } 

 	int partition(Integer a[], int low, int high) 
  { 
    int pivot = a[high];  
    int i = (low-1); // index of smaller element 
    for (int j=low; j<high; j++) 
    { 
      // If current element is smaller than the pivot 
      if (a[j] < pivot) 
      { 
        i++; 
        noComp++;
        swap(i,j);
      } 
    } 
    // swap a[i+1] and a[high] (or pivot) 
    swap(i+1,high);
    return i+1; 
  }





















  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Heap Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */
  public void heapsort() 
  { 
    int n = a.length; 

    // Build heap (rearrange array) 
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(n, i); 

    // One by one extract an element from heap 
    for (int i=n-1; i>=0; i--) 
    { 
        swap(i,0);  // Move current root to end 
        heapify(i, 0);  // call max heapify on the reduced heap 
    } 
    printArray();
  } 

  public void heapify(int n, int i) 
  { 
    int largest = i; // Initialize largest as root 
    int l = 2*i + 1; // left = 2*i + 1 
    int r = 2*i + 2; // right = 2*i + 2 

    // If left child is larger than root 
    if (l < n && a[l] > a[largest]) {
      largest = l; noComp++;
    }
        
    // If right child is larger than largest so far 
    if (r < n && a[r] > a[largest]){
      largest = r; noComp++;
    } 
        

    // If largest is not root 
    if (largest != i) 
    { 
        swap(i,largest);
        heapify(n, largest);  // Recursively heapify the affected sub-tree 
        noComp++;
    } 
  } 




































  /*
   *********************************************************************************************
   *********************************************************************************************






                                   Radix Sort




   *********************************************************************************************
   *********************************************************************************************                   
  */

  public void radixsort(){
    
    int max = a[0];  
    for (int i = 1; i < a.length; i++) 
      if (a[i] > max) max = a[i];
         
    int m = max;
    for (int exp = 1; m/exp > 0; exp *= 10) 
        radixsort(exp); 

     printArray();
  }


  public void radixsort(int exp)
  {
    int output[] = new int[a.length]; // output array 
    int count[] = new int[10]; 

    // Store count of occurrences in count[] 
    for (int i = 0; i <a.length ; i++) 
        count[ (a[i]/exp)%10 ]++; 

    // Change count[i] so that count[i] now contains 
    // actual position of this digit in output[] 
    for (int i = 1; i < 10; i++) 
        count[i] += count[i - 1]; 

    // Build the output array 
    for (int i = a.length - 1; i >= 0; i--) 
    { 
        output[count[ (a[i]/exp)%10 ] - 1] = a[i]; 
        count[ (a[i]/exp)%10 ]--; 
    } 

    // Copy the output array to a[], so that a[] now 
    // contains sorted numbers according to curent digit 
    for (int i = 0; i < a.length; i++) 
        a[i] = output[i]; 
  }



}




























class Sorting{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    Algorithim algo = new Algorithim("C:\\Users\\HiteshKumar\\Desktop\\Practice\\DU\\Pro\\Algo\\Number.txt");

		System.out.println("\n\n\n\t\t**Welcome to Sorting Algo Program**");
		System.out.println("\t\t\tProgram 1 , 2 , 3");

    int option = 1;
    do{

      System.out.println("1.\tBubble Sort\n2.\tSelection Sort\n3.\tInsertion Sort\n4.\tQuick Sort\n5.\tMerge Sort\n6.\tHeap Sort\n7.\tRadix Sort\n8.\tExit  ");
      System.out.print("Select any one algorithim : ");
      option = sc.nextInt();

      switch(option)
      {
        case 1 : algo.bubbleSort();    break;
        case 2 : algo.selectionSort(); break;
        case 3 : algo.insertionSort(); break;
        case 4 : algo.quicksort();     break;
        case 5 : algo.mergesort();     break;
        case 6 : algo.heapsort();      break;
        case 7 : algo.radixsort();     break;

        default : System.out.println("Enter a valid option!!");
      }
      algo = new Algorithim("C:\\Users\\HiteshKumar\\Desktop\\Practice\\DU\\Pro\\Algo\\Number.txt");
    }while(option != 8);
		
	}
}