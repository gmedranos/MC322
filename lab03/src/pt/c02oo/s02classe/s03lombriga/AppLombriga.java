package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      String lombrigas[] = tk.recuperaLombrigas();
      Animacao lomb;
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  lomb = new Animacao(lombrigas[l]);
    	  tk.gravaPasso("=====");
    	  for (int i = 0; i < lomb.sequencia.length(); i++) {
    		  tk.gravaPasso(lomb.apresenta());
    	  	  lomb.passo();
    	  }
    	  tk.gravaPasso(lomb.apresenta());
      }
          
      
      tk.stop();
   }

}