package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/3.
 * 插入排序的实现
 */
public class InsertSort {

    public static void sort(int[] array){
        if(array.length<=1) return; //只有一个元素直接返回
        for(int i=1; i<array.length; i++){
            for(int j=i; j>0; j--){
                // j-1之前的序列是排好序的，内循环做的是把j放到j-1序列的合适位置
                if(array[j-1] > array[j]){
                    SortHelper.swap(array, j-1, j);
                }else {
                    break;
                }
            }
        }
    }

}
