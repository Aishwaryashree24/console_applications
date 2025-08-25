import java.util.Scanner;

class MyListNode {
    int val;
    MyListNode next;

    MyListNode(int value) {
        this.val = value;
        this.next = null;
    }
}

public class addtwonumbers {

    public static MyListNode createList(Scanner sc, int n) {
        if (n <= 0)
            return null;

        System.out.print("Enter the value of node 1: ");
        MyListNode head = new MyListNode(sc.nextInt());
        MyListNode current = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter the value of node " + i + ": ");
            MyListNode newnode = new MyListNode(sc.nextInt());
            current.next = newnode;
            current = newnode;
        }

        return head;
    }

    public static void printList(MyListNode head) {
        MyListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static int getNum(MyListNode head) {
        int num = 0;
        int place = 1;

        while(head!=null){
            num += head.val * place;
            place *= 10;
            head = head.next;
        }

        return num;
    }

    public static MyListNode addTwoNumbers(MyListNode l1, MyListNode l2) {

        int n1 = getNum(l1);
        int n2 = getNum(l2);

        int sumNum = n1 + n2;

        MyListNode head = new MyListNode(sumNum % 10);
        sumNum /= 10;
        MyListNode current = head;

        while(sumNum != 0){
            current.next = new MyListNode(sumNum%10);
            current = current.next;
            sumNum /= 10;
        }
        
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of linked list 1: ");
        int n1 = sc.nextInt();
        MyListNode l1 = createList(sc, n1);

        System.out.print("Enter the size of linked list 2: ");
        int n2 = sc.nextInt();
        MyListNode l2 = createList(sc, n2);

        System.out.println("Linked list 1");
        printList(l1);
        System.out.println("\nReversed list 1\n" + getNum(l1));
        // printReverse(l1);

        System.out.println("\nLinked list 2");
        printList(l2);
        System.out.println("\nReversed list 2\n" + getNum(l2));
        // printReverse(l2);

        printList(addTwoNumbers(l1, l2));

    }
}
