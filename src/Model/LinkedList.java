package Model;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail; 
    private int size = 0;

    public void print() {
        if (head == null) {
            System.out.println("End");
            return;
        }
        Node<T> current = head;
        while (current != null) { 
            System.out.print(current.getValue() + (current.getNext() != null ? " -> " : ""));
            current = current.getNext();
        }
        System.out.println(" "); 
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void appendToTail(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode; 
        } else {
            tail.setNext(newNode);//Establece el siguiente nodo del tail al nuevo nodo
            tail = newNode;        
        }
        size++;
    }

    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    tail = current; 
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public Node<T> findByValue(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
