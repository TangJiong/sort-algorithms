package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/3/31.
 * 快速排序的实现
 */
public class QuickSort {

    /**
     * 交换数组中的两个元素
     * @param array 数组
     * @param i 前一个元素下标
     * @param j 后一个元素下标
     */
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 选取基准元素，将数组划分为两部分，左小右大
    private static int partition(int[] array, int left, int right){
        int pivot = array[right]; // 选取最右边的元素作为基准
        int dividerIndex = left;
        for(int i = left; i<right; i++){
            if(array[i] < pivot){
                swap(array, dividerIndex, i); // 把比基准数(pivot)小的换到分隔符(dividerIndex)的前面
                dividerIndex++;
            }
        }
        swap(array, dividerIndex, right); // 交换分隔符和基准数
        return dividerIndex;
    }

    // 递归排序
    private static void sort(int[] array, int left, int right){
        if(left > right) return;
        int divider = partition(array, left, right);
        sort(array, left, divider-1);
        sort(array, divider+1, right);
    }

    public static void quickSort(int[] array){
        sort(array, 0, array.length-1);
    }

}
