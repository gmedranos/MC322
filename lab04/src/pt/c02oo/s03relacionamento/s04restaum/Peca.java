package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int posicao_x, posicao_y;
	private boolean vazio = false;
	private boolean comida = false;
	
	public Peca(int posicao_x, int posicao_y) {
		this.posicao_x = posicao_x;
		this.posicao_y = posicao_y;
	}
	
	public int getPosicao_x() {
		return posicao_x;
	}

	public void setPosicao_x(int posicao_x) {
		this.posicao_x = posicao_x;
	}

	public int getPosicao_y() {
		return posicao_y;
	}

	public void setPosicao_y(int posicao_y) {
		this.posicao_y = posicao_y;
	}

	public boolean isVazio() {
		return vazio;
	}

	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}

	public boolean isComida() {
		return comida;
	}

	public void setComida(boolean comida) {
		this.comida = comida;
	}

	public boolean movLegal(int dest_x, int dest_y) { // Verifica se o movimento desejado é legal, ou seja, se ele anda 2 casas na horizonatal ou vertical
		if (posicao_x == dest_x) {
			if(posicao_y - dest_y == 2 || posicao_y - dest_y == -2)
				return true;
		}
		else if (posicao_y == dest_y) {
			if(posicao_x - dest_x == 2 || posicao_x - dest_x == -2)
				return true;
		}
		return false;
	}
	
	public boolean mover(Peca peca) { // Verifica se a peca esta ocupada e se o destino é esta vazio
		if (vazio == true || peca.vazio == true)
			return false;
		else if (comida == false && peca.comida == true)
			return true;
		return true;
	}
}
