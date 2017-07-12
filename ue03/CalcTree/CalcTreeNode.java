package CalcTree;

/** 
 * Interface f�r Knoten des Operatorbaums 
 */

public interface CalcTreeNode {

	/**
	 * Wertet den Operatorbaum aus, der an diesem Knoten beginnt und gibt das Ergebnis zur�ck. 
	 * @return Ergebnis der Auswertung
	 */
	public int eval();
	
	/**
	 * Gibt den Operatorbaum als String in Preorder-Darstellung zur�ck.
	 * @return Preorder-Darstellung des Operatorbaums
	 */
	public String preOrderString();
	
	/**
	 * Gibt den Operatorbaum als String in Postorder-Darstellung zur�ck.
	 * @return Postorder-Darstellung des Operatorbaums
	 */
	public String postOrderString();
	
	/**
	 * Gibt den Operatorbaum als String in Inorder-Darstellung zur�ck.
	 * @return Inorder-Darstellung des Operatorbaums
	 */
	public String inOrderString();
		
}
