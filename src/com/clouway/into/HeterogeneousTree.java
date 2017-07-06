package com.clouway.into;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class HeterogeneousTree<Object>{

    private class Node<Object>{
        //The key variable is used for sorting the tree
        private int key;
        private Object data;
        private Node<Object> leftChild, rightChild;
    }

    private Node<Object> root;

    /**
     * This method is used for adding a new element to the tree
     *
     * @param newKey contains the key of the new element
     * @param elementData contains the data of the new element
     */
    public void add(int newKey,Object elementData){

        Node<Object> newElement = new Node<>();
        newElement.data = elementData;
        newElement.key = newKey;

        if(root == null) root = newElement;
        else{
            //this focal element is the element that we are currently on in the iteration
            Node<Object> focalElement = root;

            Node<Object> newParent;

            while (true) {

                newParent = focalElement;

                if(newKey < focalElement.key){

                    focalElement = focalElement.leftChild;

                    if(focalElement == null){
                        newParent.leftChild = newElement;
                        return;
                    }

                }
                else if(newKey > focalElement.key){

                    focalElement = focalElement.rightChild;

                    if(focalElement == null){
                        newParent.rightChild = newElement;
                        return;
                    }

                }
                //this and the else if above prevent existing elements from entering the tree
                else return;

            }

        }

    }

    /**
     * This method utilises the printHelper to print all the elements
     * of the tree
     */
    public void printElements(){

        printHelper(root);

    }

    /**
     * This method is used to help make a recursion for the print
     *
     * @param focalElement is the current element we are on in the iteration
     */
    private void printHelper(Node<Object> focalElement){

        if(focalElement != null) {
            System.out.println(focalElement.data);

            printHelper(focalElement.leftChild);
            printHelper(focalElement.rightChild);
        }

    }

    /**
     * This method is used to check wether or not an element with a certain key
     * is part of the tree
     *
     * @param key is the key we are looking for
     * @return true if the element is present, flase if not
     */
    public boolean contains(int key){

        Node<Object> focalElement = root;

        while(focalElement.key != key){

            if(key < focalElement.key)
                focalElement = focalElement.leftChild;
            else if(key > focalElement.key)
                focalElement = focalElement.rightChild;

            if(focalElement == null)
                return false;

        }

        return true;

    }

}
