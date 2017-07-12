import java.util.*;

public class Dijkstra {
	
	public static void main(String[] args) {
		
		String[] orte = {"K", "DO", "HB", "HH", "KI", "H", "B", "KS", "L", "FD", "EF", "DD", "F", "N", "MA", "SB", "S", "M"};
		Integer[][] c = {
			//		    K  DO  HB  HH  KI   H   B  KS   L  FD  EF  DD   F   N  MA  SB   S   M
			/*  K */ {  0, 70,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 64,  0,  0,  0,  0,  0},
			/* DO */ { 70,  0,109,  0,  0, 98,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* HB */ {  0,109,  0, 55,  0, 59,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* HH */ {  0,  0, 55,  0, 58, 75,102,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* KI */ {  0,  0,  0, 58,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  H */ {  0, 98, 59, 75,  0,  0,114, 56,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  B */ {  0,  0,  0,102,  0,114,  0,  0, 76,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* KS */ {  0,  0,  0,  0,  0, 56,  0,  0,  0, 30,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  L */ {  0,  0,  0,  0,  0,  0, 76,  0,  0,  0, 43, 64,  0,214,  0,  0,  0,  0},
			/* FD */ {  0,  0,  0,  0,  0,  0,  0, 30,  0,  0, 83,  0, 52, 88,  0,  0,  0,  0},
			/* EF */ {  0,  0,  0,  0,  0,  0,  0,  0, 43, 83,  0,  0,  0,  0,  0,  0,  0,  0},
			/* DD */ {  0,  0,  0,  0,  0,  0,  0,  0, 64,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  F */ { 64,  0,  0,  0,  0,  0,  0,  0,  0, 52,  0,  0,  0,126, 37,  0,  0,  0},
			/*  N */ {  0,  0,  0,  0,  0,  0,  0,  0,214, 88,  0,  0,126,  0,  0,  0,  0, 70},
			/* MA */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 37,  0,  0, 78, 38,  0},
			/* SB */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 78,  0,  0,  0},
			/*  S */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 38,  0,  0,138},
			/*  M */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 70,  0,  0,138,  0}
		};
		
		int n = orte.length;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) 
				if(c[i][j] == 0 && i != j)
					c[i][j] = 10000;

		Set<Integer> V = new HashSet<Integer>();
		Set<Integer> S = new HashSet<Integer>();
		S.add(n-1);
		
		Integer[] D = new Integer[n];
		for(int i = 0; i < n; i++) {
			V.add(i);
				D[i] = c[n-1][i];
		}
		V.remove(n-1);
		
		while(V.size() > 0){
			int w = -1;
			int minimum = Integer.MAX_VALUE;
			for(Integer w2 : V) {
				if(D[w2] < minimum) {
					minimum = D[w2];
					w = w2;
				}
			}
			System.out.println(orte[w]);	
			S.add(w);
			V.remove(w);
			for(Integer v : V) {
				D[v] = Math.min(D[v],D[w]+c[w][v]);
			}
	
			
			for(int i = 0; i < n; i++) {
				System.out.print(D[i]+ ", ");
			}
			System.out.println();		
		}

		for(int i = 0; i < n; i++) {
			System.out.println(orte[n-1] + " -> " + orte[i] + ": " + D[i]);
		}
	}
}

/* OUTPUT:
M -> K: 260
M -> DO: 330
M -> HB: 303
M -> HH: 319
M -> KI: 377
M -> H: 244
M -> B: 358
M -> KS: 188
M -> L: 284
M -> FD: 158
M -> EF: 241
M -> DD: 348
M -> F: 196
M -> N: 70
M -> MA: 176
M -> SB: 254
M -> S: 138
M -> M: 0
*/