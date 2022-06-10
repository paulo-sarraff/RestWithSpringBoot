package br.com.sarraff;

import java.util.Random;

public class MergeSort  {
	public static void ordenaArrayInteiros(int[] nums) {

		MergeSort  ob = new MergeSort ();
        ob.sort(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {

		int[] arr = new int[10000];
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			int valor = r.nextInt(10000)+1;
			arr[i] = valor;
		}
		
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
			System.out.println();
		ordenaArrayInteiros(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	void mergeArrays(int arr[], int l, int m, int r){
        // tamanho dos dois arrays
        int n1 = m - l + 1;
        int n2 = r - m;
  
        //criando arrays temporarios
        int left[] = new int[n1];
        int right[] = new int[n2];
  
        //Copiando dados para arrays temporarios
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];
  
        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
	
    void sort(int arr[], int left, int right) {
        if (left < right) {
            int meio =left+ (right-left)/2;
            sort(arr, left, meio);
            sort(arr, meio + 1, right);
            mergeArrays(arr, left, meio, right);
        }
    }
}