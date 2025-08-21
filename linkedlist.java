import java.util.*;

class ListNode{
    int val;
    ListNode next;
    
    ListNode(int value){
        this.val = value;
        this.next = null;
    }
}

public class linkedlist
{
    public static ListNode createList(Scanner sc, int n){
        if(n<=0) return null;
        
        System.out.print("Enter the value of node 1: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        
        for(int i=2; i<=n; i++){
            System.out.print("Enter the value of node " + i + ": ");
            ListNode newnode = new ListNode(sc.nextInt());
            current.next = newnode;
            current = newnode; 
        }
        
        return head;
    }
    
    public static void printList(ListNode head){
        ListNode temp = head;
        
        while(temp != null){
            System.out.print(temp.val +" ");
            temp = temp.next;
        }
        
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of linked list 1: ");
		int n1 = sc.nextInt();
		ListNode l1 = createList(sc, n1);
		
		System.out.print("Enter the size of linked list 2: ");
		int n2 = sc.nextInt();
		ListNode l2 = createList(sc, n2);
		
		System.out.println("Linked list 1");
		printList(l1);
		
		System.out.println("\nLinked list 2");
		printList(l2);
		
	}
}