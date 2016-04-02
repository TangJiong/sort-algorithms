# 常见排序算法的Java实现
看过很多次各种排序算法了，自己手动用Java实现一遍，加强理解

## 冒泡排序

### 简介
冒泡排序（Bubble Sort，台湾译为：泡沫排序或气泡排序）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

### 步骤
1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
3. 针对所有的元素重复以上的步骤，除了最后一个。
4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

### 参考代码
```java
/**
 * Created by TangJiong on 2016/4/2.
 * 冒泡排序的实现
 */
public class BubbleSort {

    public static void sort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    SortHelper.swap(array, j, j+1);
                }
            }
        }
    }

}
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/QuickSort.java)

### 说明
调用 ```BubbleSort.sort(int[] array)``` 对数组进行排序

## 快速排序

### 简介
快速排序是由东尼·霍尔所发展的一种排序算法，因此也被称作霍尔排序。在平均状况下，排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。

### 步骤
1. 从数列中挑出一个元素，称为 “基准”（pivot）
2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

### 参考代码
```java
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
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/QuickSort.java)

### 说明
调用 ```QuickSort.sort(int[] array)``` 对数组进行排序