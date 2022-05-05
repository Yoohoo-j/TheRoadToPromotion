package aiden.trtp.algorithm;

/**
 * @program: TheRoadToPromotion
 * @description: 堆排序
 * @author: Mr.Jiang
 * @create: 2022-04-25 17:58
 **/
public class HeapSort {

    private int[] heap;
    private final int limit;
    private int heapSize;
    
    public HeapSort(int limit){
        this.heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }
    
    public boolean isEmpty(){
        return heapSize == 0;
    }
    
    public boolean isFull(){
        return heapSize == limit;
    }

    public void push(int value){
        if (heapSize == limit){
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize);
    }

    public int pop(){
        if (this.isEmpty()){
            throw new RuntimeException("heap is empty");
        }
        int max = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return max;
    }

    //从上向下判断当前节点的左右子节点是否比当前节点大
    //没有左右节点，没有更大 则停止
    private void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while(left < heapSize){ //越界说明 没有左子节点
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[index] > largest ? index : largest;
            if (largest == index){
                break;
            }
            swap(heap, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = heap[i];
    }

    private void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]){
            swap(heap, index, (index -1) / 2);
            index = (index - 1) / 2;
        }
    }
}
