package generics.practice2;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, "item1");
        myLinkedList.add(1, "item2");
        myLinkedList.add(2, "item3");
        myLinkedList.add(3, "item4");
        myLinkedList.remove(2);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add(1);
        myLinkedList1.add(2);
        for (int i = 0; i < myLinkedList1.size(); i++) {
            System.out.println(myLinkedList1.get(i));
        }
        MyLinkedList<Double> myLinkedList2 = new MyLinkedList<>();
        myLinkedList2.add(5.0);
        myLinkedList2.add(4.0);
        myLinkedList2.remove(1);
        for (int i = 0; i < myLinkedList2.size(); i++) {
            System.out.println(myLinkedList2.get(i));
        }


    }
}
