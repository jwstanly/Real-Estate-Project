public class PQueue{
	
	private Problem[] heap; 
    private int heapSize;
    private int capacity;
    
    public PQueue(int capacity){    
        this.capacity = capacity + 1;
        heap = new Problem[this.capacity];
        heapSize = 0;
    }
    
    public void clear(){
    	heap = new Problem[capacity];
        heapSize = 0;
    }
    
    public boolean isEmpty(){
        return heapSize == 0;
    }
    
    public boolean isFull(){
        return heapSize == capacity - 1;
    }
    
    public int size(){
        return heapSize;
    }
    
    public void enqueue(Problem passedProblem){
        heap[++heapSize] = passedProblem;
        int pos = heapSize;
        while(pos != 1 && passedProblem.getPriority() > heap[pos/2].getPriority()){
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = passedProblem;    
    }
    
    public Problem dequeue(){
        int parent, child;
        Problem item, temp;
        if (isEmpty()){
            System.out.println("Problem heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize){
            if(child < heapSize && heap[child].getPriority() < heap[child + 1].getPriority()) {
            	child++;
            }
            if(temp.getPriority() >= heap[child].getPriority()) {
            	break;
            }
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }
    
    public Problem front(){
    	return heap[1];
    }
    
    public Problem rear(){
    	return heap[heapSize];
    }
    
    public String toString(){
    	String output = null;
    	for(int x=0;x<heap.length;x++) {
    		output+=heap[x].toString()+"\n";
    	}
    	return output;
    }
}