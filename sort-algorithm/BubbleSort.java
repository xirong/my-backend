/**
 * description:
 * author: xirong
 * date: 2015-07-16
 * version: 1.0
 * copyright 2015  ,all rights reserved.
 */
public class BubbleSort {

    // 原始冒泡排序
    // 外循环为总共遍历的次数，内循环从最后开始，若小于前者，则往前移动顺序即可
    public static void OriginalBubbleSort(int[] array){
        for(int i=1;i<=array.length;i++){
            for(int j=array.length-1;j>=i;j--){
                if(array[j-1]>array[j]){
                    Swap(array,j-1,j);
                }
            }
        }
    }

    // 改善效率的冒泡
    // 比如{2,1,3,4,5,6,7,8,9} 第一次循环即可将数组排好顺序，剩下的8次循环是可以不用进行的
    public static void ImprovedBubbleSort(int[] array){
        boolean loop=true;
        for(int i=1;i<=array.length && loop;i++){
            loop =false;
            for(int j=array.length-1;j>=i;j--){
                if(array[j-1] > array[j]){
                    Swap(array,j-1,j);
                    loop =true;
                }
            }
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
        //OriginalBubbleSort(arr);
        ImprovedBubbleSort(arr);
        System.out.println("after sort:");
        PrintArray(arr);
    }

}
