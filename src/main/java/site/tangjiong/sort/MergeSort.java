package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/7.
 * 归并排序，最简单的两路归并排序
 */
public class MergeSort {

    private static void mergeSort(int[] array, int first, int last){
        if(last - first < 1){
            return;
        }
        int middle = Math.floorDiv(first+last, 2);
        mergeSort(array, first, middle);
        mergeSort(array, middle+1, last);

        int f = first, m = middle, i, temp;

        while(f <= m && m+1 <= last){
            if(array[f] >= array[m+1]){
                temp = array[m+1];
                for(i=m; i>=f; i--){
                    array[i+1] = array[i];
                }
                array[f] = temp;
                m++;
            }else {
                f++;
            }
        }

    }

    public static void sort(int[] array){
        mergeSort(array, 0, array.length-1);
    }

}
