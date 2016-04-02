package site.tangjiong.sort;

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
