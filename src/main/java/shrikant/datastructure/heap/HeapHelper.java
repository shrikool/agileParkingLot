package shrikant.datastructure.heap;

import java.util.Arrays;

public class HeapHelper {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 8, 2, 9, 1};
        Heap heap = makeHeap(arr, true);
        System.out.println(Arrays.toString(heap.getArray()));
        deleteTop(heap);
        System.out.println(Arrays.toString(heap.getArray()));
        deleteTop(heap);
        System.out.println(Arrays.toString(heap.getArray()));
    }

    public static Heap makeHeap(int[] material, boolean makeMaxHeap) {
        if (material.length == 0)
            return new Heap();

        Heap heap = new Heap(material, 0, material.length, makeMaxHeap);

        for (int count = 0; count < material.length; count++) {
            heapify(heap);
        }

        return heap;
    }

    public static int deleteTop(Heap heap) {
        if (heap.getCount() == 0)
            return -1;
        int valToReturn = heap.getArray()[0];
        swap(heap, 0, heap.getCount() - 1);
        heap.setCount(heap.getCount() - 1);
        percolateDown(heap, 0);
        return valToReturn;
    }

    private static void percolateDown(Heap heap, int rootIndex) {
        if (rootIndex < 0 || rootIndex > heap.getCount() - 1)
            return;

        int currentRootIndex = rootIndex;
        int leftChildIndex = getLeft(rootIndex);
        int rightChildIndex = getRight(rootIndex);

        if (leftChildIndex <= heap.getCount() - 1 && rightChildIndex <= heap.getCount() - 1) {
            if (heap.isMaxHeap()) {
                int maxIndex = getMaxChildIndex(heap, leftChildIndex, rightChildIndex);
                if (elementAt(heap, currentRootIndex) < elementAt(heap, maxIndex))
                    swap(heap, currentRootIndex, maxIndex);
                currentRootIndex = maxIndex;
            } else if (!heap.isMaxHeap()) {
                int minIndex = getMinChildIndex(heap, leftChildIndex, rightChildIndex);
                if (elementAt(heap, currentRootIndex) > elementAt(heap, minIndex))
                    swap(heap, currentRootIndex, minIndex);
                currentRootIndex = minIndex;
            }
        } else if (leftChildIndex <= heap.getCount() - 1) {
            if (heap.isMaxHeap()) {
                if (elementAt(heap, currentRootIndex) < elementAt(heap, leftChildIndex))
                    swap(heap, currentRootIndex, leftChildIndex);
                currentRootIndex = leftChildIndex;
            } else if (!heap.isMaxHeap()) {
                if (elementAt(heap, currentRootIndex) > elementAt(heap, leftChildIndex))
                    swap(heap, currentRootIndex, leftChildIndex);
                currentRootIndex = leftChildIndex;
            }
        } else if (rightChildIndex <= heap.getCount() - 1) {
            if (heap.isMaxHeap()) {
                if (elementAt(heap, currentRootIndex) < elementAt(heap, rightChildIndex))
                    swap(heap, currentRootIndex, rightChildIndex);
                currentRootIndex = rightChildIndex;
            } else if (!heap.isMaxHeap()) {
                if (elementAt(heap, currentRootIndex) > elementAt(heap, rightChildIndex))
                    swap(heap, currentRootIndex, rightChildIndex);
                currentRootIndex = rightChildIndex;
            }
        }
        if (currentRootIndex != rootIndex)
            percolateDown(heap, currentRootIndex);
    }

    private static int elementAt(Heap heap, int maxIndex) {
        return heap.getArray()[maxIndex];
    }

    private static int getMaxChildIndex(Heap heap, int leftChildIndex, int rightChildIndex) {
        int index = leftChildIndex;
        if (heap.getArray()[rightChildIndex] > heap.getArray()[leftChildIndex])
            index = rightChildIndex;
        return index;
    }

    private static int getMinChildIndex(Heap heap, int leftChildIndex, int rightChildIndex) {
        int index = leftChildIndex;
        if (heap.getArray()[rightChildIndex] < heap.getArray()[leftChildIndex])
            index = rightChildIndex;
        return index;
    }

    private static int getRight(int count) {
        return 2 * count + 2;
    }

    private static int getLeft(int count) {
        return 2 * count + 1;
    }

    private static void heapify(Heap heap) {
        if (heap.getCount() == heap.getCapacity())
            return;
        heap.setCount(heap.getCount() + 1);
        percolateUp(heap);
    }

    private static void percolateUp(Heap heap) {
        int insertedNumberIndex = heap.getCount() - 1;
        int parent = (insertedNumberIndex - 1) / 2;
        while (parent >= 0) {
            if (heap.isMaxHeap() && heap.getArray()[parent] < heap.getArray()[insertedNumberIndex]) {
                swap(heap, insertedNumberIndex, parent);
                insertedNumberIndex = parent;
                parent = (parent - 1) / 2;
            } else if (!heap.isMaxHeap() && heap.getArray()[parent] > heap.getArray()[insertedNumberIndex]) {
                swap(heap, insertedNumberIndex, parent);
                insertedNumberIndex = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }

    private static void swap(Heap heap, int current, int parent) {
        int temp = heap.getArray()[parent];
        heap.getArray()[parent] = heap.getArray()[current];
        heap.getArray()[current] = temp;
    }
}
