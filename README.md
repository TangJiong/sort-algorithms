# 常见排序算法的Java实现
看过很多次各种排序算法了，自己手动用Java实现一遍，加强理解

## 冒泡排序

### 简介
冒泡排序（Bubble Sort，台湾译为：泡沫排序或气泡排序）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

* 最差时间复杂度 O(n^2)
* 最优时间复杂度 O(n)
* 平均时间复杂度 O(n^2)

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
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/BubbleSort.java)

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

## 选择排序

### 简介
选择排序（Selection Sort）是一种简单直观的排序算法。它的工作原理如下，首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

### 步骤
见简介

### 参考代码
```java
/**
 * Created by TangJiong on 2016/4/2.
 * 选择排序
 */
public class SelectSort {

    public static void sort(int[] array){

        int temp;
        int minIndex;
        int minValue;

        for(int i=0; i<array.length-1; i++){
            minIndex = i;
            minValue = array[minIndex];

            // 找最小值
            for(int j=i; j<array.length; j++){
                if(array[j] < minValue){
                    minIndex = j;
                    minValue = array[minIndex];
                }
            }

            // 把最小值交换到序列开头
            temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;

        }

    }

}
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/SelectSort.java)

### 说明
调用 ```SelectSort.sort(int[] array)``` 对数组进行排序

## 插入排序

### 简介
设有一组关键字｛K1， K2，…， Kn｝；排序开始就认为 K1 是一个有序序列；让 K2 插入上述表长为 1 的有序序列，使之成为一个表长为 2 的有序序列；然后让 K3 插入上述表长为 2 的有序序列，使之成为一个表长为 3 的有序序列；依次类推，最后让 Kn 插入上述表长为 n-1 的有序序列，得一个表长为 n 的有序序列。

### 步骤
1. 从第一个元素开始，该元素可以认为已经被排序
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
4. 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置后
6. 重复步骤 2~5

### 参考代码
```java
/**
 * Created by TangJiong on 2016/4/3.
 * 插入排序的实现
 */
public class InsertSort {

    public static void sort(int[] array){
        if(array.length<=1) return; //只有一个元素直接返回
        for(int i=1; i<array.length; i++){
            for(int j=i; j>0; j--){
                // j-1之前的序列是排好序的，内循环做的是把j放到j-1序列的合适位置
                if(array[j-1] > array[j]){
                    SortHelper.swap(array, j-1, j);
                }else {
                    break;
                }
            }
        }
    }

}
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/InsertSort.java)

### 说明
调用 ```InsertSort.sort(int[] array)``` 对数组进行排序

## 归并排序

### 简介
归并排序（Merge Sort，台湾译作：合并排序）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
归并操作(Merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。归并排序有多路归并排序、两路归并排序 , 可用于内排序，也可以用于外排序。这里仅对内排序的两路归并方法进行讨论。

### 步骤
1. 把 n 个记录看成 n 个长度为 l 的有序子表
2. 进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表
3. 重复第 2 步直到所有记录归并成一个长度为 n 的有序表为止。

如数组 array =  [5, 2, 4, 6, 1, 3, 2, 6]，归并排序流程如下所示：
![merge-sort-example](/img/merge-sort-example.gif)

### 参考代码
```java
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
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/MergeSort.java)

### 说明
调用 ```MergeSort.sort(int[] array)``` 对数组进行排序

## 堆排序

### 简介
参考[bubkoo的博客](http://bubkoo.com/2014/01/14/sort-algorithm/heap-sort/)
堆排序的平均时间复杂度为O(nlogn),接近于最坏的时间复杂度。在最好情况下，时间复杂度为O(1).

### 步骤
同上

### 参考代码
```java
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
```
[查看完整代码](https://github.com/TangJiong/sort-algorithms/blob/master/src/main/java/site/tangjiong/sort/HeapSort.java)

### 说明
调用 ```HeapSort.sort(int[] array)``` 对数组进行排序

## 希尔排序

### 简介
TODO