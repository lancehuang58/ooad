package tree;

import com.scalified.tree.TraversalAction;
import com.scalified.tree.TreeNode;

import java.util.Arrays;
import java.util.List;

public class TestAction implements TraversalAction<TreeNode<String>> {

    List<String> authNode;

    public TestAction(String... auth) {
        this.authNode = Arrays.asList(auth);
    }

    @Override
    public void perform(TreeNode<String> node) {

        if (!node.isRoot() && !authNode.contains(node.data())) {
            System.out.println("#not auth - "+node.data());
        }else{
            System.out.println("#auth - "+node.data());
            TreeNode<String> parent = node.parent();

            while(!parent.isRoot() && !authNode.contains(parent.data())){
                parent = parent.parent();
            }
            System.out.println(">>> "+parent.data());
        }
    }


    @Override
    public boolean isCompleted() {
        return false;
    }
}
