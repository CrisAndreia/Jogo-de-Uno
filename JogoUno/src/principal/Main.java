package principal;
import baralho.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        System.out.println("===============================");
        System.out.println("*        JOGO DE UNO!         *");
        System.out.println("===============================");

        Jogador j1 = new Jogador("Cris");

        Jogador j2 = new Jogador("Bruna");

        Jogo j = new Jogo(j1, j2);


        j.rodada();



    }

}