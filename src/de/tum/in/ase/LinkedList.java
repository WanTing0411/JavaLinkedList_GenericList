package de.tum.in.ase;

// TODO: make it implement the interface MyList
public class LinkedList<T> implements MyList<T> {
    // TODO: add attributes
    private ListNode<T> first = null; //head
    private ListNode<T> last = null; //tail
    private int n;

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
        StringBuilder sb =new StringBuilder();
        ListNode<T> tool =first;
        sb.append("[");
        while (tool!=null){
            sb.append(tool.getValue()+",");
            tool=tool.getNext();
        }
        sb.append("]");
        return sb.toString();
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
        return n;
//        int count = 0;
//        ListNode<T> last = first; //create a new ListNode name:last && last =first(which have all of value)
//        while (last != null) {
//            last = last.getNext();  //
//            count++;
//        }
//        return count;
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
            n++;
        } else {
            last.setNext(new ListNode<T>(t, last, null));
            last = last.getNext();
            n++;
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
        ListNode<T> node = new ListNode<>(element);
        try {
            if (index<0 ||index>size()) {
                throw new IndexOutOfBoundsException();
            }else if(isEmpty()){  // list is empty
                first=node;
                last=node;
            } else if (index==0) { // insert before head
                node.setNext(first);
                first.setPrevious(node);
                first=node;
            } else if (index ==size()) { // insert after tail
                node.setPrevious(last);
                last.setNext(node);
                last=node;
            }else { //general case
                ListNode<T> pre =null;
                ListNode<T> tool =first;
                while(index>0){
                    pre= tool;
                    tool=tool.getNext();
                    index--;
                }
                node.setNext(tool);
                node.setPrevious(pre);
                pre.setNext(node);
                tool.setPrevious(node);
                n++;
//                for (int i=1;i<index;i++){  //*ask Q
//                    tool=tool.getNext();
//                }
//                node.setNext(tool);
//                node.setPrevious(tool.getPrevious());
//                tool.setPrevious(node); //set tool previous become node address
//                tool.getPrevious().setNext(node); //equal the front node's next become node address
//                if(index==0){
//                    first=node;
//                }
            }
            //n++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List index is out of bound");
        }
    }


    @Override
    public T remove(int index) {
        try {
            if (index<0 ||index>size()) {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List index is out of bound");
        }
        if (index==0) { // remove head
            ListNode<T> oldFirst= first;
            first=first.getNext();
            if(first!=null){
                first.setPrevious(null);
            }else {
                setLast(null);
            }
            oldFirst.setNext(null);
            n--;
            return oldFirst.getValue();
        } else if (index ==size()-1) { // remove last
            ListNode<T> tool=last;
            last=last.getPrevious();
            if(last==null){
                first=null;
            }else {
                last.setNext(null);
            }
            n--;
            return tool.getValue();
        }else { //general case
            ListNode<T> pre =null;
            ListNode<T> tool =first;
            while(index>0){
                pre= tool;
                tool=tool.getNext();
                index--;
            }
            pre.setNext(tool.getNext());
            tool.getNext().setPrevious(pre);
            n--;
            return tool.getValue();
        }
    }

    @Override
    public int indexOf(T o) {
        ListNode<T> tool = first;
        int index = 0;
        if(o==null||tool==null){
            return -1;
        }else{
            for(tool=first;tool!=null;tool=tool.getNext()){
                if(tool.getValue()==o){
                    return index;
                }else {
                    index++;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("sa");
        linkedList.add("si");
        linkedList.add("re");
//        System.out.println( linkedList.get(2));
//        System.out.println(linkedList.get(0));
        linkedList.add(0,"yo");
        linkedList.add(1,"rr");
        System.out.println(linkedList.toString());
        //linkedList.remove("si");
        //linkedList.clear();
        linkedList.remove(1);
        System.out.println(linkedList.toString());
        linkedList.remove(0);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.indexOf("sa"));
        System.out.println(linkedList.indexOf("si"));
        System.out.println(linkedList.indexOf("re"));
        System.out.println(linkedList.indexOf("aa"));
    }
}