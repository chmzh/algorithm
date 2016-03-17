package algorithm.tree.splay;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java 语言: 伸展树
 *
 * @author skywang
 * @date 2014/02/03
 */
public class SplayTreeTest {

    private static final int arr[] = {10,50,40,30,20,60};

    public static void main(String[] args){
        int i, ilen;
        SplayTree<Integer> tree1=new SplayTree<Integer>();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            tree1.insert(arr[i]);
        }
        FileOutputStream fos;
        FileInputStream fis;
        SplayTree<Integer> tree = null;
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"/abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(tree1);
	        
	        fis = new FileInputStream(System.getProperty("user.dir")+"/abc.txt");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        
	        tree = (SplayTree<Integer>) ois.readObject();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
        //ObjectInputStream ois = new ObjectInputStream
        
        
        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();

        System.out.println("== 最小值: "+ tree.minimum());
        System.out.println("== 最大值: "+ tree.maximum());
        System.out.println("== 树的详细信息: ");
        tree.print();

        i = 30;
        System.out.printf("\n== 旋转节点(%d)为根节点\n", i);
        tree.splay(i);
        System.out.printf("== 树的详细信息: \n");
        tree.print();

        // 销毁二叉树
        tree.clear();
    }
}
