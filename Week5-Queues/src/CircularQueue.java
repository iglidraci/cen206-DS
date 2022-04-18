public class CircularQueue<T> extends ArrayQueue<T> {
    public void rotate(int k) {
        // naive solution
        // best to use a circularly linked list
        while (k-- > 0) {
            this.enqueue(this.dequeue());
        }
    }
    public void rotate() {
        this.rotate(1);
    }
}
