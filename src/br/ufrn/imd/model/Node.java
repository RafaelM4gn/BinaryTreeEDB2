package br.ufrn.imd.model;

public class Node {
    // * Attributes */
    private String name;
    private int height;
    private int key;

    private Node leftNode;
    private boolean leftThread;

    private Node rightNode;
    private boolean rightThread;

    // * Constructors */
    public Node(int key, String name, Node leftNode, Boolean leftThread, Node rightNode, boolean rightThread) {
        this.key = key;
        this.name = name;
        this.leftNode = leftNode;
        this.leftThread = leftThread;
        this.rightNode = rightNode;
        this.rightThread = rightThread;
    }

    public Node(int key, String name, Node leftNode, Node rightNode) {
        this.key = key;
        this.name = name;
        this.leftNode = leftNode;
        this.leftThread = false;
        this.rightNode = rightNode;
        this.rightThread = false;
    }

    // * Getters and Setters */

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public boolean isLeftThread() {
        return leftThread;
    }

    public void setLeftThread(boolean leftThread) {
        this.leftThread = leftThread;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isRightThread() {
        return rightThread;
    }

    public void setRightThread(boolean rightThread) {
        this.rightThread = rightThread;
    }

}
