package sort;

import java.util.Arrays;

/**
 * Created by Y on 2018/6/27.
 */
public class Heap<E extends Comparable<E>>
{
    E[] elements;

    public Heap(E[] elements)
    {
        this.elements = elements;
    }

    public void sort()
    {
        int len = elements.length;
        while (len>1)
        {
            //调整为大顶堆
            for (int parentIndex = len/2-1;parentIndex>=0;parentIndex--)
            {
                swapIfNotSatisfied(parentIndex,len);
            }
            //交换堆顶和最后一位,长度-1
            swap(0,len-1);
            System.out.println(Arrays.toString(this.elements));
            len --;
        }
    }

    private void swap(int i,int j)
    {
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private void swapIfNotSatisfied(int parentIndex, int lenLimit)
    {
        if(2*parentIndex>=lenLimit)
        {
            return;
        }
        //将父节点与左右节点中最大值交换
        int maxIndex = parentIndex;
        E maxVal = elements[parentIndex];
        if(parentIndex*2+1 < lenLimit && elements[parentIndex*2+1].compareTo(maxVal)>0)
        {
            maxIndex = parentIndex*2+1;
            maxVal = elements[parentIndex*2+1];
        }
        if(parentIndex*2+2 < lenLimit && elements[parentIndex*2+2].compareTo(maxVal)>0)
        {
            maxIndex = parentIndex*2+2;
        }
        //发生交换
        if(maxIndex != parentIndex)
        {
            swap(maxIndex,parentIndex);
            //调整所有子节点
            swapIfNotSatisfied(maxIndex,lenLimit);
        }
    }

    public static void main(String[] args)
    {

    }
}
