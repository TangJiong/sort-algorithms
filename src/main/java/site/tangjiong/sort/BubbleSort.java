package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/2.
 * 冒泡排序的实现
 */
public class BubbleSort {

    public static void sort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    SortHelper.swap(array, j, j+1);
                }
            }
        }
    }

}
