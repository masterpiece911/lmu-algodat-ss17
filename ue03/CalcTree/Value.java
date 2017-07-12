package CalcTree;

public class Value implements CalcTreeNode {

	private int value;
	
	/**
	 * Erzeugt einen neuen Wert-Knoten mit dem �bergebenen Wert.
	 * 
	 * @param value der Wert des Knoten
	 */
	public Value(int value){
		this.value = value;
	}
	
	/**
	 * Gibt den Wert des Knotens als Ergebniss der Auswertung zur�ck.
	 * 
	 * @return Der Wert des Knotens
	 */
	public int eval() {
		return value;
	}

	/**
	 * @see CalcTreeNode.inOrderString()
	 */
	public String inOrderString() {
		return this.toString();
	}

	/**
	 * @see CalcTreeNode.postOrderString()
	 */
	public String postOrderString() {
		return this.toString();
	}

	/**
	 * @see CalcTreeNode.preOrderString()
	 */
	public String preOrderString() {
		return this.toString();
	}

	/**
	 * Gibt die Stringrepresentation des Wertes zur�ck.
	 */
	public String toString(){
		return Integer.toString(value);
	}
}
