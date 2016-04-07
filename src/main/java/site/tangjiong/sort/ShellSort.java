package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/7.
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] array){

        int length = array.length;
        int gap = Math.floorDiv(length, 2);

        while(gap>0){
            for(int i = gap; i<length; i++){
                for(int j = i; j>0; j-=gap){
                    if(array[j-gap] > array[j]){
                        SortHelper.swap(array, j-gap, j);
                    }else{
                        break;
                    }
                }
            }
            gap = Math.floorDiv(gap, 2);
        }

    }

}
