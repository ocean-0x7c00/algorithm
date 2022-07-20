package org.heap;

public class Lesson06_Heap {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.push(1);
        maxHeap.push(2);
        maxHeap.push(3);
        maxHeap.push(4);
        int[] arr = {1, 2};
        maxHeap.heapify(arr, 0, 2);

        System.out.println();
    }

    public static class MaxHeap {
        private final int limit;
        private int[] heap;
        private int heapSize;

        public MaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        private void heapInsert(int[] arr, int index) {
            //包含两个终止条件
            //index来到0或不比父节点大
            //时间复杂度O(logN)
            //假设index=10，
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }


        public int pop() {
            if (heapSize == 0) {
                throw new RuntimeException("");
            }

            int ans = heap[0];
            swap(heap, 0, heapSize--);

            heapify(heap, 0, heapSize);

            return ans;
        }

        public void heapify(int[] arr, int index, int heapSize) {
            int leftIndex = 2 * index + 1;

            //heapSize堆中元素个数，leftIndex元素标号，一定比heapSize小
            while (leftIndex < heapSize) {//可能有右孩子
                int largest = leftIndex + 1 < heapSize && arr[leftIndex + 1] > arr[leftIndex] ? leftIndex + 1 : leftIndex;
                largest = arr[index] < arr[largest] ? largest : index;

                //当前位置就是最大值
                //index比两个子都大
                if (largest == index) {
                    break;
                }
                swap(arr, index, largest);
                index = largest;
                leftIndex = 2 * index + 1;
            }


        }


        public void heapSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            //构建大根堆
            for (int i = 0; i < arr.length; i++) {
                heapInsert(arr, i);
            }

            int heapSize = arr.length;
//
            for (int i = arr.length-1; i >= 0; i--) {
                heapify(arr, i, arr.length);
            }




            swap(arr, 0, --heapSize);
            while (heapSize > 0) {
                heapify(arr, 0, heapSize);
                swap(arr, 0, --heapSize);
            }



        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
