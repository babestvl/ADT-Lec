public class LinkedList<T> {

    public class Node {
        private T val;
        private Node next = null;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }

        public Node() {
            this(null);
        }

        public Node getNext() {
            return next;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T v) {
            val = v;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return tail != null;
    }

    public int size() {
        return size;
    }

    public Node addHead(T v) {
        if (isEmpty()) {
            return add(v);
        } else {
            Node newNode = new Node(v);
            newNode.next = head;
            head = newNode;
            return newNode;
        }
    }

    public void removeHead() {
        if(head != null){
            head = head.next;
            size--;

            if(head == null){
                tail = null;
            }
        }
    }

    public Node add(T v) {
        Node newNode = new Node(v);

        if (!isEmpty()) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = tail = newNode;
        }

        size++;
        return newNode;
    }

    public Node addAfter(Node node, T v) {
        Node newNode = new Node(v);
        newNode.next = node.next;
        node.next = newNode;

        size++;
        return newNode;
    }

    public void removeAfter(Node node) {
        if (node.next != null) {
            node.next = node.next.next;
            size--;
        }
    }

    public Node getHead() {
        return head;
    }
}