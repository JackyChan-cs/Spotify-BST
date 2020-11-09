import java.util.Queue;
import java.util.*;
class Tree
{
    // Root of Binary Tree 
    Song root;

    // Constructors 
    Tree(String title, String artist, String streams){
        root = new Song(title, artist, streams);
    }

    public Song getFirst(){return root;}

    public void insert(Song head){

//        Song node = new Song(song);
        if(root == null){

        }
//        else {
//            Song node = root;
//            node.next = root;
//        }
        else{

            while(true){
                root = head;
                //add node to left child
                if(head.getTitle().compareTo(root.getTitle()) <= 0 ){       //compares the string values and chooses the smaller one
                    head = head.left;

                    if(root ==null){
                        head.left = root;
                        return;
                    }
                    //add node to right child
                }else if(head.getTitle().compareTo(root.getTitle()) > 0){       //sorts the nodes alphabetically
                    head = head.right;

                    if(root == null){
                        head.right = root;
                        return;
                    }
                }
            }
        }
    }

    public void display(Song root){                                 //displays BST
        Song node = root;

        if(node == null) {
            System.out.println("None");
        }
        System.out.println(root.getTitle() + ", " + root.getArtist() + ", " + root.getStreams());
        if(node.left != null){              //iterates through the entire BST
            display(root.left);
        }

        if(node.right != null){
            display(root.right);
        }
    }

    Tree(){
        root = null;
    }

} 