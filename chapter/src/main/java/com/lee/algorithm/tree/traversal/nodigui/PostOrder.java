package com.lee.algorithm.tree.traversal.nodigui;

import com.lee.algorithm.tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方式实现二叉树的后序遍历
 * <p>
 * 后续遍历的非递归实现思路如下:
 * 1.根节点入栈
 * 2.将根节点的左子树入栈，直到最左，没有左孩子为止
 * 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右孩子，如果存在并且没有被访问，则将右孩子入栈，否则，就访问栈顶元素
 *
 * @author lee
 * @date 2020/3/23 21:44
 */
public class PostOrder {
    /**
     * 构建一颗二叉树(完全二叉树)
     *
     * @return
     */
    private static TreeNode buildTree() {
        TreeNode[] treeNodes = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            TreeNode treeNode = new TreeNode(i + 1);
            treeNodes[i] = treeNode;
        }
        TreeNode root = treeNodes[0];
        // 将顺序存储的二叉树转换为链式存储
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) treeNodes[i].lChild = treeNodes[i * 2 + 1];
            if (i * 2 + 2 < 10) treeNodes[i].rChild = treeNodes[i * 2 + 2];
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode bTree = buildTree();
        List<Integer> pre = post(bTree);
        pre.forEach(c -> System.out.print(c + ","));
//        post2(bTree);

    }

    public static List<Integer> post(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;
        TreeNode pre = null;

        while (temp != null || !stack.empty()) {
            // 将根节点及其左孩子入栈
            while (temp != null) {
                stack.push(temp);
                temp = temp.lChild;
            }

            if (!stack.empty()) {
                // 获取栈顶元素值
                temp = stack.peek();
                if (temp.rChild == null || temp.rChild == pre) {
                    temp = stack.pop();
                    result.add(temp.value);
                    pre = temp;
                    temp = null;
                } else {
                    temp = temp.rChild;
                }
            }

        }

        return result;
    }

    public static void post2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode pre = null;
        while(temp != null || !stack.empty()) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.lChild;
            }
            if (!stack.empty()){
                temp = stack.peek();
                if(temp.rChild == null || temp.rChild == pre) {
                    temp = stack.pop();
                    System.out.print(temp.value + ",");
                    pre = temp;
                    temp = null;
                }else{
                    temp = temp.rChild;
                }
            }
        }
    }
}
