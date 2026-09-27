/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node first = head;
        while (first != null) {
            copyNode(first, map);
            first = first.next;
        }

        first = head;
        Node firstCopy = map.get(head);
        while (firstCopy != null) {
            firstCopy.next = map.get(first.next);
            firstCopy.random = map.get(first.random);
            first = first.next;
            firstCopy = firstCopy.next;
        }

        return map.get(head);
    }

    public void copyNode(Node node, Map<Node, Node> map) {
        Node copy = new Node(node.val);
        map.put(node, copy);
    }
}
