package baralho;

import java.util.ArrayList;
import baralho.BaralhoDoJogo.*;

public class Numerica extends Carta {


    @Override
    public void setCor(int cor) {
        super.setCor(cor);
    }

    @Override
    public void setNumero(int numero) {
        super.setNumero(numero);
    }

    @Override
    public void setAcao(int acao) {
        super.setAcao(acao);
    }

    @Override
    public void setNome(int nome) {
        nome = 13;
        super.setNome(nome);
    }


}
