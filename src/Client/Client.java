package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import Logic.ParOuImparLogic;
import Util.Enum.EParOuImpar;
import Util.Enum.EStatus;
import Util.Model.RequestModel;
import Util.Model.ResponseModel;

public class Client {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 12345;
        final int PORT2 = 12346;
        Socket socket;
        Socket socket2;

        boolean jogoFinalizado = false;

        while (!jogoFinalizado) {
            try {
                System.out.println("Conectado ao servidor");
                System.out.println("--------------------------------");
                System.out.println("--------- Tipo de jogo ---------");
                System.out.println("- Vs CPU   ------   Vs Jogador -");
                System.out.println("-    1     ------        2     -");
                System.out.println("--------------------------------");
                System.out.println("    Escolha a opção de jogo     ");

                ParOuImparLogic _parOuImparLogic = new ParOuImparLogic();

                boolean saidaTipoJogo = false;
                Scanner tipoJogoScanner = new Scanner(System.in);
                int tipoJogo = 0;

                while (!saidaTipoJogo) {

                    tipoJogo = tipoJogoScanner.nextInt();

                    if (tipoJogo == 1) {
                        System.out.println("Legal, você vai jogar contra a CPU.");
                        saidaTipoJogo = true;
                    } else if (tipoJogo == 2) {
                        System.out.println("Legal, você vai jogar contra outro Jogador.");
                        saidaTipoJogo = true;
                    } else {
                        System.out.println("Sua opção não é valida, escolha novamente.");
                    }
                }

                if (tipoJogo == 1) {
                    socket = new Socket(HOST, PORT);

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

                        if (parImpar != 1 || parImpar != 2) {
                            System.out.printf("Boa você é: %s", parImpar == 2 ? "Par" : "Impar");
                            escolha = parImpar == 2 ? EParOuImpar.PAR : EParOuImpar.IMPAR;
                            saidaParImpar = true;
                        } else {
                            System.out.println("Opção inválida, escolha novamente!");
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

                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                    System.out.println("Enviando requisição...");
                    output.writeObject(request);

                    System.out.println("Esperando resposta...");
                    ResponseModel response = (ResponseModel) input.readObject();

                    if (response.getVitoria()) {
                        System.out.printf("Parabéns, você venceu!!, a maquina ficou com: %s e escolheu o numero: %s",
                                response.getParImpar(), response.getNumero());
                    } else {
                        System.out.printf("Ops, você perdeu, a maquina ficou com: %s e escolheu o numero: %s",
                                response.getParImpar(), response.getNumero());
                    }

                } else {
                    socket2 = new Socket(HOST, PORT2);

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

                        if (parImpar != 1 || parImpar != 2) {
                            System.out.printf("Boa você é: %s", parImpar == 2 ? "Par" : "Impar");
                            escolha = parImpar == 2 ? EParOuImpar.PAR : EParOuImpar.IMPAR;
                            saidaParImpar = true;
                        } else {
                            System.out.println("Opção inválida, escolha novamente!");
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
                    System.out.println("\n--------------------------------");
                    System.out.println("-------- Par ou Impar ? --------");
                    System.out.println("--- Impar ------------- Par ----");
                    System.out.println("-    1     ------        2     -");
                    System.out.println("--------------------------------");

                    boolean saidaParImpar2 = false;
                    Scanner parImparScanner2 = new Scanner(System.in);
                    int parImpar2 = 0;
                    EParOuImpar escolha2 = null;

                    while (!saidaParImpar2) {

                        parImpar2 = parImparScanner2.nextInt();

                        if (parImpar2 != 1 || parImpar2 != 2) {
                            System.out.printf("Boa você é: %s", parImpar2 == 2 ? "Par" : "Impar");
                            escolha2 = parImpar2 == 2 ? EParOuImpar.PAR : EParOuImpar.IMPAR;
                            saidaParImpar2 = true;
                        } else {
                            System.out.println("Opção inválida, escolha novamente!");
                        }
                    }

                    System.out.println("\n--------------------------------");
                    System.out.println("Agora escolha um numero de 0 a 5, \npara realizar seu jogo.");

                    boolean saidaNumero2 = false;
                    Scanner numeroEscolhidoScanner2 = new Scanner(System.in);
                    int numeroEscolhido2 = 0;

                    while (!saidaNumero2) {

                        numeroEscolhido2 = numeroEscolhidoScanner2.nextInt();

                        if (numeroEscolhido2 <= 5 && numeroEscolhido2 >= 0) {
                            System.out.println("Só aguardar o resultado.");
                            saidaNumero = true;
                        } else {
                            System.out.println("Escolha um numero entre 0 e 5.");
                        }
                    }

                    ObjectOutputStream output = new ObjectOutputStream(socket2.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(socket2.getInputStream());

                    RequestModel request = new RequestModel(numeroEscolhido2, escolha2);

                    output.writeObject(request);

                }

                // if(response.getStatus() == Status.SUCCESS) {
                // System.out.println("Resultado: " + response.getValue());
                // } else {
                // if(response.getStatus() == Status.DIVIDE_BY_ZERO){
                // System.out.println("Divisão por zero.");
                // } else {
                // System.out.println("Operação inválida");
                // }
                // }

            } catch (Exception e) {
                System.out.println("Erro" + e.getMessage());
            }
        }
    }
}
