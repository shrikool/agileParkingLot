package shrikant.datastructure.heap;

public class Heap {
    private int[] array;
    private int count;
    private int capacity;
    private boolean isMaxHeap;

    public Heap() {
    }

    public Heap(int[] array, int count, int capacity, boolean isMaxHeap) {
        this.array = array;
        this.count = count;
        this.capacity = capacity;
        this.isMaxHeap = isMaxHeap;
    }

    public boolean isMaxHeap() {
        return isMaxHeap;
    }

    public void setMaxHeap(boolean maxHeap) {
        this.isMaxHeap = maxHeap;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
