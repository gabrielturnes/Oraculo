package std29006;

import std29006.Oraculo;

import java.io.Console;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Cliente de uma aplica¸c~ao Java RMI
 */
public class ClienteOraculo {
    private static String nomeServidor = "191.36.13.84";
    private static int porta = 12345;
    private static final String NOMEOBJDIST = "MeuOraculo";
    public static void main(String args[]) {
        try {
            if (args[0] != null){
                nomeServidor = args[0];
            }
            if (args[1] != null){
                porta = Integer.parseInt(args[1]);
            }
            System.out.println("Conectando no servidor "+ nomeServidor);
// Obtendo refer^encia do servi¸co de registro
            Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
// Procurando pelo objeto distribu´ıdo registrado previamente com o NOMEOBJDIST
            Oraculo stub = (Oraculo) registro.lookup(NOMEOBJDIST);
            Scanner sc1 = new Scanner(System.in);
            int opcao = 0;
            do {
                System.out
                        .println("\n\n### Oraculo ###");
                System.out.println("\n                  =========================");
                System.out.println("                  |     1 - Gerar senha   |");
                System.out.println("                  |     2 - Vencedor      |");
                System.out.println("                  |     0 - Sair          |");
                System.out.println("                  =========================\n");
                System.out.println("Opção -> ");
                opcao = sc1.nextInt();
                System.out.print("\n");
                switch (opcao) {
                    case 1:
                        System.out.println("Qual o seu nome?");
                        String nome = sc1.nextLine();
                        int senha = stub.gerarSenha(nome);
                        if(senha == -1){
                            System.out.println("Todas as senhas já foram distribuídas.");
                        }else{
                            System.out.println("Sua senha é: " + senha);
                        }
                        break;
                    case 2:
                        String resultado = stub.gerarResultado();
                        if(resultado == "SemVencedor"){
                            System.out.println("As 4 senhas ainda não foram geradas. Volte mais tarde.");
                        }else{
                            System.out.println("O vencedor é " + resultado);
                        }
                        break;
                    case 0:
                        System.out.println("Tchau!");
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } while (opcao != 0);

        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ClienteOraculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}