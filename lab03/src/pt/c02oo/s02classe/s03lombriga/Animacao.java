package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String sequencia;
    AquarioLombriga lombriga;
    int pos = 0;
    public Animacao(String string) {
        int tamanho_aquario = Integer.parseInt(string.substring(0, 2));
        int tamanho_lomb = Integer.parseInt(string.substring(2, 4));
        int pos_cabeca = Integer.parseInt(string.substring(4,6));
        AquarioLombriga lomb = new AquarioLombriga(tamanho_aquario, tamanho_lomb, pos_cabeca);
        lombriga = lomb;
        sequencia = string.substring(6, string.length());
    }
    public String apresenta() {
        return lombriga.apresenta();
    }
    public void passo() {
        char operador = sequencia.charAt(pos);
        switch (operador) {
            case 'C': lombriga.crescer();
                break;
            case 'V': lombriga.virar();
                break;
            case 'M': lombriga.mover();
                break;
        }
        pos++;
    }
}
