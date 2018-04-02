package com.interview.technical.codility;

public class BinaryTree
{
    int count = 0;
    int root = 0;
    public int solution(Tree T) 
    {
        
        // write your code in Java SE 8
        if (T == null)
        {
            System.out.println("The tree is null");
        }
        root = T.x;
        count++;
        traverse(T);
        return count;
    }
    
    public void traverse (Tree T){ // Each child of a tree is a root of its subtree.
        if (T.l != null){
            if (T.l.x >= root) {
                count++;
            }
            traverse (T.l);
        }
        if (T.r != null){
            if (T.r.x >= root) {
                count++;
            }
            traverse (T.r);
        }
    }

}

class Tree
{
    public int  x;
    public Tree l;
    public Tree r;
}
