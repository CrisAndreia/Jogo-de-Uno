package baralho;

import baralho.Carta;

public class MaisDois extends Carta {
    @Override
    public void setAcao(int acao) {
        super.setAcao(acao);
    }

    @Override
    public void setCor(int cor) {
        super.setCor(cor);
    }

    @Override
    public void setNome(int nome) {
        nome = 14;
        super.setNome(nome);
    }

    @Override
    public void setNumero(int numero) {
        super.setNumero(numero);
    }

}