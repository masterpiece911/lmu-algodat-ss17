package CalcTree;

public class PlusOperator extends BinaryOperator{
	
	/**
	 * Erzeugt einen neuen Plus Operator mit den übergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public PlusOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt die Summe der Auswertung beider Nachfolger als Ergebnis zurück.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() + rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Plus Operators zurück.
	 */
	public String toString(){
		return "+";
	}
	
}
