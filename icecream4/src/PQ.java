public class PQ<T extends Comparable<T>> {
    static final int MAX_ELEMENTS = 2000000;
    private T [] items;
    private int n;

    PQ() {
        items = (T[]) new Comparable[MAX_ELEMENTS];
        n = 0;
    }

    int parent(int i) {
        return (i-1)/2;
    }

    int leftChild(int i) {
        return i*2 + 1;
    }

    int rightChild(int i) {
        return i*2 + 2;
    }

    public void add(T elt) {
        items[n] = elt;
        n++;

        percolateUp(n-1);
    }

    private void swap(int a, int b) {
        T temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

    public T poll() {
        T m = items[0];

        items[0] = items[n-1];
        items[n-1] = null;
        n--;

        percolateDown(0);
        return m;
    }

    private void percolateUp(int i) {
        while(i != 0) {
            int p = parent(i);
            if(items[i].compareTo(items[p]) < 0) {
                swap(i,p);
                i = p;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int i) {
        // your job here...
        while (true) {
            int li = leftChild(i);
            int ri = rightChild(i);
            if(li >= n) { // no left child
                break;
            }
            if (ri >= n) { // no right child but one left child
                if (items[i].compareTo(items[li]) > 0 ) {
                    swap(i,li);
                    i = li;
                } else {
                    break;
                }
            } else { // two children
                if ((items[i].compareTo(items[li]) > 0)&&(items[li].compareTo(items[ri])<0)) {
                    swap(i,li);
                    i=li;
                } else if (items[i].compareTo(items[ri])>0) {
                    swap(i,ri);
                    i = ri;
                } else {
                    break;
                }
            }
        }
    }
}