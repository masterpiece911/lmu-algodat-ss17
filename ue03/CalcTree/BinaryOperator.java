package CalcTree;

/**
 * Abstrakte Klasse für Knoten die binären Operatoren representieren. 
 * Binäre Operator Knoten sind Knoten mit zwei Nachfolgern.
 */

public abstract class BinaryOperator implements CalcTreeNode{

	protected CalcTreeNode leftChild;
	protected CalcTreeNode rightChild;
	
	/**
	 * Konstruktor, der einen neuen Binären Operator erstellt. 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public BinaryOperator(CalcTreeNode left, CalcTreeNode right){
		this.leftChild = left;
		this.rightChild = right;
	}
	
	/**
	 * @see CalcTreeNode.postOrderString()
	 */
	public String postOrderString(){
		return leftChild.postOrderString() + " " + rightChild.postOrderString() + " " + this.toString();  
	}
	
	/**
	 * @see CalcTreeNode.preOrderString()
	 */
	public String preOrderString(){
		return this.toString() + " " + leftChild.preOrderString() + " " + rightChild.preOrderString() + " ";  
	}
	
	/**
	 * @see CalcTreeNode.inOrderString()
	 */
	public String inOrderString(){
		return leftChild.inOrderString() + " " + this.toString() + " " + rightChild.inOrderString();  
	}
}
