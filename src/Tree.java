import java.util.ArrayList;
import java.util.List;

/**
 * Created by arjun on 20/03/19.
 */
public class Tree {

    int[] inorder = new int[100];
    int[] preorder = new int[100];

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    Node root;

    Tree(){
        root = null;
    }

    void addNodeBT(int rootData, int childData, char child){
        if (root == null){
            root = new Node(rootData);
            if (child=='L'){
                root.left  = new Node(childData);
            }else {
                root.right = new Node(childData);
            }
        }
        else {
            Node t = findNode(root, rootData);
            if (t ==null) return;
            if (child=='L'){
                t.left  = new Node(childData);
            }else {
                t.right = new Node(childData);
            }
        }
    }

    /* serialize and de-serialize a binary tree */


    Node findNode(Node root, int data){
        if (root==null) return null;
        if (root.data == data) return root;
        Node node = findNode(root.left, data);
        if (node == null){
            node = findNode(root.right, data);
        }

        return node;

    }

    //Given a binary tree and 2 nodes n1 and n2, find the LCA(Lowest common ancestor) of them
    Node LCA(Node root, int n1,int n2)
    {
        if(n1==n2) return find(root, n1, null);
        if(root.data==n1 || root.data==n2) return root;

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        find(root, n1, a1);
        find(root, n2, a2);

        //System.out.println("data:"+n1+" path="+a1);
        //System.out.println("data:"+n2+" path="+a2);

        int i=a1.size()-1;
        int j = a2.size()-1;
        int result=-1;
        while(i>=0 && j>=0){
            int k1 = a1.get(i);
            int k2 = a2.get(j);
            if(k1==k2){
                result = k1;
            }
            i--;
            j--;
        }
        if(result >=0)
            return find(root, result, null);
        else return null;
    }



    Node find(Node root, int data, List<Integer> list){
        if(root==null) return null;
        if(root.data == data){
            add(root.data, list);
            return root;
        }
        Node node = find(root.left, data, list);
        if(node == null){
            node = find(root.right, data, list);
        }
        if(node != null){
            add(root.data, list);
            return node;
        }

        return null;
    }

    void add(int data, List<Integer> list){
        if(list != null) list.add(data);
    }

    //Given a binary tree and 2 nodes n1 and n2, find the min distance b/w them
    int findDist(Node root, int a, int b)
    {
        if (a==b) return 0;
        else {
            List<Integer> a1 = new ArrayList<>();
            List<Integer> a2 = new ArrayList<>();

            if (!findPath(root, a, a1) || !findPath(root, b, a2)){
                return -1;
            }

            int i=a1.size()-1;
            int j = a2.size()-1;
            int minDist = i+j;
            while(i>=0 && j>=0){
                int k1 = a1.get(i);
                int k2 = a2.get(j);
                if(k1==k2 && minDist > (i+j)){
                    minDist = i+j;
                }
                i--;
                j--;
            }

            return minDist;
        }


    }

    boolean findPath(Node root, int a, List<Integer> list){
        if (root==null) return false;
        if (root.data==a){
            list.add(root.data);
            return true;
        }

        if (findPath(root.left, a, list) || findPath(root.right, a, list)){
            list.add(root.data);
            return true;
        }

        return false;
    }

    public static void main(String a[]){
        Tree bt = new Tree();
        //0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  7 15 L 7 16 R  8 17 L 8 18 R  9 19 L 9 20 R  10 21 L 10 22 R  11 23 L 11 24 R  12 25 L 12 26 R  13 27 L 13 28 R  14 29 L 14 30 R
        bt.addNodeBT(0,1,'L');
        bt.addNodeBT(0,2,'R');
        bt.addNodeBT(1,3,'L');
        bt.addNodeBT(1,4,'R');
        bt.addNodeBT(2,5,'L');
        bt.addNodeBT(2,6,'R');
        bt.addNodeBT(3,7,'L');
        bt.addNodeBT(3,8,'R');
        bt.addNodeBT(4,9,'L');
        bt.addNodeBT(4,10,'R');
        bt.addNodeBT(5,11,'L');
        bt.addNodeBT(5,12,'R');
        bt.addNodeBT(6,13,'L');
        bt.addNodeBT(6,14,'R');
        bt.addNodeBT(7,15,'L');
        bt.addNodeBT(7,16,'R');
        bt.addNodeBT(8,17,'L');
        bt.addNodeBT(8,18,'R');

        bt.addNodeBT(9,19,'L');
        bt.addNodeBT(9,20,'R');
        bt.addNodeBT(10,21,'L');
        bt.addNodeBT(10,22,'R');
        bt.addNodeBT(11,23,'L');
        bt.addNodeBT(11,24,'R');
        bt.addNodeBT(12,25,'L');
        bt.addNodeBT(12,26,'R');
        bt.addNodeBT(13,27,'L');
        bt.addNodeBT(13,28,'R');
        bt.addNodeBT(14,29,'L');
        bt.addNodeBT(14,30,'R');

        Node node = bt.LCA(bt.root, 11,29);
        System.out.println("LCA of 11 and 29="+node.data);
        System.out.println("Min distance b/w 11 and 29="+bt.findDist(bt.root, 11,29));


    }
}
