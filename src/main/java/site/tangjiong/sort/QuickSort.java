package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/3/31.
 * 快速排序的实现
 */
public class QuickSort {

    // 选取基准元素，将数组划分为两部分，左小右大
    private static int partition(int[] array, int left, int right){
        int pivot = array[right]; // 选取最右边的元素作为基准
        int dividerIndex = left;
        for(int i = left; i<right; i++){
            if(array[i] < pivot){
                SortHelper.swap(array, dividerIndex, i); // 把比基准数(pivot)小的换到分隔符(dividerIndex)的前面
                dividerIndex++;
            }
        }
        SortHelper.swap(array, dividerIndex, right); // 交换分隔符和基准数
        return dividerIndex;
    }

    // 递归排序
    private static void quickSort(int[] array, int left, int right){
        if(left > right) return;
        int divider = partition(array, left, right);
        quickSort(array, left, divider-1);
        quickSort(array, divider+1, right);
    }

    /**
     * 注意，直接修改的是原数组
     * @param array 带排序数组
     */
    public static void sort(int[] array){
        quickSort(array, 0, array.length-1);
    }

}
