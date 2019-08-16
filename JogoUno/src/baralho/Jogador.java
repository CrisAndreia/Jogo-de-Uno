package baralho;

import java.util.ArrayList;

public class Jogador {



    private ArrayList<Carta> cartasDaMao = new ArrayList<Carta>();
    private String nome;
    private Carta cartaescolhida;
    private int qtdCartas=0;

    public Jogador(String nome){
        this.nome = nome;
    }

    public void addCarta(Carta c){
        this.cartasDaMao.add(c);
        this.qtdCartas++;

    }

    public void jogarCarta(Carta c){
        this.qtdCartas--;
        this.cartasDaMao.remove(c);
    }


    /*public void escolherCarta(){
        this.escolhida = this.cartas.remove(0);
    }*/


    public int getQtdCartas() {
        return this.cartasDaMao.size();
//        return qtdCartas;
    }

    public void setCartaescolhida(Carta cartaescolhida) {
        this.cartaescolhida = cartaescolhida;
    }

    public Carta getCartaescolhida() {
        return cartaescolhida;
    }

    public String getNome() {
        return nome;
    }

    public Carta getCartasDaMao( int pos) { //int pos
        return cartasDaMao.get(pos);
        //return cartasDaMao.size();

    }
}
