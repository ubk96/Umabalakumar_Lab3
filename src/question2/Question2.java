package question2;

import java.util.ArrayList;
import java.util.Scanner; 


class Node { 
   
 int data; 
 Node left, right; 
   
 Node(int d) { 
     data = d; 
     left = right = null; 
 } 
} 

class BinarySearchTree 
{ 
   

 Node root; 


 BinarySearchTree() {  
     root = null;  
 } 
   

 void inorder() 
 { 
     inorderUtil(this.root); 
 } 
   
 
 void inorderUtil(Node node) 
 { 
     if(node == null) 
         return; 
       
     inorderUtil(node.left); 
     System.out.print(node.data + " "); 
     inorderUtil(node.right); 
 } 
   
 
 void insert(int key) { 
 root = insertRec(root, key); 
 } 
   

 Node insertRec(Node root, int data) { 


     if (root == null) { 
         root = new Node(data); 
         return root; 
     } 


     if (data < root.data) 
         root.left = insertRec(root.left, data); 
     else if (data > root.data) 
         root.right = insertRec(root.right, data); 

     return root; 
 } 
   
 
 ArrayList<Integer> treeToList(Node node, ArrayList<Integer> 
                                                   list) 
 {      
     // Base Case 
     if(node == null) 
         return list; 
       
     treeToList(node.left, list); 
     list.add(node.data); 
     treeToList(node.right, list); 
       
     return list; 
 } 
   

 boolean isPairPresent(Node node, int target) 
 {    

     ArrayList<Integer>a1 = new ArrayList<>();  
       

     ArrayList<Integer> a2 = treeToList(node, a1);  
       
     int start = 0; // Starting index of a2 
       
     int end = a2.size() - 1; // Ending index of a2 

     while(start < end) 
     { 
       
     if(a2.get(start) + a2.get(end) == target) // Target Found! 
     { 
         System.out.println("Pair Found: "+a2.get(start)+ 
                   " + "+a2.get(end)+" " + "= "+ target); 
         return true; 
     } 
       
     if(a2.get(start) + a2.get(end)>target) // decrements end 
     { 
         end--; 
     } 
       
     if(a2.get(start) + a2.get(end)<target) // increments start 
     { 
         start++; 
     } 
 } 

     System.out.println("No such values are found!"); 
     return false; 
 } 
       

 public static void main(String[] args) { 
     BinarySearchTree tree = new BinarySearchTree(); 
     try(Scanner sc = new Scanner(System.in)){
    	 System.out.println("Sum = ");
    	 int sum = sc.nextInt();
     
	     tree.insert(40); 
	     tree.insert(20); 
	     tree.insert(60); 
	     tree.insert(10); 
	     tree.insert(30); 
	     tree.insert(50); 
	     tree.insert(70); 

	     tree.isPairPresent(tree.root, sum); 
     } 
 }
} 