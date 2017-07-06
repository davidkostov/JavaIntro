package com.clouway.into;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class App {
  
  public static void main(String[] args) {

    int a = 2, b = 3;
    Sumator sumator = new Sumator();
    System.out.println(sumator.sum(a,b));

    //added test for the tree
    HeterogeneousTree tree = new HeterogeneousTree();
    tree.add(101,10);
    tree.add(20, 2.5);
    tree.add(405,"asd");
    tree.add(55, '&');
    tree.printElements();
    if(tree.contains(20)) System.out.println("Yes!");
    if(tree.contains(25)) System.out.println("Yes again!");
  }
}
