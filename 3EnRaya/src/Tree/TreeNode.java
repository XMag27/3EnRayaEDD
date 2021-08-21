/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gel-2
 */
public class TreeNode<T> {
    T content;
    List<Tree<T>> children;
    
    public TreeNode(T content){
        this.content = content;
        children = new ArrayList();
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }
    
    
    
}
