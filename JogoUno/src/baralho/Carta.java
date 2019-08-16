package baralho;


import com.sun.jdi.ClassObjectReference;

public class Carta {

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

    private int cor;
    private int numero;

    private int acao;
    private int nome;
    private String cors;
    private String acoes;
    private String nums;
    private String nomes;


    public void setCor(int cor) {
        this.cor = cor;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }
    public void setNome(int nome) {
        this.nome = nome;
    }
    public void setCors(String cors) {
        this.cors = cors;
    }
    public void setAcoes(String acoes) {
        this.acoes = acoes;
    }
    public void setNums(String nums) {
        this.nums = nums;
    }
    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getNums(Carta c) {
        return c.nums;
    }

    public String getAcoes() {
        return this.acoes;
    }

    public String getNomes(Carta c) {
        return c.nomes;
    }

    public String getCors(Carta c) {
        return c.cors;
    }

    public int getCor() {
        return this.cor;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getAcao() {
        return this.acao;
    }
    public int getNome() {
        return this.nome;
    }


    public void qualCor(Carta c) {
        if (c.getCor() == AZUL) {
            setCors("AZUL");
        }
        if (c.getCor() == VERMELHO) {
            setCors("VERMELHO");
        }
        if (c.getCor() == VERDE) {
            setCors("VERDE");
        }
        if (c.getCor() == AMARELO) {
            setCors("AMARELO");
        }
        if (c.getCor() == TODAS) {
            setCors("TODAS");
        }

    }


    public void qualAcao (Carta c) {
        if (c.getAcao() == BLOQUEIA) {
            setAcoes("BLOQUEIA");
        }
        if (c.getAcao() == MAISDOIS) {
            setAcoes("MAIS DOIS");
        }
        if (c.getAcao() == MAISQUATRO) {
            setAcoes("MAIS QUATRO");
        }
        if (c.getAcao() == INVERSAO) {
            setAcoes("INVERTE");
        }
        if (c.getAcao() == SEMACAO) {
            setAcoes("SEM ACAO");
        }
        if (c.getAcao() == CURINGA) {
            setAcoes("CURINGA");
        }

    }

    public void qualNumero (Carta c) {
        if (c.getNumero() == SEMNUMERO) {
            setNums("Sem Numero");
        }
    }

    public void qualNome (Carta c) {
        if (c.getNome() == NUMERICA) {
            setNomes("Carta numerica");
        }
        if (c.getNome() == ACAO) {
            setNomes("Carta de acao");
        }
    }
}
