package code.basis.class01;

import java.util.TreeMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static code.basis.class01.Code03_Sort.swap;

public class Order implements Delayed {
    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();
        queue.put(new Order());
        TreeMap<Long, Integer> counters = new TreeMap<>();
//        counters.merge()

    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    private void heapInsert(int[] arr, int index) {
        // [index] [index-1]/2
        // index == 0
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = arr[2 * index + 1];
        int right = arr[2 * index + 2];
        int maxIndex = left < right ? 2 * index + 2 : 2 * index + 1;
        if (arr[maxIndex]>arr[index]){

        }
    }
}


