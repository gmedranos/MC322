package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca[][] tabul = new Peca[7][7];
	
	public Tabuleiro() {
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++) {
				Peca nova_peca = new Peca(j, i);
				if (i == 3 && j == 3) {
					nova_peca.setComida(true);
					tabul[i][j] = nova_peca;
				}
				else if(1 < i && i < 5) {
					tabul[i][j] = nova_peca;
				}
				else if (1 < j && j < 5)
					tabul[i][j] = nova_peca;
				else {
					nova_peca.setVazio(true);
					tabul[i][j] = nova_peca;
				}
			}
	}
	/* Cria uma matriz de char que representa o tabuleiro */

	public char[][] apresenta() {
		char tab_apresent[][] = new char[7][7];
		
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++) {
				if (tabul[i][j].isComida() == true)
					tab_apresent[i][j] = '-';
				else if(tabul[i][j].isVazio() == true)
					tab_apresent[i][j] = ' ';
				else 
					tab_apresent[i][j] = 'P';
			}
		
		return tab_apresent;
	}
	
	/* Move uma peca no tabuleiro */
	public void mover(int org_x, int org_y, int dest_x, int dest_y) {
		if (tabul[org_y][org_x].movLegal(dest_x, dest_y) == false) { // Pergunta para a peca se o movimento é legal
			return;
		}
		if(org_x == dest_x) { // Pergunta para a peca do meio a peca origem pode fazer o movimento
			if (dest_y > org_y && tabul[org_y + 1][org_x].mover(tabul[dest_y][dest_x]) == false)
				return;
			if (dest_y < org_y && tabul[org_y - 1][org_x].mover(tabul[dest_y][dest_x]) == false)
				return;
		}
		if(org_y == dest_y) {
			if (dest_x > org_x && tabul[org_y][org_x + 1].mover(tabul[dest_y][dest_x]) == false)
				return;
			if (dest_x < org_x && tabul[org_y][org_x - 1].mover(tabul[dest_y][dest_x]) == false)
				return;
		}
		
		// Altera o tabuleiro
		tabul[dest_y][dest_x].setComida(false);
		tabul[org_y][org_x].setComida(true);
		
		if (org_y == dest_y) {
			if (dest_x > org_x)
				tabul[org_y][org_x + 1].setComida(true);
			else
				tabul[org_y][org_x - 1].setComida(true);
		}
		else {
			if (dest_y > org_y)
				tabul[org_y + 1][org_x].setComida(true);
			else
				tabul[org_y - 1][org_x].setComida(true);
		}
	}
}

