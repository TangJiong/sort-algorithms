import org.junit.Test;
import site.tangjiong.sort.*;

import java.util.Arrays;

/**
 * Created by TangJiong on 2016/3/31.
 * 测试类
 */
public class SortTest {

    // 测试数组
    int[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4, 12, 7, 9, 6};

    @Test
    public void testQuickSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        QuickSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

    @Test
    public void testBubbleSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

    @Test
    public void testSelectSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        SelectSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

    @Test
    public void testInsertSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        InsertSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

    @Test
    public void testMergeSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        MergeSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

    @Test
    public void testHeapSort(){
        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        HeapSort.sort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));
    }

}
