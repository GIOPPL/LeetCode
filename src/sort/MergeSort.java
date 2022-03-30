package sort;

public class MergeSort {
//    public static void main(String[] args) {
//        int[] arr = {11,44,23,67,88,65,34,48,9,12};
//        MergeSort mergeSort=new MergeSort();
//        mergeSort.sort(arr,0,arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"\t");
//        }
//    }
//
//    private void sort(int[] arr,int l,int r){
//        if(l<r){
//            int mid=(l+r)/2;
//            sort(arr,l,mid);
//            sort(arr,mid+1,r);
//            merger(arr,l,r);
//        }
//    }
//
//    private void merger(int[] arr, int l, int r) {
//        int[] tem=new int[r-l+1];
//        int mid=(l+r)/2;
//        int i=l,j=mid+1,k=0;
//        while (i<=mid&&j<=r){
//            if (arr[i]<arr[j]){
//                tem[k++]=arr[i++];
//            }else{
//                tem[k++]=arr[j++];
//            }
//        }
//
//        while (i<=mid){
//            tem[k++]=arr[i++];
//        }
//        while (j<=r){
//            tem[k++]=arr[j++];
//        }
//        for (int t = 0; t < k; t++) {
//            arr[l+t]=tem[t];
//        }
//    }

}
