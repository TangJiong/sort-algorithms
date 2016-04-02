# 常见排序算法的Java实现
看过很多次各种排序算法了，自己手动用Java实现一遍，加强理解

## 快速排序

### 简介
快速排序是由东尼·霍尔所发展的一种排序算法，因此也被称作霍尔排序。在平均状况下，排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。

### 步骤
1. 从数列中挑出一个元素，称为 “基准”（pivot）
2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

### 参考代码
```java
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
```


### 说明
调用 ```QuickSort.sort(int[] array)``` 对数组进行排序