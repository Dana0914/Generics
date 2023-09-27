package generics.practice1;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(4);
        myList.add(3);
        myList.add(25);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        MyArrayList<Boolean> myBooleanList = new MyArrayList<>();
        myBooleanList.add(true);
        myBooleanList.add(true);
        for (int i = 0; i < myBooleanList.size(); i++) {
            System.out.println(myBooleanList.get(i));
        }
    }
}
