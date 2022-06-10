package br.com.sarraff;

public class ListaLigada {

	static Node head;
	
	static class Node {
		int dados;
		Node proximo;
		Node(int d)	{
			dados = d;
			proximo = null;
		}
	}

	// método de deteção e remoção
	void EncontraRemove(Node node){
        if (node == null || node.proximo == null) {
        	return;
        }
 
        Node slow = node;
        Node fast = node;
 
        slow = slow.proximo;
        fast = fast.proximo.proximo;
 
        while (fast != null && fast.proximo != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.proximo;
            fast = fast.proximo.proximo;
        }
        if (slow == fast) {
            slow = node;
            if (slow != fast) {
                while (slow.proximo != fast.proximo) {
                    slow = slow.proximo;
                    fast = fast.proximo;
                }

                fast.proximo = null;
            }else {
                while(fast.proximo != slow) {
                    fast = fast.proximo;
                }
                fast.proximo = null;
            }
        }
	}

	// Function to print the linked list
	void printList(Node node){
		while (node != null) {
			System.out.print(node.dados + " ");
			node = node.proximo;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args){
		ListaLigada list = new ListaLigada();
		list.head = new Node(50);
		list.head.proximo = new Node(20);
		list.head.proximo.proximo = new Node(15);
		list.head.proximo.proximo.proximo = new Node(4);
		list.head.proximo.proximo.proximo.proximo = new Node(10);

		// 	Creating a loop for testing
		head.proximo.proximo.proximo.proximo.proximo = head.proximo.proximo;
		
		list.EncontraRemove(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}