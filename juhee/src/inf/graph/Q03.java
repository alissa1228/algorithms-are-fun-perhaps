package inf.graph;

/**
 * 이진트리 순회(깊이우선탐색)
 */
public class Q03 {
    static void preorderTraversal(Node tree) {
        if (tree.lt == null && tree.rt == null) System.out.print(tree.data + " ");
        else {
            System.out.print(tree.data + " ");
            preorderTraversal(tree.lt);
            preorderTraversal(tree.rt);
        }
    }
    static void inoderTraversal(Node tree) {
        if (tree.lt == null && tree.rt == null) System.out.print(tree.data + " ");
        else {
            inoderTraversal(tree.lt);
            System.out.print(tree.data + " ");
            inoderTraversal(tree.rt);
        }
    }
    static void postOrderTraversal(Node tree) {
        if (tree.lt == null && tree.rt == null) System.out.print(tree.data + " ");
        else {
            postOrderTraversal(tree.lt);
            postOrderTraversal(tree.rt);
            System.out.print(tree.data + " ");
        }
    }
    public static void main(String[] args){
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);
        preorderTraversal(tree);
        System.out.println();
        inoderTraversal(tree);
        System.out.println();
        postOrderTraversal(tree);
        System.out.println();
    }
}
