package test;

import main.SimpleLinkedList;

public class SimpleLinkedListTest {

    /**
     * Test case to test the simple operations defined in {@link SimpleLinkedList}
     */
    private static void testSimpleLinkedList() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);

        list.printList();

        list.deleteByKey(2);
        list.printList();
        list.insertNode(4);
        list.insertNode(5);
        list.printList();
        list.deleteByKey(5);
        list.printList();
        list.deleteByKey(1);
        list.printList();
    }

    public static void main(String[] args) {
        testSimpleLinkedList();
    }
}
