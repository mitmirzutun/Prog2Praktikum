package aufg1;
public class Connect4{
    private static boolean[][][] data = new boolean[8][8][2];
    //data[i][j][0] = true wenn token in Position vorhanden ist
    //data[i][j][1] = true wenn token von Player 1 ist
    //data[i][j][1] = false wenn token von Player 2 ist
    public static void main(String[] args) throws Exception {
        draw();
        while(true){
            player(1);
            draw();
            if(gameEnded()){
		    	System.out.println("Player 1 hat gewonnen");
		    	break;
	    	}
            player(2);
            draw();
            if(gameEnded()){
		    	System.out.println("Player 2 hat gewonnen");
		    	break;
	    	}
        }
    }
    private static void draw(){
        for (int a=7;a>=0  ;a-- ) {//Zeilen von 8 bis 0
            for (int b=0;b<=7  ;b++ ) {//Spalten von 0 bis 8
                if (data[a][b][0]){
                    if (data[a][b][1]) {
						System.out.print("[X]");
					}
                    else{
						System.out.print("[O]");
					}
                }
                else{
					System.out.print("[ ]");
				}
            }
            System.out.println();
        }
    }
    private static void player(int player)throws Exception{
        System.out.println("Player "+ player +" ist am Zug");
		System.out.println("Wähle Spalte 1-8");
		int input = System.in.read();
		while(System.in.read()!='\n'){}
		input -= 49;

		for (int a=7;a>=0  ;a-- ) {//Zeilen von 8 bis 0
			if (data[a][input][0] == true){
				data[a+1][input][0] = true;
				if (player == 1){data[a+1][input][1] = true;}
				else{data[a+1][input][1] = false;}
				return;
			}
		}
		data[0][input][0] = true;
		if (player == 1){data[0][input][1] = true;}
		else{data[0][input][1] = false;}
    }
    
    /**
    * Returns if the game has ended
    */
    public static boolean gameEnded() {
        if (!rowsEmpty())
        	return true;
        if (winner()==0)
        	return false;
        return true;
    }
    /**
    * Returns the Winner of the game.
    */
    public static byte winner() {
        for (int i=0;i<data.length;i++) {
        	for (int j=0;j+3<data.length;j++) {
        		if (!data[i][j+3][0])
        			continue;
        		if (data[i][j][1]==data[i][j+1][1]&&
        			data[i][j][1]==data[i][j+2][1]&&
        			data[i][j][1]==data[i][j+3][1]) {
        			return (byte)(data[i][j][1]?2:1);
        		}
        	}
        }
        for (int i=0;i+3<data.length;i++) {
        	for (int j=0;j<data.length;j++) {
        		if (!data[i+3][j][0])
        			continue;
        		if (data[i][j][1]==data[i+1][j][1]&&
            		data[i][j][1]==data[i+2][j][1]&&
            		data[i][j][1]==data[i+3][j][1]) {
        			return (byte)(data[i][j][1]?2:1);
        		}
        	}
        }
        for (int i=0;i+3<data.length;i++) {
        	for (int j=0;j+3<data.length;j++) {
        		if (!data[i][j][0]||!data[i+1][j+1][0]||!data[i+2][j+2][0]||!data[i+3][j+3][0])
        			continue;
        		if (data[i][j][1]==data[i+1][j+1][1]&&
                	data[i][j][1]==data[i+2][j+2][1]&&
                	data[i][j][1]==data[i+3][j+3][1]) {
            		return (byte)(data[i][j][1]?2:1);
            	}
        	}
        	for (int j=0;j+3<data.length;j++) {
        		if (!data[i][j+3][0]||!data[i+1][j+2][0]||!data[i+2][j+1][0]||!data[i+3][j][0])
        			continue;
        		if (data[i][j+3][1]==data[i+1][j+2][1]&&
                	data[i][j+3][1]==data[i+2][j+1][1]&&
                	data[i][j+3][1]==data[i+3][j][1]) {
            		return (byte)(data[i][j+3][1]?2:1);
            	}
        	}
        }
        return (byte)0;
    }
    private static boolean rowsEmpty() {

        for (int i=0;i<data.length;i++)
        	if (!data[i][7][0])
        		return true;
        return false;
    }
}