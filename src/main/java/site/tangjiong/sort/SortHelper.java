package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/2.
 * 工具类
 */
public class SortHelper {

    /**
     * 交换数组中的两个元素
     * @param array 数组
     * @param i 前一个元素下标
     * @param j 后一个元素下标
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
