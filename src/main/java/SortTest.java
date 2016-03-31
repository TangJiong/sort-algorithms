import org.junit.Test;
import site.tangjiong.sort.QuickSort;

import java.util.Arrays;

/**
 * Created by TangJiong on 2016/3/31.
 * 测试类
 */
public class SortTest {

    // 测试数组
    int[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4, 12, 7, 9, 100};

    @Test
    public void testQuickSort(){

        System.out.println("排序前数组====>\n"+Arrays.toString(array));
        QuickSort.quickSort(array);
        System.out.println("排序后数组====>\n"+Arrays.toString(array));

    }


}
