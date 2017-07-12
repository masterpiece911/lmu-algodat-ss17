package CalcTree;

public class PlusOperator extends BinaryOperator{
	
	/**
	 * Erzeugt einen neuen Plus Operator mit den �bergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public PlusOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt die Summe der Auswertung beider Nachfolger als Ergebnis zur�ck.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() + rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Plus Operators zur�ck.
	 */
	public String toString(){
		return "+";
	}
	
}
