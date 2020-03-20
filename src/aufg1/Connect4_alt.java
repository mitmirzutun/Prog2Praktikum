package aufg1;
import java.io.IOException;
public class Connect4_alt {
    private char[][] pos=new char[8][8];
    private boolean player1=true;
    private boolean gameEnded=false;
    public static void main(String[] args) throws IOException {
        Connect4_alt m = new Connect4_alt();
        m.start();
    }
    public void start() throws IOException {
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++)
                pos[i][j]='.';
        while (!gameEnded)
            this.game();
    }
    private void game() throws IOException {
        display();
        char c = (char)System.in.read();
        while(c=='\n'||c=='\r') {
            c = (char)System.in.read();
        }
        if (!('1'<=c&&c<='8')) {
            if (c=='q'||c=='Q') {
                System.out.println("Quitting...");
                gameEnded=true;
                return;
            }
            System.out.println("Invalide Eingabe");
            do {
                c=(char)System.in.read();
            } while(c!='\n'&&c!='\r');
            return;
        }
        {
            char c_end = (char)System.in.read();
            if (c_end!='\n'&&c_end!='\r') {
                System.out.println("Invalide Länge");
                do {
                    c_end=(char)System.in.read();
                } while(c_end!='\n'&&c_end!='\r');
                return;
            }
        }
        if (pos[0][c-'1']!='.') {
            System.out.println("Reihe bereits voll");
            return;
        }
        for (int i =7;i>=0;i--) 
            if (pos[i][c-'1']=='.') {
                pos[i][c-'1']=player1?'O':'X';
                break;
            }
        this.winner();
        player1=!player1;
    }
    private void display() {
        for (int i=1;i<=8;i++)
            System.out.print(i+" ");
        System.out.println();
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++)
                System.out.print(pos[i][j]+" ");
            System.out.println();
        }
    }
    private void winner() {
        for (int i=0;i<8;i++) {
            for (int j=0;j<5;j++) {
                if (pos[i][j]==pos[i][j+1]&&
                        pos[i][j]==pos[i][j+2]&&
                        pos[i][j]==pos[i][j+3]&&
                        pos[i][j]!='.') {
                    this.display();
                    System.out.println((player1?"Player 1":"Player 2")+" won");
                    gameEnded=true;
                    return;
                }
                if (pos[j][i]==pos[j+1][i]&&
                        pos[j][i]==pos[j+2][i]&&
                        pos[j][i]==pos[j+3][i]&&
                        pos[j][i]!='.') {
                    this.display();
                    System.out.println((player1?"Player 1":"Player 2")+" won");
                    gameEnded=true;
                    return;
                }
            }
        }
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (pos[i][j]==pos[i+1][j+1]&&
                        pos[i][j]==pos[i+2][j+2]&&
                        pos[i][j]==pos[i+3][j+3]&&
                        pos[i][j]!='.') {
                    this.display();
                    System.out.println((player1?"Player 1":"Player 2")+" won");
                    gameEnded=true;
                    return;
                }
                if (pos[i+3][j]==pos[i+2][j+1]&&
                        pos[i+3][j]==pos[i+1][j+2]&&
                        pos[i+3][j]==pos[i][j+3]&&
                        pos[i+3][j]!='.') {
                    this.display();
                    System.out.println((player1?"Player 1":"Player 2")+" won");
                    gameEnded=true;
                    return;
                }
            }
        }
    }
}