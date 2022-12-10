package de.tum.in.ase;

// TODO: make it implement the interface MyList
public class LinkedList<T>  implements MyList<T> {
    // TODO: add attributes
    private ListNode<T> first;
    private ListNode<T> last;

    // TODO: add a constructor
    public LinkedList() {

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
        boolean Empty = false;
        if (size() == 0) {
            Empty = true;
        }
        return Empty;
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
        ListNode<T> node =new ListNode<T>(t);
        if(getFirst()==null){
            setFirst(node);
        }else{
            ListNode<T> last = first;
            while (last.getNext()!=null){
                last=last.getNext();
            }
            last.setNext(node);
        }
    }

    @Override
    public void remove(T o) {
        ListNode<T> last = first;
        while (last.getNext() != null) {
            if (last.getValue().equals(o)) {
               setFirst(getLast().getNext());
               break;
            } else {
                last=last.getNext();
            }
        }
    }

    @Override
    public void clear() {
        ListNode<T> last = first.getNext();
        while (last!=first){
            ListNode<T> last_next= last.getNext();
            last.getNext().setNext(null);
            last.getPrevious().setPrevious(null);
            last =last_next;
        }
        first.setNext(first.getPrevious());
    }

    @Override
    public T get(int index) {
       if (index >= size()){
           throw new IndexOutOfBoundsException();
       }else{
            findNode(index);
       }
        return last.getValue();
    }

    @Override
    public void add(int index, T element) {
        try{
            if(index-1>=size()){
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            index =size();
        }
        ListNode<T> node=new ListNode<>(element);
        node.setNext(findNode(index));
        if(index>0){
            findNode(index-1).setNext(node);
        }else{
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
        ListNode<T> last = first;
        if(index>=size()){
            throw new IndexOutOfBoundsException();
        }else{
            findNode(index);
            last=last.getPrevious();
        }
        return last.getValue();
    }

    @Override
    public int indexOf(T o) {
        ListNode<T> last = first;
        int count=0;
        while (last.getNext() != null){
            if(last.getValue()!=o){
                last=last.getNext();
                count++;
                break;
            }else{
                count=-1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList linkedList =new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }
}