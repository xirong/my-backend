/**
 * description:
 * author: xirong
 * date: 2015-07-19
 * version: 1.0
 * copyright 2015 ,all rights reserved.
 */
public class SelectionSort {

    /**
     * 简单选择排序
     * 通过n-i次关键字之间的比较，从n-i+1个记录中选出关键字最小的记录
     * @param array
     */
    public static void SimpleSelectionSort(int[] array){
        int minIndex;
        for(int i=0;i<array.length;i++){
            minIndex=i;
            // 寻找与i相比最小数的下标
            for(int j=i+1;j<array.length;j++){
                if(array[minIndex] > array[j]){
                    minIndex =j;
                }
            }
            // 如果存在比 arr[minIndex] 小的记录，则进行交换
            if(minIndex !=i){
                Swap(array,minIndex,i);
            }
        }
    }

    /**
     * 直接插入排序
     * 在待排序的列表中
     * @param array
     */
    public static void InsertionSort(int[] array){
        int temp,j;
        for(int i=1;i<array.length;i++){
            temp=array[i];
            j=i-1;
            // 有序列表记录后移，并找到要插入的位置j处
            while (j>= 0 && temp < array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }

    // 交换数组位置
    public static void Swap(int[] array,int start,int end){
        int temp=array[start];
        array[start] = array[end];
        array[end] =temp;
    }

    public static void PrintArray(int[] array){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            sb.append(array[i]).append(",");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] arr=new int[]{8,6,1,4,7,3,9,2,0};
        System.out.println("before sort:");
        PrintArray(arr);
        //SimpleSelectionSort(arr);
        InsertionSort(arr);
        System.out.println("after sort:");
        PrintArray(arr);
    }

}
