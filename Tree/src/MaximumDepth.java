import java.util.ArrayList;
import java.util.List;

public class MaximumDepth {
	
	public static void main(String[] args) {
		List<Node> n= new ArrayList<>();
		//Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n.add(n3);
		n.add(n2);
		n.add(n4);
		Node root = new Node(1, n);
		
		n=new ArrayList<>();
		n.add(n5);
		n.add(n6);
		n3.children=n;
		n5.children =new ArrayList<>();
		n6.children =new ArrayList<>();
		n2.children =new ArrayList<>();
		n4.children =new ArrayList<>();
		//new Node(3,n);
		
		MaximumDepth m = new MaximumDepth();
		System.out.println(m.maxDepth(root));
		
	}
	
	public int maxDepth(Node root) {
        if(root==null) return 0;
        return findDepth(root, 1);
    }
    public int findDepth(Node root, int max){
        int i=max,j=max;
        if (root==null) return max;
        
        for(Node child:root.children){
            j=findDepth(child, i+1);
            if(j>=max) max=j;
        }
        return max;
    }
}
