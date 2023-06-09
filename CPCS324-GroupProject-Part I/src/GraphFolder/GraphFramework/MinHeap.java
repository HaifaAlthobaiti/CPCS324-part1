/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package GraphFolder.GraphFramework;
public class MinHeap {
    
//--------------Attributes------------------
private final Edge[] heap;
private int size;

//--------------------Constructors---------------

    public MinHeap(int capacity) {
        this.heap = new Edge[capacity];
        this.size = 0;
    }

    public void insert(Edge edge) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size++] = edge;
        siftUp(size - 1);
    }

    private void siftUp(int index) {
        int parent = (index - 1) / 2;

        while (index > 0 && heap[index].compareTo(heap[parent]) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }
    
    private boolean isFull() {
        return size == heap.length;
    }
    

    public Edge peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap[0];
    }

    public Edge extractMin() {
        Edge min = peek();
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);

        return min;
    }

    public int size() {
        return size;
    }

   
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].getWeight() >= heap[parent].getWeight()) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
    int smallest = index;

        while (true) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left < size && heap[left].getWeight() < heap[smallest].getWeight()) {
                smallest = left;
            }

            if (right < size && heap[right].getWeight() < heap[smallest].getWeight()) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Edge temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
