/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author gel-2
 */
public class Tree<T> {
    
    TreeNode<T> root;
    
    public Tree(T content){
        root = new TreeNode(content);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
            
}
