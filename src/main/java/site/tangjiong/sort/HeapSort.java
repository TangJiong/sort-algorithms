package site.tangjiong.sort;

/**
 * Created by TangJiong on 2016/4/7.
 * 堆排序
 */
public class HeapSort {

    /**
     * 从index开始检查并保持最大堆的性质
     * @param array 数组
     * @param index 检查的起始下标
     * @param heapSize 堆大小
     */
    private static void maxHeapify(int[] array, int index, int heapSize){
        int iMax = index;
        int iLeft = 2 * index +1;
        int iRight = 2 * (index + 1);

        if(iLeft < heapSize && array[index] < array[iLeft]){
            iMax = iLeft;
        }

        if(iRight < heapSize && array[iMax] < array[iRight]){
            iMax = iRight;
        }

        if(iMax != index){
            SortHelper.swap(array, iMax, index);
            maxHeapify(array, iMax, heapSize);
        }
    }

    /**
     * 构建最大堆
     * @param array 数组
     * @param heapSize 堆大小
     */
    private static void buildMaxHeap(int[] array, int heapSize){
        int iParent = Math.floorDiv(heapSize-1, 2);

        for(int i=iParent; i>=0; i--){
            maxHeapify(array, i, heapSize);
        }
    }


    public static void sort(int[] array){
        int heapSize = array.length;
        buildMaxHeap(array, heapSize);

        for(int i = heapSize -1; i>0; i--){
            SortHelper.swap(array, 0, i);
            maxHeapify(array, 0, i);
        }
    }

}
