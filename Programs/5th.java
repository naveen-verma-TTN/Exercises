//Find common elements between two arrays.
class myClass{
    public static void main(String args []) {
        int arr1[] = {12, 28, 47, 55, 64, 73, 83};
        int arr2[] = {28, 47, 12, 54, 76, 87, 65, 98};
        myClass obj = new myClass(); 
        obj.sort(arr1, 0, arr1.length - 1);
        obj.sort(arr2, 0, arr2.length - 1); 
        int small_index = (arr1.length < arr2.length) ? arr1.length : arr2.length;
        obj.common(arr1, arr2, small_index);
        System.out.println();
}

void common(int arr1[], int arr2[], int l){
int i = 0, j = 0; 

    while (i < l && j < l) 
    { 
        if (arr1[i] < arr2[j]) 
        { 
            i++; 
        } 
        else if(arr1[i] > arr2[j])
        { 
            j++; 
        } 
        else if(arr1[i] == arr2[j])     
        {
            System.out.print(arr1[i] + " ");
            i++;
            j++;
        }
    } 
}

void merge(int arr[], int l, int m, int r) 
{ 
    int n1 = m - l + 1; 
    int n2 = r - m; 
    int L[] = new int [n1]; 
    int R[] = new int [n2]; 
    for (int i=0; i<n1; ++i) 
        L[i] = arr[l + i]; 
    for (int j=0; j<n2; ++j) 
        R[j] = arr[m + 1+ j]; 

    int i = 0, j = 0; 

    int k = l; 
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i]; 
            i++; 
        } 
        else
        { 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 

    while (i < n1) 
    { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 

    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 


void sort(int arr[], int l, int r) 
{ 
    if (l < r) 
    { 
        int m = (l+r)/2; 
        sort(arr, l, m); 
        sort(arr , m+1, r); 
        merge(arr, l, m, r); 
    } 
} 

} 