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