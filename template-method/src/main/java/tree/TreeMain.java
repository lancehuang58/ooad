package tree;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;

import java.util.List;


public class TreeMain {

    public TreeNode<String> buildTree() {
        TreeNode<String> node = new ArrayMultiTreeNode<>("root");
        ArrayMultiTreeNode<String> node1 = new ArrayMultiTreeNode<>("1");
        ArrayMultiTreeNode<String> node11 = new ArrayMultiTreeNode<>("1-1");
        node1.add(node11);
        ArrayMultiTreeNode<String> node12 = new ArrayMultiTreeNode<>("1-2");
        node1.add(node12);
        ArrayMultiTreeNode<String> node2 = new ArrayMultiTreeNode<>("2");

        ArrayMultiTreeNode<String> node21 = new ArrayMultiTreeNode<>("2-1");
        node2.add(node21);
        ArrayMultiTreeNode<String> node22 = new ArrayMultiTreeNode<>("2-2");
        node2.add(node22);

        ArrayMultiTreeNode<String> node3 = new ArrayMultiTreeNode<>("3");
        ArrayMultiTreeNode<String> node31 = new ArrayMultiTreeNode<>("3-1");
        node3.add(node31);
        ArrayMultiTreeNode<String> node32 = new ArrayMultiTreeNode<>("3-2");
        node3.add(node32);
        node.add(node1);
        node.add(node2);
        node.add(node3);
        return node;
    }

    public static void main(String[] args) {

        TreeMain main = new TreeMain();
        TreeNode<String> root = main.buildTree();
        System.out.println(root);
        System.out.println("----");
        TestAction action = new TestAction("3-1", "2-2");
        root.traversePostOrder(action);

        System.out.println(root);
    }
}
