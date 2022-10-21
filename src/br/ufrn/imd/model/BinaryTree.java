package br.ufrn.imd.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree implements IBinaryTree {

    private Node j = new Node(9,"J", null, null);
    private Node i = new Node(8,"I", null, null);
    private Node h = new Node(7,"H", null, null);
    private Node f = new Node(6,"F", i, null);
    private Node e = new Node(5,"E", null, null);
    private Node d = new Node(4,"D", null, j);
    private Node c = new Node(3,"C", e, f);
    private Node b = new Node(2,"B", d, h);
    private Node a = new Node(1,"A", b, c);

    private Node root = a;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    // * Overload */
    public void generateHeights() {
        System.out.println("> BinaryTree.insertion.attribute.generateHeights");
        generateHeights(root);
        System.out.println("");
    }

    // * Overload */
    private void generateHeights(Node n) {
        if (n != null) {
            generateHeights(n.getLeftNode());
            generateHeights(n.getRightNode());
            int leftHeight = 0;
            int rightHeight = 0;
            n.setHeight(0);
            if (n.getLeftNode() == null) {
                leftHeight = 0;
            } else {
                leftHeight = n.getLeftNode().getHeight();
            }
            if (n.getRightNode() == null) {
                rightHeight = 0;
                if (n.getLeftNode() != null) {
                    n.setHeight(rightHeight + 1);
                }
            } else {
                rightHeight = n.getRightNode().getHeight();
                if (leftHeight > rightHeight) {
                    n.setHeight(leftHeight + 1);
                } else {
                    n.setHeight(rightHeight + 1);
                }
            }
            System.out.print(" <" + n.getHeight() + ",[" + n.getName() + "]>");
        }
    }

    /**
     * Breadth-first search from the root node (iterative)
     * print key values
     * 
     */
    @Override
    public void breadthFirst() {
        System.out.println("> BinaryTree.traversal.breadthFirst.levelOrder.iterative");
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(" [" + temp.getName() + "]");
            if (temp.getLeftNode() != null) {
                queue.add(temp.getLeftNode());
            }
            if (temp.getRightNode() != null) {
                queue.add(temp.getRightNode());
            }
        }
        System.out.println("");
    }

    /**
     * Depth-first search from the root node (recursive)
     * print key values
     * 
     * @param type define order of the vertices of tree( preOrder, inOrder,
     *             postOrder )
     */
    @Override
    public void depthFirst(int type) {
        if (type == 0) {
            System.out.println("> BinaryTree.traversal.depthFirst.preOrder.recursive");
            preOrder(root);
            System.out.println("");
        } else if (type == 1) {
            System.out.println("> BinaryTree.traversal.depthFirst.inOrder.recursive");
            inOrder(root);
            System.out.println("");
        } else if (type == 2) {
            System.out.println("> BinaryTree.traversal.depthFirst.postOrder.recursive");
            postOrder(root);
            System.out.println("");
        }
    }

    /**
     * Depth-first search from the root node (iterative)
     * print key values
     * 
     * @param type define order of the vertices of tree( preOrder, inOrder,
     *             postOrder )
     */
    public void depthFirstIterative(int type) {
        if (type == 0) {
            System.out.println("> BinaryTree.traversal.depthFirst.preOrder.iterative");
            preOrderIterative(root);
            System.out.println("");
        } else if (type == 1) {
            System.out.println("> BinaryTree.traversal.depthFirst.inOrder.iterative");
            inOrderIterative(root);
            System.out.println("");
        } else if (type == 2) {
            System.out.println("> BinaryTree.traversal.depthFirst.postOrder.iterative");
            postOrderIterative(root);
            System.out.println("");
        }
    }

    // * recursive depth-first search methods */

    private void preOrder(Node n) {
        if (n != null) {
            System.out.print(" [" + n.getName() + "]");
            preOrder(n.getLeftNode());
            preOrder(n.getRightNode());
        }
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.getLeftNode());
            System.out.print(" [" + n.getName() + "]");
            inOrder(n.getRightNode());
        }
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.getLeftNode());
            postOrder(n.getRightNode());
            System.out.print(" [" + n.getName() + "]");
        }
    }

    // * iterative depth-first search methods */

    private void preOrderIterative(Node n) {
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(n);
        while (!nodeStack.empty()) {
            Node temp = nodeStack.peek();
            System.out.print(" [" + temp.getName() + "]");
            nodeStack.pop();
            if (temp.getRightNode() != null) {
                nodeStack.push(temp.getRightNode());

            }
            if (temp.getLeftNode() != null) {
                nodeStack.push(temp.getLeftNode());
            }
        }
    }

    private void inOrderIterative(Node n) {
        Stack<Node> nodeStack = new Stack<Node>();
        Node temp = n;
        while (temp != null || !nodeStack.empty()) {
            while (temp != null) {
                nodeStack.push(temp);
                temp = temp.getLeftNode();
            }
            temp = nodeStack.pop();
            System.out.print(" [" + temp.getName() + "]");
            temp = temp.getRightNode();
        }
    }

    private void postOrderIterative(Node n) {
        Stack<Node> stack = new Stack<>();
        Node temp = n;
        while (true) {
            while (temp != null) {
                stack.push(temp);
                stack.push(temp);
                temp = temp.getLeftNode();
            }
            if (stack.empty()) {
                return;
            }
            temp = stack.pop();
            if (!stack.empty() && stack.peek() == temp) {
                temp = temp.getRightNode();
            } else {
                System.out.print(" [" + temp.getName() + "]");
                temp = null;
            }
        }
    }

    // * utils */
    private void printStack(Stack<Node> s) {
        if (s.isEmpty())
            return;
        Node x = s.peek();
        s.pop();
        printStack(s);
        System.out.print("(" + x.getName() + ") ");
        s.push(x);
    }

}
