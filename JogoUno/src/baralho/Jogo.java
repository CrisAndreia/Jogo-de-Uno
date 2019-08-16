package baralho;
import java.util.ArrayList;
import java.util.*;
import baralho.BaralhoDoJogo.*;

public class Jogo {

   public static int AZUL = 1;
    public static int VERMELHO = 2;
    public static int VERDE = 3;
    public static int AMARELO = 4;
    public static int TODAS = 5;

    public static int SEMACAO = 6;
    public static int INVERSAO = 7;
    public static int MAISDOIS = 8;
    public static int BLOQUEIA = 9;
    public static int MAISQUATRO = 10;
    public static int CURINGA = 11;

    public static int SEMNUMERO = 12;

    public static int NUMERICA = 13;
    public static int ACAO = 14;

    public static boolean ACHOU;

    public  ArrayList<Carta> CartasDaMesa = new ArrayList<Carta>();



    private Carta cartaVirada;
    private Jogador j1;
    private Jogador j2;
    private Jogador ganhador;
    private int qtdCartasMesa;

    private BaralhoDoJogo b = new BaralhoDoJogo();



    public Jogo(Jogador j1, Jogador j2) {
        this.j1 = j1;
        this.j2 = j2;
        b.CriarBaralho();
        b.distribuirCarta(j1);
        b.distribuirCarta(j2);
        addCartaMesa(b.CartaViradaMesa());
        setCartaVirada(b.CartaViradaMesa());
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

    public void setCartaVirada(Carta cartaVirada) {
        this.cartaVirada = cartaVirada;
    }

    public void setGanhador(Jogador ganhador) {
        this.ganhador = ganhador;
    }

    public Jogador getGanhador() {
        return ganhador;
    }

    public Carta getCartaVirada() {
        return cartaVirada;
    }

    public int ComparaInt(int c1, int cartaMesa){
        if (c1 == cartaMesa){
            return 0; // iguais
        }
        else{
            return 1; //diferentes;
        }
    }

    public int EscolheCarta ( Jogador j, Carta c1, Carta cartaMesa, int pos){
        if (ComparaInt(c1.getCor(), cartaMesa.getCor())==0){
            System.out.println("         [" +pos+"]");
            this.MostraCarta(c1);
            this.ACHOU = true;
        }
        else{
            if (ComparaInt(c1.getNumero(), cartaMesa.getNumero())==0 && (c1.getNumero()!= Carta.SEMNUMERO) && c1.getNumero()== Carta.NUMERICA) {
                System.out.println("         [" +pos+"]");
                this.MostraCarta(c1);
                this.ACHOU = true;
            }
            else if (ComparaInt(c1.getAcao(), cartaMesa.getAcao())==0 && c1.getAcao()!= Carta.SEMACAO){
                System.out.println("         [" +pos+"]");
                this.MostraCarta(c1);
               this.ACHOU=true;
            }
            else if(j.getQtdCartas()==0){
                this.Ganhador(j);
            }
            /*else if(this.ACHOU == false){
                System.out.println("Voce nao tem cartas compativeis...");
                System.out.println("Compre uma carta");
                /*this.compraCarta(j, b.tiraCarta());
                this.pula(j);
            }*/
         }
        return 0;

    }


     public void addCartaMesa(Carta c){
        this.CartasDaMesa.add(c);
     }

     public void MostraCarta(Carta c){
         System.out.println("========Carta========");
         System.out.println("Nome: " + c.getNomes(c));
         if(c.getNome()==13) {//numerica
             System.out.println("Numero: " + c.getNumero());
         }
         else{
             System.out.println("Numero: " + c.getNums(c));
             System.out.println("Acao: " + c.getAcoes());
         }
         System.out.println("Cor: " +  c.getCors(c));
         System.out.println("=====================");
     }


    public boolean fimDeJogo(){
        if (this.j1.getQtdCartas() == 0 || this.j2.getQtdCartas() == 0){
            return true;
        }else{
            return false;
        }
    }

   public void rodada(){
        while(!this.fimDeJogo()){
            this.Menu(j1);
            this.Menu(j2);
        }/*
        if (j1.getQtdCartas() == 0 ){
            setGanhador(j1);
        }
        else if (j2.getQtdCartas() == 0 ){
            setGanhador(j2);
        }
        System.out.println("Jogador " + this.getGanhador().getNome() + " ganhou");
*/
        }
   public void Ganhador(Jogador j){
       setGanhador(j);
       System.out.println("Jogador " + this.getGanhador().getNome() + " ganhou");
   }

   public void Menu(Jogador j){

       int i;

       Scanner s = new Scanner(System.in);

       this.vezDoJogador(j);

       //this.ACHOU = false;

       System.out.println("");
       System.out.println("*    CARTA VIRADA    *");
       this.MostraCarta(this.getCartaVirada());

        System.out.println(" ");
        System.out.println("Escolha uma carta para jogar: ");

        this.ACHOU=false;
        for (i=0; i<j.getQtdCartas();i++){
            EscolheCarta(j, j.getCartasDaMao(i), this.getCartaVirada(), i);
        }
       if(!this.ACHOU){
           System.out.println("Voce nao tem cartas compativeis...");
           System.out.println("Compre uma carta");

           this.compraCarta(j, b.tiraCarta());
           //this.pula(j);
           EscolheCarta(j, j.getCartasDaMao(i), this.getCartaVirada(), i);
       }


        int escolha = s.nextInt();


        j.setCartaescolhida(j.getCartasDaMao(escolha));
        CartasDaMesa.add(j.getCartaescolhida());
        this.qtdCartasMesa ++;
        this.setCartaVirada(j.getCartaescolhida());
        j.jogarCarta(j.getCartaescolhida());
        this.jogada(j);

        System.out.println(" ");
        System.out.println("    CARTA VIRADA");
       this.MostraCarta(this.getCartaVirada());

    }

    public void compraCarta(Jogador j, Carta c){
        //Carta c = b.getCartaCima();
        j.addCarta(c);
    }

    public void compraDuasCartas(Jogador j, Carta c){
        for(int i=0; i<2;i++){
            this.compraCarta(j, c);
        }
    }

    public void compraQuatroCartas(Jogador j, Carta c){
        for(int i=0; i<4;i++){
            this.compraCarta(j, c);
        }
    }

    public void jogada(Jogador j) {
        Carta c;
        c = j.getCartaescolhida();
        int a = c.getAcao();

        if (a == INVERSAO){
            this.reveza(j);
            this.rodada();
        }
        if ( a == MAISDOIS){

            compraDuasCartas(j, c);
        }
        if ( a == MAISQUATRO){
            compraQuatroCartas(j, c);
        }
        if ( a == BLOQUEIA){
            this.reveza(j);
            this.rodada();
        }
        if ( a == SEMACAO){
            vezDoJogador(j);
        }
    }

    public void vezDoJogador(Jogador j){

        System.out.println("=====================");
        System.out.println("|    " +j.getNome()+" "+j.getQtdCartas()+" cartas   |");
        System.out.println("=====================");
    }

    public void reveza(Jogador j){
        if(j!=this.j1){
            setJ2(this.j1);
            setJ1(j);
        }
    }

    public void pula(Jogador j){
        if (j == j1){
            setJ1(j2);
            setJ2(j);
        }
        else if (j == j2){
            setJ1(j2);
            setJ2(j);
        }
    }




}


