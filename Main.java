import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		int highscore = 10;
		//começa o jogo
        gameStart(highscore);
	}
	
	public static void gameStart(int highscore){
		Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int tentativas = 0;
        int limite = 7;
        
        //randomiza arvore entre 0 e 100
        int arvore = rand.nextInt(100) + 1;
        
		//começa jogo
        System.out.println("=== JOGO DO MARCIANO ===");
        System.out.println("Um marciano caiu no planeta Terra e agora cabe a você a acha-lo\npara ajudar ele a voltar para sua terra natal");
        
        System.out.println("Digite um numero entre 0 e 100");
        //guarda o chute do jogador
        int guess = scan.nextInt();
        
        gameLoop(arvore, guess, tentativas, limite, highscore);
        scan.close();
	}
	
	public static void gameLoop(int arvore, int guess,int tentativas,int limite, int highscore){
	   
	   Scanner scan = new Scanner(System.in);
	   
	     while(guess != arvore){
               if(guess < arvore){
                tentativas++;
                System.out.println("tentativas: " + tentativas +"/"+ limite);
                System.out.println("E Maior");
            }
               else if(guess > arvore){
                tentativas++;
                System.out.println("tentativas: " + tentativas +"/"+ limite);
                System.out.println("E Menor");
            }
               if(tentativas > limite) {
            	   gameEnding(arvore, guess, tentativas, limite, highscore);
               }
            
            System.out.println("Digite outro número entre 0 e 100");
            guess = scan.nextInt();
            
            if(guess == arvore){
                gameEnding(arvore, guess, tentativas, limite, highscore);
                scan.close();
            }
	     }
	}
	
	public static void gameEnding(int arvore, int guess,int tentativas, int limite, int highscore){
	    
	     Scanner scan = new Scanner(System.in);
	     Random rand = new Random();
	     highscore = checkScore(highscore, tentativas);
	     
	     if(tentativas<=limite) {
	    	 System.out.println("Você acertou!!!");
	         System.out.println("Tentativas: " + tentativas);
	         System.out.println("Menor número de tentativas: " + highscore);
	     }
	     else {
	    	 System.out.println("Você perdeu!!!");
	         System.out.println("Tentativas: " + tentativas);
	         System.out.println("Menor número de tentativas: " + highscore);
	     }
	    
	     
	     //opção de jogar novamente
         System.out.println("Gostaria de jogar novamente?(1-sim/0-não)");
         int escolha = scan.nextInt();
         
        if (escolha == 1){
            tentativas = 0;
            arvore = rand.nextInt(100) + 1;
            gameStart(highscore);
        }
        else{
         System.out.println("até a próxima ^^");
        }
	}
	
	public static int checkScore(int highscore, int tentativas){
		if(highscore > tentativas) {
			highscore = tentativas;
			return tentativas;
		}
		else {
			return highscore;
		}	
	}
}
