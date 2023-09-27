package generics.practice2;


public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    @Override
    public void add(T value) {
        Node<T> node;
        if (size == 0) {
            node = new Node<>(null, null, value);
            first = node;
        } else {
            node = new Node<>(last, null, value);
            last.setNext(node);

        }
        last = node;
        size++;

    }

    @Override
    public void add(int index, T value) {
        Node<T> newNode = new Node<>(null, null, value);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds ");
        }
        if (size == 0) {
            // Adding to an empty list
            first = newNode;
            last = newNode;
        } else if (index == 0) {
            // Adding at the beginning of the list
            Node<T> current = first;
            newNode.setNext(current);
            current.setPrev(newNode);
            first = newNode;
        } else if (index == size) {
            // Adding at the end of the list
            Node<T> lastNode = last;
            newNode.setPrev(lastNode);
            lastNode.setNext(newNode);
            last = newNode;
        } else {
            // Adding at a specific index
            Node<T> current = getIndex(index);
            Node<T> prev = current.getPrev();
            newNode.setNext(current);
            newNode.setPrev(prev);
            prev.setNext(newNode);
            current.setPrev(newNode);
        }
        size++;

    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        getIndex(index).setValue(value);
    }

    @Override
    public T get(int index) {
        Node<T> current = first;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        else if (index == 0 && size > 1) {
            Node<T> node = first;
            Node<T> nextNode = node.getNext();
            nextNode.setPrev(null);
            first = nextNode;
        }
        else if (index == size-1 && size > 1) {
            Node<T> node = last;
            Node<T> prevNode = node.getPrev();
            prevNode.setNext(null);
            last = prevNode;
        }
        else if (index > 0 && index < size) {
            Node<T> node = getIndex(index);
            Node<T> prevNode = node.getPrev();
            Node<T> nextNode = node.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }
        else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public boolean contains(T value) {
        for (Node<T> node = first; node != null; node = node.getNext()) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    public Node<T> getIndex(int index) {
        Node<T> current = first;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
    public boolean isEmpty() {
        return size == 0;
    }

}
