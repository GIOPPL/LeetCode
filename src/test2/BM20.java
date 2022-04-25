package test2;

public class BM20 {
    public static void main(String[] args) {
        BM20 b=new BM20();
//        int[] a=new int[]{7,3,2,6,0,1,5,4};
        int[] a=new int[]{7,3,2,6};
        System.out.println(b.InversePairs(a));
    }

    public int InversePairs(int [] a) {
        return fun(a,0,a.length-1);
    }

    int count=0;
    private int fun(int[] arr,int l,int r){
        if (l<r){
            int mid=(l+r)/2;
            fun(arr, l, mid);
            fun(arr,mid+1,r);
            merge(arr,l,r);
        }
        return count;
    }

    private void merge(int[] arr, int l, int r) {
        int mid=(l+r)/2;
        int[] tem=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        while (i<=mid&&j<=r){
            if (arr[i]<arr[j]){
                tem[k++]=arr[i++];
            }else {
                count+=mid+1-i;
                tem[k++]=arr[j++];
            }
        }
        while (i<=mid){
            tem[k++]=arr[i++];
        }
        while (j<=r){
            tem[k++]=arr[j++];
        }
        for (int t = 0; t < k; t++) {
            arr[l+t]=tem[t];
        }
    }
}
