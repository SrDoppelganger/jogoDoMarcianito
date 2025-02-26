import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int tentativas = 0;
        
        //randomiza arvore entre 0 e 100
        int arvore = rand.nextInt(100) + 1;
        
       
        
        //começa jogo
        System.out.println("=== JOGO DO MARCIANO ===");
        
        System.out.println("Digite um numero entre 0 e 100");
        //guarda o chute do jogador
        int guess = scan.nextInt();
        
         gameLoop(arvore, guess, tentativas);
         
         gameEnding(arvore, guess, tentativas);
         
	}
	
	public static void gameLoop(int arvore, int guess,int tentativas){
	   
	   Scanner scan = new Scanner(System.in);
	   
	     while(guess != arvore){
               if(guess < arvore){
                System.out.println("E Maior");
                tentativas++;
            }
               else if(guess > arvore){
                System.out.println("E Menor");
                tentativas++;  
            }
            
            System.out.println("Digite outro número entre 0 e 100");
            guess = scan.nextInt();
	     }
	}
	
	public static void gameEnding(int arvore, int guess,int tentativas){
	    
	     Scanner scan = new Scanner(System.in);
	     Random rand = new Random();
	    
	     System.out.println("Você acertou!!!");
         System.out.println("Tentativas: " + tentativas);
         System.out.println("Gostaria de jogar novamente?(1-sim/0-não)");
         int escolha = scan.nextInt();
         
         
        if (escolha == 1){
            tentativas = 0;
            arvore = rand.nextInt(100) + 1;
            gameLoop(arvore,guess,tentativas);
        }
        else{
         System.out.println("bye bye ^^");
        }
	}
}