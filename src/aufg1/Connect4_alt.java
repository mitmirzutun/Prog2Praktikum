package aufg1;
public class Connect4_alt {
	//Array pos saves the position of the tokens, with following assignment: pos[line][column]
    private char pos[][]=new char[8][8],empty='.',player1='X',player2='O';
    private boolean player1Turn=true;
    private boolean gameEnded=false;
    public static void main(String[] args) throws Exception {
        Connect4_alt m = new Connect4_alt();
    }
    public Connect4_alt() throws Exception {
    	this.start();
    }
    public void start() throws Exception {
    	// Initializes the pos array
        for (int line=0;line<8;line++)
            for (int column=0;column<8;column++)
                pos[line][column]=empty;
        gameEnded=false;
        // checks if the game has ended. If not, call game()
        while (!gameEnded)
            this.game();
    }
    private void game() throws Exception {
        display();
        if (gameEnded)
        	return;
        char c = (char)System.in.read();
        //Taking care in case there still are newline and carriagereturn over
        while(c=='\n'||c=='\r') {
            c = (char)System.in.read();
        }
        if (!('1'<=c&&c<='8')) {
        	//Case first character of input is not a valid row number
            if (c=='q'||c=='Q') { //Case if Player tries to quit
            	c=(char)System.in.read();
            	if (c!='\n'&&c!='\r') { //Oops.. the quitting is invalid input
            		System.out.println("Invalid Input");
            		do {
            			c = (char)System.in.read();
            		} while (c!='\n'||c!='\r');
            	}
                System.out.println("Quitting...");
                gameEnded=true;
                return;
            }
            System.out.println("Invalid Input");
            do {
                c=(char)System.in.read();
            } while(c!='\n'&&c!='\r');
            return;
        }
        {//Checks if the input is only an one digit long number
            char c_end = (char)System.in.read();
            if (c_end!='\n'&&c_end!='\r') {
                System.out.println("Invalid length");
                do {
                    c_end=(char)System.in.read();
                } while(c_end!='\n'&&c_end!='\r');
                return;
            }
        }
        if (pos[0][c-'1']!=empty) { //Oops... Someone tried to enter a token into a column that is already full
            System.out.println("Column full");
            return;
        }
        //Putting the token onto the top
        for (int line =7;line>=0;line--) 
            if (pos[line][c-'1']==empty) {
                pos[line][c-'1']=player1Turn?player1:player2;
                break;
            }
        //Other's players turn is right now;
        player1Turn=!player1Turn;
    }
    private void display() {
        System.out.print(this.toString());
    }
    public String toString() {
    	if (gameEnded)
    		return winner(); //*yawn* What are you doing here? Oh, you're trying to convert a finished game into a game? Here it is.
    	StringBuilder sb= new StringBuilder(200);
    	for (int i=1;i<=8;i++) { //Column numbers
    		sb.append(i);
    		sb.append(' ');
    	}
    	sb.append('\n');
    	//Inserting the game board data
    	for (int line=0;line<8;line++) {
    		for (int row=0;row<8;row++) {
    			sb.append(pos[line][row]);
    			sb.append(' ');
    		}
    		sb.append('\n');
    	}
    	//Column names
    	for (int i=1;i<=8;i++) {
    		sb.append(i);
    		sb.append(' ');
    	}
    	//Has the game already won?
    	String tmp=winner();
    	sb.append('\n');
    	if (gameEnded) {//The game has already won.
    		sb.append(tmp);
    		return sb.toString();
    	} //No, inserting Data about the current players' turn
    	sb.append("Turn of Player ");
    	sb.append(player1Turn?player1:player2);
    	sb.append("\n> ");
    	return sb.toString();
    }
    private String winner() {
    	{ //Does an empty cell exist?
    		boolean allFull=true;
    		for (int i=0;i<pos[0].length;i++) {
    			if (pos[0][i]==empty) {
    				allFull=false;
    			}
    		}
    		if (allFull) { //Nope
    			gameEnded=true;
    			return "Tie!";
    		}
    	}//Yes.
    	String pl1won,pl2won;
    	{ //creating the messages for the winner;
    		StringBuilder tmp = new StringBuilder(16);
    		tmp.append("Player ");
    		tmp.append(player1);
    		tmp.append(" won");
    		pl1won=tmp.toString();
    		tmp = new StringBuilder(16);
    		tmp.append("Player ");
    		tmp.append(player2);
    		tmp.append(" won");
    		pl2won=tmp.toString();
    	}
        for (int i=0;i<8;i++) {
            for (int j=0;j<5;j++) {
            	//checking horizontally if there are four equal tokens
                if (pos[i][j]==pos[i][j+1]&&
                        pos[i][j]==pos[i][j+2]&&
                        pos[i][j]==pos[i][j+3]&&
                        pos[i][j]!=empty) {
                    gameEnded=true;
                    return pos[i][j]==player1?pl1won:pl2won;
                } //checking vertically if there are fourr equal tokens
                if (pos[j][i]==pos[j+1][i]&&
                        pos[j][i]==pos[j+2][i]&&
                        pos[j][i]==pos[j+3][i]&&
                        pos[j][i]!='.') {
                    gameEnded=true;
                    return pos[j][i]==player1?pl1won:pl2won;
                }
            }
        }
        //Checking diagonally if there are four equal tokens
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (pos[i][j]==pos[i+1][j+1]&&
                        pos[i][j]==pos[i+2][j+2]&&
                        pos[i][j]==pos[i+3][j+3]&&
                        pos[i][j]!='.') {
                    gameEnded=true;
                    return pos[j][i]==player1?pl1won:pl2won;
                }
                if (pos[i+3][j]==pos[i+2][j+1]&&
                        pos[i+3][j]==pos[i+1][j+2]&&
                        pos[i+3][j]==pos[i][j+3]&&
                        pos[i+3][j]!='.') {
                    gameEnded=true;
                    return pos[j][i+3]==player1?pl1won:pl2won;
                }
            }
        }
        return null;
    }
}