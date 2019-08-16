package baralho;

import java.util.ArrayList;
import java.util.*;
import baralho.Carta;
import java.util.Random;

public class BaralhoDoJogo {
    private ArrayList<Carta> BaralhoDoJogo = new ArrayList<Carta>();
    private Carta cartaCima;
    private Carta cartaDist;
    private int qtdCartas;

    public void maisQtdCartas() {
        this.qtdCartas++;
    }

    public void menosQtdCartas() {
        this.qtdCartas--;
    }

    public int getQtdCartas() {
        return qtdCartas;
    }

    public void setCartaDist(Carta cartaDist) {
        this.cartaDist = cartaDist;
    }

    /*public void setCartaCima(Carta cartaCima) {
        this.cartaCima = cartaCima;
    }*/

    public Carta tiraCarta(){
        //Carta c = this.cartaCima;
        return this.BaralhoDoJogo.remove(0);
        //return c;
   }

   public void addCartaBaralho(Carta c){
       this.BaralhoDoJogo.add(c);
   }

   public void CriarBaralho(){
        this.criarCartaNumerica();
        this.criarCartaBloqueia();
        this.criarCartaCuringa();
        this.criarCartaInverte();
        this.criarCartaMaisDois();
        this.criarCartaMaisQuatro();
   }

    public void criarCartaNumerica() {
        int i, j;
        for (j = 1; j < 5; j++) {
            for (i = 0; i < 10; i++) {
                Carta c = new Carta();
                c.setNome(c.NUMERICA);
                c.setNumero(i);
                c.setCor(j);
                c.setAcao(c.SEMACAO);
                c.qualAcao(c);
                c.qualCor(c);
                c.qualNome(c);
                c.qualNumero(c);

                this.BaralhoDoJogo.add(c);
                this.setCartaCima(c);
                this.maisQtdCartas();
            }
        }
    }

    public void criarCartaBloqueia() {
        int j;
        for (j = 1; j < 5; j++) {
                Carta c = new Carta();
                c.setNome(c.ACAO);
                c.setNumero(c.SEMNUMERO);
                c.setCor(j);
                c.setAcao(c.BLOQUEIA);
                c.qualAcao(c);
                c.qualCor(c);
                c.qualNome(c);
                c.qualNumero(c);

                this.BaralhoDoJogo.add(c);
                this.setCartaCima(c);
                this.maisQtdCartas();
            }
        }

    public void criarCartaInverte() {
        int j;
        for (j = 1; j < 5; j++) {
            Carta c = new Carta();
            c.setNome(c.ACAO);
            c.setNumero(c.SEMNUMERO);
            c.setCor(j);
            c.setAcao(c.INVERSAO);
            c.qualAcao(c);
            c.qualCor(c);
            c.qualNome(c);
            c.qualNumero(c);

            this.BaralhoDoJogo.add(c);
            this.setCartaCima(c);
            this.maisQtdCartas();
        }
    }

    public void criarCartaMaisDois() {
        int j;
        for (j = 1; j < 5; j++) {
            Carta c = new Carta();
            c.setNome(c.ACAO);
            c.setNumero(c.SEMNUMERO);
            c.setCor(j);
            c.setAcao(c.MAISDOIS);
            c.qualAcao(c);
            c.qualCor(c);
            c.qualNome(c);
            c.qualNumero(c);

            this.BaralhoDoJogo.add(c);
            this.setCartaCima(c);
            this.maisQtdCartas();
        }
    }
    public void criarCartaMaisQuatro() {
        int j;
        for (j = 1; j < 5; j++) {
            Carta c = new Carta();
            c.setNome(c.ACAO);
            c.setNumero(c.SEMNUMERO);
            c.setCor(c.TODAS); // aplicar na curinga
            c.setAcao(c.MAISQUATRO);
            c.qualAcao(c);
            c.qualCor(c);
            c.qualNome(c);
            c.qualNumero(c);

            this.BaralhoDoJogo.add(c);
            this.setCartaCima(c);
            this.maisQtdCartas();
        }
    }

    public void criarCartaCuringa() {
        int j;
        for (j = 1; j < 5; j++) {
            Carta c = new Carta();
            c.setNome(c.ACAO);
            c.setNumero(c.SEMNUMERO);
            c.setCor(c.TODAS);
            c.setAcao(c.CURINGA);
            c.qualAcao(c);
            c.qualCor(c);
            c.qualNome(c);
            c.qualNumero(c);

            this.BaralhoDoJogo.add(c);
            this.setCartaCima(c);
            this.maisQtdCartas();
        }
    }




    public void distribuirCarta(Jogador j){
        int x, i;

        for(i=0;i<8;i++) {
            Random random = new Random();
            x = random.nextInt(this.qtdCartas);
            this.cartaDist = (Carta) this.BaralhoDoJogo.get(x);
            this.BaralhoDoJogo.remove(x);
            this.menosQtdCartas();
            j.addCarta(this.cartaDist);
        }
    }


    public Carta CartaViradaMesa(){
        int x;
        Random random = new Random();
        x = random.nextInt(this.qtdCartas);
        this.setCartaDist((Carta) this.BaralhoDoJogo.get(x));
        this.BaralhoDoJogo.remove(x);
        this.menosQtdCartas();
        return this.cartaDist;
    }

    public Carta getCartaCima() {
        return this.BaralhoDoJogo.get(this.qtdCartas);
    }

    public void setCartaCima(Carta cartaCima) {
        this.cartaCima = cartaCima;
    }
}


