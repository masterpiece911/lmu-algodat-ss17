import java.util.*;

public class Floyd {
	
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
		
		Integer[][] c2 = {
			//		    K  DO  HB  HH  KI   H   B  KS   L  FD  EF  DD   F   N  MA  SB   S   M
			/*  K */ {  0, 70,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 64,  0,  0,  0,  0,  0},
			/* DO */ { 70,  0,109,  0,  0, 98,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* HB */ {  0,109,  0, 55,  0, 59,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/* HH */ {  0,  0, 55,  0, 58, 75,102,  0,  0,  0,  0,  0, 70,  0,  0,  0,  0,  0},
			/* KI */ {  0,  0,  0, 58,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  H */ {  0, 98, 59, 75,  0,  0,114, 56,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  B */ {  0,  0,  0,102,  0,114,  0,  0, 76,  0,  0,  0,  0,  0,  0,  0,  0, 65},
			/* KS */ {  0,  0,  0,  0,  0, 56,  0,  0,  0, 30,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  L */ {  0,  0,  0,  0,  0,  0, 76,  0,  0,  0, 43, 64,  0,214,  0,  0,  0,  0},
			/* FD */ {  0,  0,  0,  0,  0,  0,  0, 30,  0,  0, 83,  0, 52, 88,  0,  0,  0,  0},
			/* EF */ {  0,  0,  0,  0,  0,  0,  0,  0, 43, 83,  0,  0,  0,  0,  0,  0,  0,  0},
			/* DD */ {  0,  0,  0,  0,  0,  0,  0,  0, 64,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			/*  F */ { 64,  0,  0,  0,  0,  0, 70,  0,  0, 52,  0,  0,  0,126, 37,  0,  0,  0},
			/*  N */ {  0,  0,  0,  0,  0,  0,  0,  0,214, 88,  0,  0,126,  0,  0,  0,  0, 70},
			/* MA */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 37,  0,  0, 78, 38,  0},
			/* SB */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 78,  0,  0,  0},
			/*  S */ {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 38,  0,  0,138},
			/*  M */ {  0,  0,  0, 75,  0,  0,  0,  0,  0,  0,  0,  0,  0, 70,  0,  0,138,  0}
		};
		c = c2;
		int n = orte.length;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(c[i][j] == 0 && i != j)
					c[i][j] = 10000;
				
		int[][] A = new int[n][n];
		int[][] P = new int[n][n];
			
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				A[i][j] = c[i][j]; P[i][j] = 0;
			}
			
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++){
					if(A[i][j] > A[i][k] + A[k][j]){
						A[i][j] = A[i][k] + A[k][j];
						P[i][j] = k;
					}
				}
			}
		}
		}
		
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < n; b++){
				System.out.print(A[a][b] + " ");
			}
			System.out.println();
		}
	}
}

/* OUTPUT:
0 70 179 234 292 168 282 146 242 116 199 306 64 190 101 179 139 260
70 0 109 164 222 98 212 154 288 184 267 352 134 260 171 249 209 330
179 109 0 55 113 59 157 115 233 145 228 297 197 233 234 312 272 303
234 164 55 0 58 75 102 131 178 161 221 242 213 249 250 328 288 319
292 222 113 58 0 133 160 189 236 219 279 300 271 307 308 386 346 377
168 98 59 75 133 0 114 56 190 86 169 254 138 174 175 253 213 244
282 212 157 102 160 114 0 170 76 200 119 140 252 288 289 367 327 358
146 154 115 131 189 56 170 0 156 30 113 220 82 118 119 197 157 188
242 288 233 178 236 190 76 156 0 126 43 64 178 214 215 293 253 284
116 184 145 161 219 86 200 30 126 0 83 190 52 88 89 167 127 158
199 267 228 221 279 169 119 113 43 83 0 107 135 171 172 250 210 241
306 352 297 242 300 254 140 220 64 190 107 0 242 278 279 357 317 348
64 134 197 213 271 138 252 82 178 52 135 242 0 126 37 115 75 196
190 260 233 249 307 174 288 118 214 88 171 278 126 0 163 241 201 70
101 171 234 250 308 175 289 119 215 89 172 279 37 163 0 78 38 176
179 249 312 328 386 253 367 197 293 167 250 357 115 241 78 0 116 254
139 209 272 288 346 213 327 157 253 127 210 317 75 201 38 116 0 138
260 330 303 319 377 244 358 188 284 158 241 348 196 70 176 254 138 0

Mit Fluege
0 70 179 234 292 168 134 146 210 116 199 274 64 190 101 179 139 199
70 0 109 164 222 98 204 154 280 184 267 344 134 260 171 249 209 269
179 109 0 55 113 59 157 115 233 145 228 297 125 233 162 240 200 222
134 164 55 0 58 75 102 131 178 122 205 242 70 196 107 185 145 167
192 222 113 58 0 133 160 189 236 180 263 300 128 254 165 243 203 225
168 98 59 75 133 0 114 56 190 86 169 254 138 174 175 253 213 179
236 212 157 102 160 114 0 170 76 200 119 140 172 135 209 287 203 65
146 154 115 131 189 56 152 0 156 30 113 220 82 118 119 197 157 188
242 288 233 178 236 190 76 156 0 126 43 64 178 211 215 293 253 141
116 184 145 161 219 86 122 30 126 0 83 190 52 88 89 167 127 158
199 267 228 221 279 169 119 113 43 83 0 107 135 171 172 250 210 184
306 352 297 242 300 254 140 220 64 190 107 0 242 275 279 357 317 205
64 134 197 172 230 138 70 82 146 52 135 210 0 126 37 115 75 135
190 260 200 145 203 174 196 118 214 88 171 278 126 0 163 241 201 70
101 171 234 209 267 175 107 119 183 89 172 247 37 163 0 78 38 172
179 249 312 287 345 253 185 197 261 167 250 325 115 241 78 0 116 250
139 209 268 213 271 213 145 157 221 127 210 285 75 201 38 116 0 138
209 239 130 75 133 150 177 188 253 158 241 317 145 70 176 254 138 0
*/