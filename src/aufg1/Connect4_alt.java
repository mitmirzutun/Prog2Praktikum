package aufg1;
public class Connect4_alt {
    private char pos[][]=new char[8][8],empty='.',player1='X',player2='O';
    private boolean player1Turn=true;
    private boolean gameEnded=false;
    public static void main(String[] args) throws Exception {
        Connect4_alt m = new Connect4_alt();
        m.start();
    }
    public void start() throws Exception {
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++)
                pos[i][j]=empty;
        gameEnded=false;
        while (!gameEnded)
            this.game();
    }
    private void game() throws Exception {
        display();
        if (gameEnded)
        	return;
        char c = (char)System.in.read();
        while(c=='\n'||c=='\r') {
            c = (char)System.in.read();
        }
        if (!('1'<=c&&c<='8')) {
            if (c=='q'||c=='Q') {
            	c=(char)System.in.read();
            	if (c!='\n'&&c!='\r') {
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
        {
            char c_end = (char)System.in.read();
            if (c_end!='\n'&&c_end!='\r') {
                System.out.println("Invalid length");
                do {
                    c_end=(char)System.in.read();
                } while(c_end!='\n'&&c_end!='\r');
                return;
            }
        }
        if (pos[0][c-'1']!=empty) {
            System.out.println("Column full");
            return;
        }
        for (int i =7;i>=0;i--) 
            if (pos[i][c-'1']==empty) {
                pos[i][c-'1']=player1Turn?player1:player2;
                break;
            }
        player1Turn=!player1Turn;
    }
    private void display() {
        System.out.print(this.toString());
    }
    public String toString() {
    	if (gameEnded)
    		return winner();
    	StringBuilder sb= new StringBuilder(200);
    	for (int i=1;i<=8;i++) {
    		sb.append(i);
    		sb.append(' ');
    	}
    	sb.append('\n');
    	for (int i=0;i<8;i++) {
    		for (int j=0;j<8;j++) {
    			sb.append(pos[i][j]);
    			sb.append(' ');
    		}
    		sb.append('\n');
    	}
    	for (int i=1;i<=8;i++) {
    		sb.append(i);
    		sb.append(' ');
    	}
    	String tmp=winner();
    	sb.append('\n');
    	if (gameEnded) {
    		sb.append(tmp);
    		return sb.toString();
    	}
    	sb.append("Turn of Player ");
    	sb.append(player1Turn?player1:player2);
    	sb.append('\n');
    	sb.append('>');
    	return sb.toString();
    }
    private String winner() {
    	{
    		boolean allFull=true;
    		for (int i=0;i<pos[0].length;i++) {
    			if (pos[0][i]==empty) {
    				allFull=false;
    			}
    		}
    		if (allFull) {
    			gameEnded=true;
    			return "Tie!";
    		}
    	}
    	String pl1won,pl2won;
    	{
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
                if (pos[i][j]==pos[i][j+1]&&
                        pos[i][j]==pos[i][j+2]&&
                        pos[i][j]==pos[i][j+3]&&
                        pos[i][j]!=empty) {
                    gameEnded=true;
                    return pos[i][j]==player1?pl1won:pl2won;
                }
                if (pos[j][i]==pos[j+1][i]&&
                        pos[j][i]==pos[j+2][i]&&
                        pos[j][i]==pos[j+3][i]&&
                        pos[j][i]!='.') {
                    gameEnded=true;
                    return pos[j][i]==player1?pl1won:pl2won;
                }
            }
        }
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
        return "Tie!";
    }
}