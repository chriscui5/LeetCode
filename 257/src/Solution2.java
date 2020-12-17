import java.util.ArrayList;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/4
 * @description:
 * @version:1.0
 */
public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if(root!=null){
            StringBuffer pathSB=new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if(root.left==null&&root.right==null){
                paths.add(pathSB.toString());
            }
            else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }


        }
    }

}
