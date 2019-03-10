import java.util.Scanner;

/**
 * Created by arjun on 10/03/19.
 */
public class Q103 {

    Node head;
    Q103(){
        head=null;
    }

    void addNode(int data){
        if (head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
    }

    void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
    }

    //Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
    Node reverseLinkedListInGroupsOfK(Node temp, int k) {
        Node t = temp;
        if (temp == null)
            return temp;
        int count = 0;
        while(t != null){
            count++;
            t = t.next;
        }
        if (count < k) return temp;
        t = temp;
        Node p = null;
        Node r = t.next;
        count = 0;

        while (count < k ){
            t.next = p;
            p = t;
            t = r;
            if (r != null) r=r.next;
            count++;
        }

        temp.next = reverseLinkedListInGroupsOfK(t, k);
        return p;
    }

    public static void main(String a[]){
        Q103 object = new Q103();
        object.addNode(1);
        object.addNode(2);
        object.addNode(2);
        object.addNode(4);
        object.addNode(5);
        object.addNode(6);

        object.display();
        System.out.println("after reverse");
        object.head = object.reverseLinkedListInGroupsOfK(object.head, 4);
        object.display();

    }
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}


