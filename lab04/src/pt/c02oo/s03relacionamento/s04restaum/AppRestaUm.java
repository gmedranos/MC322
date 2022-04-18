package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {
	public static void main(String[] args) {
		
		AppRestaUm.executaJogo(null, null);
	   }
		/* Transforma uma letra em uma posicao valida para as funcoes */	   
		private static int converteLetra(char letra) {
			switch(letra) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			default:
				return 7;
			}
		}
		
		/* Executa o jogo, ao ler as entradas de um arquivo .csv e realizando os movimentos necessarios */
	   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
		   Tabuleiro tab = new Tabuleiro();
		   Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
	      
	      String commands[] = tk.retrieveCommands();
	      
	      System.out.println("=== Primeira Sa�da");
	      char board[][] = {
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
	      };
	            
	      tk.writeBoard("Tabuleiro inicial", board);
	      
	      for (int l = 0; l < commands.length; l++)	 {
	    	  int ori_x = AppRestaUm.converteLetra(commands[l].charAt(0));
	    	  int ori_y = Character.getNumericValue(commands[l].charAt(1)) - 1;
	    	  
	    	  int dest_x = AppRestaUm.converteLetra(commands[l].charAt(3));
	    	  int dest_y = Character.getNumericValue(commands[l].charAt(4)) - 1;
	    	  
	    	  tab.mover(ori_x, ori_y, dest_x, dest_y);
	    	  board = tab.apresenta();
	    	  tk.writeBoard("source: " + commands[l].substring(0,2) + "; target: " + commands[l].substring(3,5), board);
	      }
	 
	      
	      tk.stop();
	  }
}

