package de.tum.in.ase;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(-1));
        linkedList.get(0);
        System.out.println(linkedList.toString());
        linkedList.add(-1, "rr");
        linkedList.add(0, "yo");
        linkedList.add(6, "rr");
        linkedList.add(4, "rr");
        System.out.println(linkedList.toString());
        linkedList.remove(-1);
        linkedList.remove(0);
        linkedList.remove(4);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.contains("c"));
        System.out.println(linkedList.contains("d"));

//        System.out.println( linkedList.get(2));
//        System.out.println(linkedList.get(0));

//        System.out.println(linkedList.toString());
        //linkedList.remove("si");
        //linkedList.clear();
//        linkedList.remove(1);
//        System.out.println(linkedList.toString());
//        linkedList.remove(0);
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.indexOf("sa"));
//        System.out.println(linkedList.indexOf("si"));
//        System.out.println(linkedList.indexOf("re"));
//        System.out.println(linkedList.indexOf("aa"));
    }
}
