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
        String result = "";
        ListNode<T> tool = first;
        if (tool == null) {
            return "[" + result + "]";
        } else if (tool.getNext() == null) {
            result += tool.getValue();
            return "[" + result + "]";
        } else {
            while (tool != null) {
                result += tool.getValue();
                if (tool.getNext() != null) {
                    result += ", ";
                }
                tool = tool.getNext();
            }
            return "[" + result + "]";
        }
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
        ListNode<T> tool = first;
        if(o==null){
            for(tool=first;tool!=null;tool=tool.getNext())for(tool=first;tool!=null;tool=tool.getNext()){
                if(tool.getValue()==null){
                    contain=true;
                    return contain;
                }
            }
        }else{  //o!=null
            for(tool=first;tool!=null;tool=tool.getNext())for(tool=first;tool!=null;tool=tool.getNext()){
                if(tool.getNext()!=null){
                    if(o.equals(tool.getValue())){
                        contain=true;
                        return contain;
                    }
                }else{
                    if(o.equals(tool.getValue())){
                        contain=true;
                        return contain;
                    }else{
                        return contain;
                    }
                }

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
        if(o==null){
            for(tool=first;tool!=null;tool=tool.getNext()){
                if(tool.getValue()==null) {
                    if(tool==first) {
                        tool=tool.getNext();
                        tool.setPrevious(first.getPrevious());
                        first=tool;
                        break;
                    } else if (tool==last) {
                        tool=tool.getPrevious();
                        tool.setNext(last.getNext());
                        last=tool;
                        break;
                    }else{
                        tool.getNext().setPrevious(tool.getPrevious());
                        tool.getPrevious().setNext(tool.getNext());
                        break;
                    }
                }
            }
        }else{
            for(tool=first;tool!=null;tool=tool.getNext()){
                if(o.equals(tool.getValue())){
                    if(tool==first) {
                        tool=tool.getNext();
                        tool.setPrevious(first.getPrevious());
                        first=tool;
                        break;
                    } else if (tool==last) {
                        tool=tool.getPrevious();
                        tool.setNext(last.getNext());
                        last=tool;
                        break;
                    }else{
                        tool.getNext().setPrevious(tool.getPrevious());
                        tool.getPrevious().setNext(tool.getNext());
                        break;
                    }
                }
            }
        }
//        while (tool.getNext() != null) {
//            if (tool.getValue().equals(o)) {
//                tool = tool.getNext();
//                tool.setPrevious(first);
//                first.setNext(tool);
//                break;
//            } else {
//                tool = tool.getNext();
//            }
//        }
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
        if (index < 0 || index > size() || isEmpty() == true) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        findNode(index);
        return findNode(index).getValue();
    }

    private ListNode<T> findNode(int index) {
        int count = 0;
        ListNode<T> tool = first;
        while (count < index) {
            tool = tool.getNext();
            count++;
        }
        return tool;
    }

    @Override
    public void add(int index, T element) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        ListNode<T> node = new ListNode<>(element);
        if (isEmpty()) {  // list is empty
            first = node;
            last = node;
        } else if (index == 0) { // insert before head
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        } else if (index == size()) { // insert after tail
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        } else { //general case
            ListNode<T> pre = null;
            ListNode<T> tool = first;
            while (index > 0) {
                pre = tool;
                tool = tool.getNext();
                index--;
            }
            node.setNext(tool);
            node.setPrevious(pre);
            pre.setNext(node);
            tool.setPrevious(node);
        }
    }


    @Override
    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("List index is out of bound");
        }
        if (index == 0) { // remove head
            ListNode<T> oldFirst = first;
            first = first.getNext();
            if (first != null) {
                first.setPrevious(null);
            } else {
                setLast(null);
            }
            oldFirst.setNext(null);
            return oldFirst.getValue();
        } else if (index == size()) { // remove last
            ListNode<T> tool = last;
            last = last.getPrevious();
            if (last == null) {
                first = null;
            } else {
                last.setNext(null);
            }
            return tool.getValue();
        } else { //general case
            ListNode<T> pre = null;
            ListNode<T> tool = first;
            while (index > 0) {
                pre = tool;
                tool = tool.getNext();
                index--;
            }
            pre.setNext(tool.getNext());
            tool.getNext().setPrevious(pre);
            return tool.getValue();
        }
    }

    @Override
    public int indexOf(T o) {
        int index = 0;
        ListNode<T> tool = first;
        if(o==null){
            for(tool=first;tool !=null;tool=tool.getNext(),index++)
                if(tool.getValue()==null){
                    return index;
                }
        }else{
            for(tool=first;tool!=null;tool=tool.getNext(), index++)
                if(o.equals(tool.getValue())){
                    return index;
                }
        }
        return -1;
    }

}