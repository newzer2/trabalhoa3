import java.util.Random;
import java.util.Scanner;

public class tabuleiro {

    public static void Mecanica(String campo1[][], String campoIA[][], String campoIAFake[][], Scanner sc,Random gerador) {
        int vida1 = 10, vidaIA = 10, jogadaIA1, jogadaIA2, jogadaJ1, jogadaJ2;
        int vidaInib1 = 2, vidaInib2 = 2, vidaInibIA1 = 2, vidaInibIA2 = 2;
        //while enquanto a vida estiver > 0, continuará rodando o jogo
        while ((vida1 > 0) && (vidaIA > 0)) {
            System.out.println("");
            System.out.println("");
            System.out.println("======================");
            System.out.println("Seus pontos de vida: " + vida1);
            System.out.println("======================");
            System.out.println("");
            CampoP1.MostrarCampo1(campoIAFake);
            System.out.println("");
            System.out.println("=======================");
            System.out.println("Pontos de vida da IA: " + vidaIA);
            System.out.println("=======================");
            System.out.println("");
            System.out.println("---------------");
            System.out.println("Jogador ataque!");
            System.out.println("---------------");
            System.out.println("");

            jogadaJ1 = sc.nextInt();
            jogadaJ2 = sc.nextInt();
            System.out.println("");
            //while utilizado para informar quando o jogador selecionar um campo já escolhido
            while ((jogadaJ1 >= campo1.length) || (jogadaJ1 < 0)
                    || ((jogadaJ2 >= campo1.length) || (jogadaJ2 < 0))
                    || (campoIAFake[jogadaJ1][jogadaJ2] != null
                            && campoIAFake[jogadaJ1][jogadaJ2].equals("  x "))) {
                System.out.println(
                        "Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 9:");
                jogadaJ1 = sc.nextInt();
                jogadaJ2 = sc.nextInt();
            }
            //if usado quando destruir o nexus, jogador ganhará
            if (campoIA[jogadaJ1][jogadaJ2] == "nexus") {
                System.out.println("==============================");
                System.out.println("Vitoria!");
                System.out.println("Voce destruiu o nexus inimigo.");
                System.out.println("==============================");
                System.out.println("");
                campoIAFake[jogadaJ1][jogadaJ2] = "nexus";
                vidaIA = 0;

            } else if (campoIA[jogadaJ1][jogadaJ2] != null) {
                //if usado para informar quando destruir um inibidor
                if ((vidaInibIA1 == 1) && ((campoIA[jogadaJ1][jogadaJ2].equals("inib1"))
                        || (campoIA[jogadaJ1][jogadaJ2].equals("inibidor2")))) {
                    System.out.println("==========================");
                    System.out.println("Parabens, voce destruiu um inibidor!");
                    System.out.println("==========================");
                    System.out.println("");
                    campoIAFake[jogadaJ1][jogadaJ2] = "  x  ";
                    vidaIA = vidaIA - 2;
                    vidaInibIA1 = vidaInibIA1 - 1;
                //if usado para informar quando destruir um inibidor
                } else if ((vidaInibIA2 == 1) && ((campoIA[jogadaJ1][jogadaJ2].equals("inib3"))
                        || (campoIA[jogadaJ1][jogadaJ2].equals("inibidor4")))) {
                    System.out.println("==========================");
                    System.out.println("Parabens, voce destruiu um inibidor!");
                    System.out.println("==========================");
                    System.out.println("");
                    campoIAFake[jogadaJ1][jogadaJ2] = "  x ";
                    vidaIA = vidaIA - 2;
                    vidaInibIA2 = vidaInibIA2 - 1;
                //if usado para informar quando destruir um inibidor
                } else if ((campoIA[jogadaJ1][jogadaJ2].equals("inibidor1"))
                        || (campoIA[jogadaJ1][jogadaJ2].equals("inibidor2"))) {
                    System.out.println("====================================");
                    System.out.println("Parabens, voce destruiu metade de um inibidor!");
                    System.out.println("====================================");
                    System.out.println("");
                    campoIAFake[jogadaJ1][jogadaJ2] = "  x ";
                    vidaIA = vidaIA - 1;
                    vidaInibIA1 = vidaInibIA1 - 1;
                //if usado para informar quando destruir um inibidor
                } else if ((campoIA[jogadaJ1][jogadaJ2].equals("inibidor3"))
                        || (campoIA[jogadaJ1][jogadaJ2].equals("inibidor4"))) {
                    System.out.println("====================================");
                    System.out.println("Voce destruiu metade de um inibidor!");
                    System.out.println("====================================");
                    System.out.println("");
                    campoIAFake[jogadaJ1][jogadaJ2] = "  x  ";
                    vidaIA = vidaIA - 1;
                    vidaInibIA2 = vidaInibIA2 - 1;

                } else {
                    System.out.println("========================");
                    System.out.println("Voce destruiu uma torre!");
                    System.out.println("========================");
                    System.out.println("");
                    campoIAFake[jogadaJ1][jogadaJ2] = "  x  ";
                    vidaIA = vidaIA - 1;
                }
            //informar quando errou um tiro
            } else {
                System.out.println("===============");
                System.out.println(
                        "Puts voce atingiu um tiro no nada :/, tente novamente na proxima rodada!");
                System.out.println("===============");
                System.out.println("");
                campoIAFake[jogadaJ1][jogadaJ2] = "  ~  ";
            }
            
            if (vidaIA > 0 && (vida1 > 0)) {
                System.out.println("------------");
                System.out.println("Minha vez de te destruir...");
                System.out.println("------------");
                System.out.println("");
                jogadaIA1 = gerador.nextInt(campo1.length);
                jogadaIA2 = gerador.nextInt(campo1.length);

                while (campo1[jogadaIA1][jogadaIA2] != null
                        && campo1[jogadaIA1][jogadaIA2].equals("  x ")
                        || (campo1[jogadaIA1][jogadaIA2] != null
                                && campo1[jogadaIA1][jogadaIA2].equals("  ~ "))) {
                    jogadaIA1 = gerador.nextInt(campo1.length);
                    jogadaIA2 = gerador.nextInt(campo1.length);
                }

                System.out.println(jogadaIA1 + " " + jogadaIA2);
                System.out.println("");
            //mensagem que voce perdeu a partida 
                if (campo1[jogadaIA1][jogadaIA2] == "nexus") {
                    System.out.println("======================================");
                    System.out.println(
                            "- Voce e um perdedor mesmo, se curve perante a mim seu inseto!Tente novamente");
                    System.out.println("A IA destruiu seu nexus.");
                    System.out.println("======================================");
                    System.out.println("");
                    vida1 = 0;

                } else if (campo1[jogadaIA1][jogadaIA2] != null) {
                  // mensagem que ele acertou e destruiu seu inibidor
                    if ((vidaInib1 == 1) && ((campo1[jogadaIA1][jogadaIA2].equals("inibidor1"))
                            || (campo1[jogadaIA1][jogadaIA2].equals("inibidor2")))) {
                        System.out.println("============================");
                        System.out.println("Destrui um inibidor seu! KKKKKKKK ruim");
                        System.out.println("============================");
                        System.out.println("");
                        campo1[jogadaIA1][jogadaIA2] = "  x ";
                        vida1 = vida1 - 2;
                        vidaInib1 = vidaInib1 - 1;
                     //  mensagem que ele acertou e destruiu seu inibidor
                    } else if ((vidaInib2 == 1) && ((campo1[jogadaIA1][jogadaIA2]
                            .equals("inibidor3"))
                            || (campo1[jogadaIA1][jogadaIA2].equals("inibidor4")))) {
                        System.out.println("============================");
                        System.out.println("Destrui um inibidor seu! KKKKKKKK ruim");
                        System.out.println("============================");
                        System.out.println("");
                        campo1[jogadaIA1][jogadaIA2] = "  x ";
                        vida1 = vida1 - 2;
                        vidaInib2 = vidaInib2 - 1;
                       // acertou uma aprte do seu inibidor 
                    } else if ((campo1[jogadaIA1][jogadaIA2].equals("inibidor1"))
                            || (campo1[jogadaIA1][jogadaIA2].equals("inibidor2"))) {
                        System.out.println("========================================");
                        System.out.println(
                                "Acabo de destruir metade de um inibidor! Tome cuidado que irei te destruir xD");
                        System.out.println("========================================");
                        System.out.println("");
                        campo1[jogadaIA1][jogadaIA2] = "  x  ";
                        vida1 = vida1 - 1;
                        vidaInib1 = vidaInib1 - 1;
                       // acertou uma aprte do seu inibidor 
                    } else if ((campo1[jogadaIA1][jogadaIA2].equals("inibidor3"))
                            || (campo1[jogadaIA1][jogadaIA2].equals("inibidor4"))) {
                        System.out.println("========================================");
                        System.out.println(
                                "Acabo de destruir metade de um inibidor! Tome cuidado que irei te destruir xD");
                        System.out.println("========================================");
                        System.out.println("");
                        campo1[jogadaIA1][jogadaIA2] = "  x  ";
                        vida1 = vida1 - 1;
                        vidaInib2 = vidaInib2 - 1;

                    } else {
                        System.out.println("================");
                        System.out.println("Cade sua torre!?");
                        System.out.println("================");
                        System.out.println("");
                        campo1[jogadaIA1][jogadaIA2] = "  x  ";
                        vida1 = vida1 - 1;
                    }
                } else { // mensagem a ia errou o tiro
                    System.out.println("=====================================");
                    System.out.println("- Na agua... sou ruim mesmo... :/");
                    System.out.println("=====================================");
                    System.out.println(""); 
                    campo1[jogadaIA1][jogadaIA2] = "  ~ ";
                }
            }

        }

        if (vida1 <= 0) {
            vida1 = 0;
        } else {
            vidaIA = 0;
        }
//mostra a quantidade de vida dos jogadores 
        CampoP1.MostrarCampo1(campo1);
        System.out.println("");
        System.out.println("======================");
        System.out.println("Seus pontos de vida: " + vida1);
        System.out.println("======================");
        System.out.println("");
        CampoP1.MostrarCampo1(campoIAFake);
        System.out.println("");
        System.out.println("=======================");
        System.out.println("Pontos de vida da IA: " + vidaIA);
        System.out.println("=======================");
//mostra quem venceu
        if (vida1 > 0) {
            System.out.println("");
            System.out.println("===========================");
            System.out.println("O jogador vence a partida.");
            System.out.println("===========================");
        } else {
            System.out.println("");
            System.out.println("======================");
            System.out.println("A IA vence a partida.");
            System.out.println("======================");
        }

    }
}
