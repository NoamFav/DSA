public class QueueAPIs<T> {
    private T[] elements;
    private int array_size;
    private int front_index;
    private int rear_index;
    private int size;
    public QueueAPIs() {
        this.array_size = 1;
        this.elements = (T[]) new Object[this.array_size];
        this.front_index = 0;
        this.rear_index = 0;
        this.size = 0;
    }

    public void enqueue(T element) {
        if(this.size==this.array_size){
            int new_array_size = 2*this.array_size;
            T[] new_elements = (T[]) new Object[new_array_size];
            if (this.array_size >= 0)
                System.arraycopy(this.elements, front_index, new_elements, 0, this.array_size);
            this.front_index = 0;
            this.rear_index = this.size;
            this.array_size = new_array_size;
            this.elements = new_elements;
        }
        this.elements[rear_index] = element;
        this.size++;
        rear_index = (rear_index + 1) % this.array_size;
    }

    public T dequeue() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }else{
            T front_element = elements[front_index];
            elements[front_index] = null;
            front_index = (front_index + 1) % this.array_size;
            this.size--;
            return front_element;
        } }

    public T peek() {
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }else{
            return elements[front_index];
        } }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(T item: elements) {
            if (item != null) {
                output.append(item).append(" ");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        QueueAPIs<String> queueAPIs = new QueueAPIs<>();

        queueAPIs.enqueue("A");
        queueAPIs.enqueue("B");
        queueAPIs.enqueue("C");
        queueAPIs.enqueue("Z");
        queueAPIs.enqueue("E");
        queueAPIs.enqueue("T");
        queueAPIs.enqueue("Y");

        String top = queueAPIs.peek();

        System.out.println(top);
        System.out.println(queueAPIs.size());
        System.out.println(queueAPIs);

        String topItem = queueAPIs.dequeue();

        System.out.println(queueAPIs);
        System.out.println(topItem);
    }
}

