
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roma
 */
public class MainGame {
     private String[][] field = {{" "," "," "},{" "," "," "},{" "," "," "}};
     private final Scanner sn = new Scanner(System.in);
     private String winner = "";
     private int boardleft=9;
    
     void awal(){
        System.out.println("PETUNJUK :\n");
        System.out.println("Arena bermain yang akan digunakan sebagai berikut");
        System.out.println("1|2|3\n4|5|6\n7|8|9");
        System.out.println("Cukup masukkan angka yang akan dimasukkan tanda");

        String answer = "";
        while(!(answer.toLowerCase().equals("y")||answer.toLowerCase().equals("n"))){
            System.out.print("Apakah anda mengerti?(y/n)");
            answer = sn.nextLine();
        }
        if(answer.toLowerCase().equals("y")){
            game();
        }else if(answer.toLowerCase().equals("n")){
            
        }
    }
    
     private boolean pcChoice(){
        Random r = new Random();
        int choice = r.nextInt(9);
        int row = choice/3;
        int col = choice-(3*row);
        if(!field[row][col].equals(" ")){
            return false;
        }
        field[row][col]="X";
        return true;
    }
    
     private void pcTurn(){
        while(!pcChoice()){
            
        }
        boardleft--;
        cetakBoard();
    }
    
     private void cetakBoard(){
        System.out.flush();
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                System.out.print(" "+field[x][y]+" ");
                if(y<2){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    
     private boolean checkWin(){
        if((field[0][0].equals(field[0][1])&&field[0][0].equals(field[0][2])))
        {
            if(!field[0][0].equals((" "))&&!field[0][1].equals((" "))&&!field[0][0].equals((" "))){
                winner = field[0][0];
                return true;
            }
        }
        else if(field[1][0].equals(field[1][1])&&field[1][0].equals(field[1][2])){
            if(!field[1][0].equals((" "))&&!field[1][1].equals((" "))&&!field[1][2].equals((" "))){
                winner = field[1][0];
                return true;
            }
        }
        else if(field[2][0].equals(field[2][1])&&field[2][0].equals(field[2][2])){
            if(!field[2][0].equals((" "))&&!field[2][1].equals((" "))&&!field[2][2].equals((" "))){
                winner = field[2][0];
                return true;
            }
        }
        else if(field[0][0].equals(field[1][0])&&field[0][0].equals(field[2][0])){
            if(!field[0][0].equals((" "))&&!field[1][0].equals((" "))&&!field[2][0].equals((" "))){
                winner = field[0][0];
                return true;
            }
        }
        else if(field[0][1].equals(field[1][1])&&field[0][1].equals(field[2][1])){
            if(!field[0][1].equals((" "))&&!field[0][0].equals((" "))&&!field[0][0].equals((" "))){
                winner = field[0][1];
                return true;
            }
        }
        else if(field[0][2].equals(field[1][2])&&field[0][2].equals(field[2][2])){
            if(!field[0][2].equals((" "))&&!field[1][2].equals((" "))&&!field[2][2].equals((" "))){
                winner = field[0][2];
                return true;
            }
        }
        else if (field[0][0].equals(field[1][1])&&field[0][0].equals(field[2][2])){
            if(!field[0][0].equals((" "))&&!field[1][1].equals((" "))&&!field[2][2].equals((" "))){
                winner = field[1][1];
                return true;
            }
        }
        else if(field[0][2].equals(field[1][1])&&field[0][2].equals(field[2][0])){
            if(!field[0][2].equals((" "))&&!field[1][1].equals((" "))&&!field[2][0].equals((" "))){
                winner = field[1][1];
                return true;
            }
        }
        return false;
    }
    
     private void game(){
        cetakBoard();
        while(true){
            int row = 0;
            int col = 0;
            while(true){
                System.out.print("Silahkan masukkan angka petak yang ingin dipilih : ");
                int choice = sn.nextInt();
                row = (choice-1)/3;
                col = (choice-1)-(3*row);
                if(!field[row][col].equals(" ")){
                    System.out.println("Petak tersebut sudah diisi");
                }
                else{
                    break;
                }
            }
            field[row][col]="O";
            boardleft--;
            if(checkWin()||boardleft==0){
                break;
            }
            else{
                pcTurn();
            }
        }
        endGame();
    }
    
     private void endGame(){
        if(winner.equals("")){
            System.out.println("Sepertinya kita belum mendapatkan pemenang");
        }else{
            System.out.println(winner+" menang");
        }
    }
}
