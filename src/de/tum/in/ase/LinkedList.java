package de.tum.in.ase;

// TODO: make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {
    // TODO: add attributes
    private ListNode<T> first = null; //head
    private ListNode<T> last = null; //tail

    // TODO: add a constructor
    public LinkedList() {
        first = null;
        last = null;
    }

    public LinkedList(ListNode<T> first, ListNode<T> last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    // TODO: add getters and setters

    public ListNode<T> getFirst() {
        return first;
    }

    public void setFirst(ListNode<T> first) {
        this.first = first;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public void setLast(ListNode<T> last) {
        this.last = last;
    }

    // TODO: implement interface methods

    @Override
    public int size() { // the number of elements in this list.
        int count = 0;
        ListNode<T> last = first; //create a new ListNode name:last && last =first(which have all of value)
        while (last != null) {
            last = last.getNext();  //
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(T o) {
        boolean contain = false;
        ListNode<T> last = first;
        while (last.getNext() != null) {
            if (last.getValue().equals(o)) {
                contain = true;
            } else {
                last = last.getNext();
            }
        }
        return contain;
    }

    @Override
    public void add(T t) {
        if (isEmpty()) {
            first = last = new ListNode<T>(t, null, null);
        } else {
            last.setNext(new ListNode<T>(t, last, null));
            last = last.getNext();
        }
    }

    @Override
    public void remove(T o) {
        ListNode<T> tool = first;
        while (tool.getNext() != null) {
            if (tool.getValue().equals(o)) {
                tool = tool.getNext();
                tool.setPrevious(first);
                first.setNext(tool);
                break;
            } else {
                tool = tool.getNext();
            }
        }
    }

    @Override
    public void clear() {
        ListNode<T> tool = first;
        while (tool != null) {
            ListNode<T> next = tool.getNext();
            tool.setPrevious(null);
            tool.setNext(null);
            tool = next;
        }
        first = last = tool = null;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            findNode(index);
        }
        return last.getValue();
    }

    @Override
    public void add(int index, T element) {
        try {
            if (index - 1 >= size()) {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            index = size();
        }
        ListNode<T> node = new ListNode<>(element);
        node.setNext(findNode(index));
        if (index > 0) {
            findNode(index - 1).setNext(node);
        } else {
            first.setNext(node);
        }
    }

    private ListNode<T> findNode(int index) {
        int count = 0;
        ListNode<T> last = first;
        while (count < index) {
            last = last.getNext();
            count++;
        }
        return last;
    }

    @Override
    public T remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            findNode(index);
            last = last.getPrevious();
        }
        return last.getValue();
    }

    @Override
    public int indexOf(T o) {
        ListNode<T> last = first;
        int count = 0;
        while (last.getNext() != null) {
            if (last.getValue() != o) {
                last = last.getNext();
                count++;
                break;
            } else {
                count = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("sa");
        linkedList.add("si");
        linkedList.add("re");
        linkedList.remove("si");
        linkedList.clear();
        System.out.println(linkedList.size());
    }
}