package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tam_aquario;
    int tam_lombriga;
    int pos_inicial;
    boolean esquerda = true;
    
    public AquarioLombriga(int tam_aquario, int tam_lombriga, int pos_inicial) {
        this.tam_aquario = tam_aquario;
        this.tam_lombriga = tam_lombriga;
        this.pos_inicial = pos_inicial;
    }
    
    public void crescer() {
        if(esquerda == true && pos_inicial + tam_lombriga - 1 < tam_aquario)
            tam_lombriga++;
        else if(esquerda == false && pos_inicial - tam_lombriga > 0)
        	tam_lombriga++;
    }
    
    public void virar() {
        if (esquerda == true) {
            pos_inicial += tam_lombriga - 1;
            esquerda = false;
        }
        else {
            pos_inicial -= tam_lombriga - 1;
            esquerda = true;
        }
    }
    
    public void mover(){
        if ((esquerda == true && pos_inicial == 1) || (esquerda == false && pos_inicial == tam_aquario))
            virar();
        else if (esquerda == true)
            pos_inicial--;
        else
            pos_inicial++;
    }
    
    public String apresenta() {
        String apresentacao = "";
        for (int i = 0; i < tam_aquario; i++) {
            if (esquerda == true && (i < pos_inicial - 1 || i >= pos_inicial - 1 + tam_lombriga)) {
                apresentacao += "#";
            }
            else if (esquerda == false && (i > pos_inicial - 1 || i <= pos_inicial - 1 - tam_lombriga))
                apresentacao += "#";
            else if (i == pos_inicial - 1)
                apresentacao += "O";
            else
                apresentacao += "@";
        }
        return apresentacao;
    }
}
