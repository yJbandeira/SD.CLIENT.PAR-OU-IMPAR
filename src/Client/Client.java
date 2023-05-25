package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import Util.Enum.EParOuImpar;
import Util.Model.RequestModel;
import Util.Model.ResponseModel;
import Util.Model.ResponsePvPModel;

public class Client {
    public static void main(String[] args) {
        String HOST = "";
        final int PORT = 12345;
        final int PORT2 = 12346;
        Socket socket;
        Socket socket2;

        boolean jogoFinalizado = false;

        System.out.println("Seja bem vindo ao jogo de Par ou impar");
        System.out.println("para começar, digite o IP do servidor:");

        Scanner hostScanner = new Scanner(System.in);
        HOST = hostScanner.nextLine();

        try{           
            while (!jogoFinalizado) {  
                
                
                System.out.println("\n\nConectado ao servidor");

                System.out.println("\n\n--------------------------------");
                System.out.println("--------- Tipo de jogo ---------");
                System.out.println("- Vs CPU   ------   Vs Jogador -");
                System.out.println("-    1     ------        2     -");
                System.out.println("--------------------------------");
                System.out.println("    Escolha a opção de jogo     ");

                boolean saidaTipoJogo = false;
                Scanner tipoJogoScanner = new Scanner(System.in);
                int tipoJogo = tipoJogoScanner.nextInt();

                while (!saidaTipoJogo) {
                    if(!escolhendoTipoJogo(tipoJogo)){
                        saidaTipoJogo = false;
                        tipoJogo = tipoJogoScanner.nextInt();
                    } else {
                        saidaTipoJogo = true;
                    }
                }
                                   
                System.out.println("\n--------------------------------");
                System.out.println("-------- Par ou Impar ? --------");
                System.out.println("--- Impar ------------- Par ----");
                System.out.println("-    1     ------        2     -");
                System.out.println("--------------------------------");

                boolean saidaParImpar = false;
                Scanner parImparScanner = new Scanner(System.in);
                int parImpar = 0;
                EParOuImpar escolha = null;

                while (!saidaParImpar) {

                    parImpar = parImparScanner.nextInt();

                    switch (parImpar) {
                        case 1:
                            System.out.printf("Boa você é: Ímpar");
                            escolha = escolha.IMPAR;
                            saidaParImpar = true;
                            break;
                        case 2:
                            System.out.printf("Boa você é: Par");
                            escolha = escolha.PAR;
                            saidaParImpar = true;
                            break;
                        default:
                            System.out.println("Opção inválida, escolha novamente!");
                            saidaParImpar = false;
                            break;
                    }
                }

                System.out.println("\n--------------------------------");
                System.out.println("Agora escolha um numero de 0 a 5, \npara realizar seu jogo.");

                boolean saidaNumero = false;
                Scanner numeroEscolhidoScanner = new Scanner(System.in);
                int numeroEscolhido = 0;

                while (!saidaNumero) {

                    numeroEscolhido = numeroEscolhidoScanner.nextInt();

                    if (numeroEscolhido <= 5 && numeroEscolhido >= 0) {
                        System.out.println("Só aguardar o resultado.");
                        saidaNumero = true;
                    } else {
                        System.out.println("Escolha um numero entre 0 e 5.");
                    }
                }

                RequestModel request = new RequestModel(numeroEscolhido, escolha);

                if (tipoJogo == 1) {
                    socket = new Socket(HOST, PORT);
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                    output.writeObject(request);

                    ResponseModel response = (ResponseModel) input.readObject();

                    if (response.getVitoria()) {
                        System.out.printf("Parabéns, você venceu!!, a maquina ficou com: %s e escolheu o numero: %s ", response.getParImpar(), response.getNumero());
                    } else {
                        System.out.printf("Ops, você perdeu, a maquina ficou com: %s e escolheu o numero: %s ",
                                response.getParImpar(), response.getNumero());
                    }
                    
                    saidaTipoJogo = true;

                } else {   
                    socket2 = new Socket(HOST, PORT2);                        
                    ObjectOutputStream output = new ObjectOutputStream(socket2.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(socket2.getInputStream());

                    output.writeObject(request);

                    ResponsePvPModel response = (ResponsePvPModel) input.readObject();

                    if (response.getVitoria()) {
                        System.out.printf("%s, seu adversario ficou com: %s, e escolheu o numero: %s",
                                response.getMensagem(), response.getParImparAdversario(),
                                response.getNumeroAdversario());
                    } else {
                        System.out.printf("%s, seu adversario ficou com: %s, e escolheu o numero: %s",
                                response.getMensagem(), response.getParImparAdversario(),
                                response.getNumeroAdversario());
                    }
                    saidaTipoJogo = true;
                }
                
                System.out.println("\nDeseja continuar? Digite 0 para sim e 1 para não!");
                Scanner saidaScanner = new Scanner(System.in);
                int saida = saidaScanner.nextInt();

                if(saida == 1) {
                    System.out.println("Finalizando o jogo!");

                    tipoJogoScanner.close();
                    parImparScanner.close();
                    numeroEscolhidoScanner.close();
                    saidaScanner.close();

                    jogoFinalizado = true;
                }
            }            
    
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());;
        }
        
        hostScanner.close();
    }

    public static boolean escolhendoTipoJogo(int tipoJogo) {
        switch (tipoJogo) {
            case 1:
                System.out.println("Legal, você vai jogar contra a CPU.");
                return true;
            case 2:
                System.out.println("Legal, você vai jogar contra outro Jogador.");
                return true;
            default:
                System.out.println("Opção inválida");
                System.out.println("Digite novamente:");
                return false;
        }
    }

}