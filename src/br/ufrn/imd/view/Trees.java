package br.ufrn.imd.view;

import br.ufrn.imd.model.BinaryTree;

/**
 * Trees
 */
public class Trees {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("[DEPTH-FIRST SEARCH]");
        System.out.println("- Recursive methods");
        tree.depthFirst(0);
        tree.depthFirst(1);
        tree.depthFirst(2);

        System.out.println("- Iterative methods");
        tree.depthFirstIterative(0);
        tree.depthFirstIterative(1);
        tree.depthFirstIterative(2);
        System.out.println("[BREADTH-FIRST SEARCH]");
        System.out.println("- Iterative methods");
        tree.breadthFirst();
        System.out.println("[GENERATED HEIGHTS");
        System.out.println("- Recursive methods");
        tree.generateHeights();

        System.out.println("Trees");
    }
}