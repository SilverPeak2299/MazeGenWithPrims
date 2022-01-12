package Maze;


public class PriorityQueue { // Priority Queue implimented with linked list

    static class Node { // Linked list node for a mazeCell
        public mazeCell data;
        public int priority;
        public Node nextNode;

        Node(mazeCell data,int priority) {
            this.data = data;
            this.priority = priority;
            this.nextNode = null;
        }

        Node(mazeCell data,int priority, Node nextNode) {
            this.data = data;
            this.priority = priority;
            this.nextNode = nextNode;
        }
    }

    private Node head = null;

    public mazeCell peek() { // look the top value
        if (head == null) { return null; }
        return head.data;
    }

    public Node pop() { // remove the top element
        Node temp = head;
        head = head.nextNode;
        return temp;
    }

    public void push(mazeCell data, int priority) { // add a new element in its palce
        if (head == null) {
            head = new Node(data, priority);
            return;

        } else if (priority < head.priority) {
            head = new Node(data, priority, head);
            return;
        }

        Node current = head;
        while (current.nextNode != null && current.priority < priority) {
            current = current.nextNode;
        }

        current.nextNode = new Node(data, priority, current.nextNode);
    }
}
