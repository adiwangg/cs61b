package disc3;

public class Arrays {
     public static int[] insert(int[] arr, int item, int position){
         int[] a = new int[arr.length+1];
         if(position>arr.length-1){
             position = arr.length;
         }
         System.arraycopy(arr,0,a,0,position);
         a[position] = item;
         System.arraycopy(arr,position,a,position+1,arr.length-position);
         return a;
     }

     public static void reverse(int[] arr){
         for(int i = 0; i < arr.length/2; i++){
             int j = arr.length - i - 1;
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }
     }

     public static int[] replicate(int[] arr){
         int totalNum = 0;
         for (int i = 0; i < arr.length; i++) {
             totalNum += arr[i];
         }
         int[] newArr = new int[totalNum];
         int num = 0;
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[i]; j++) {
                 newArr[j + num] = arr[i];
             }
             num += arr[i];
         }
         return newArr;
     }

    public static void main(String[] args) {
         int[] arr = new int[]{1,2,3,4};
         //arr = Arrays.insert(arr,666,22);
         arr = Arrays.replicate(arr);
         System.out.println(arr[0]);
         System.out.println(arr[1]);
         System.out.println(arr[2]);
         System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr[5]);
        System.out.println(arr[6]);
    }
}
