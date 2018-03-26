import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main (String[] args) {
        System.out.println("Reversed Linked List Tests:");
        System.out.println("Original List"+generateLinkedList());
        System.out.println("Reversed List"+reverseLinkedList(generateLinkedList()));
    }


    public static LinkedList<Integer> generateLinkedList() {
        LinkedList<Integer> object = new LinkedList<Integer>();
        object.add(10);
        object.add(30);
        object.add(2);
        object.add(3);
        object.add(63);
        return object;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> originalList){
        int listLength = originalList.size();
        LinkedList<Integer> newList = new LinkedList<Integer>();
        for(int i = 0; i < listLength; i++){
            newList.add(originalList.removeLast());
        }
        return newList;
    }
}
