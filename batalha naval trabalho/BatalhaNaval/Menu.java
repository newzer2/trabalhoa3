import java.util.Random;
import java.util.Scanner;;

public class Menu {
        static int opc;
        static Scanner sc = new Scanner(System.in);
        static Random gerador = new Random();
        static String campoIA[][] = new String[10][10];
        static String campo1[][] = new String[10][10];
        static String campoIAFake[][] = new String[10][10];

        // Classe para menu principal do jogo de batalha naval
        public static void MenuPrincipal(String[] args) {

                do 
                {
                   ExibirMenu();                
                   opc = sc.nextInt();

                   if (opc == 1) {
                        CampoJogo.GerarCampoIA(campoIA, gerador);
                        System.out.println("--------------------------------");
                        System.out.println("   Monte seu campo de batalha");
                        System.out.println("--------------------------------");
                        System.out.println("");

                        CampoP1.MostrarCampo1(campo1);
                        System.out.println("");

                        MontarCampo.MontarCampo1(campo1, sc);
                        System.out.println("--------------------------------");
                        System.out.println("   Lute por sua sobrevivencia");
                        System.out.println("--------------------------------");
                        System.out.println("");

                        tabuleiro.Mecanica(campo1, campoIA, campoIAFake, sc, gerador);

                        System.out.println("");
                        System.out.println("1 - Voltar ao menu");
                        opc = sc.nextInt();

                        while (opc != 1) {
                                System.out.println("Opcao invalida, digite 1 para voltar ao menu");
                                opc = sc.nextInt();
                        }
                        if (opc == 1) {
                                a3.main(args);
                        }
                }
                   else if (opc == 2) {
                        ExibirInstrucoes();
                        System.out.println("Digite Enter para voltar ao menu.");
                        System.out.println("");
                        sc.nextLine();  // Consume newline left-over
                        sc.nextLine();
                   }
                   else{
                        System.out.println("Opcao invalida, digite novamente:");
                   }
                } while(opc != 3);
        }

        private static void ExibirMenu() 
        {
                System.out.println("");
                System.out.println(
                                "                                                         ============================================");
                System.out.println(
                                "                                                                   BEM VINDOS A BATALHA NAVAL");
                System.out.println(
                                "                                                         ============================================");
                System.out.println("");
                System.out.println(
                                "                                                        ___________        ___________                    ");
                System.out.println(
                                "                                                        _                                _                ");
                System.out.println(
                                "                                                       |O|                              |O|               ");
                System.out.println(
                                "                                                       |_|            <                 |_|               ");
                System.out.println(
                                "                                                                                                          ");
                System.out.println(
                                "                                                           ____________________________                   ");
                System.out.println(
                                "                                                           |DDDDDDDDDDDDDDDDDDDDDDDDDD|                   ");
                System.out.println(
                                "                                                          |___________________________|                   ");
                System.out.println(
                                "                                                                                                          ");
                System.out.println("");
                System.out.println("");
                System.out.println(
                                "                                                         ============================================");
                System.out.println(
                                "                                                         Digite o numero respectivo a opcao desejada:");
                System.out.println(
                                "                                                         ============================================");
                System.out.println("");
                System.out.println(
                                "                                                                           1- Jogar");
                System.out.println(
                                "                                                                           2- Instrucoes");
                System.out.println(
                                "                                                                           3- Sair");
                System.out.println(
                                "                                                         --------------------------------------------");
        }


        public static void ExibirInstrucoes() {
                System.out.println("=============================");
                System.out.println("          INSTRUCOES:        ");
                System.out.println("=============================");
                System.out.println("");
                System.out.println("* O campo tem o tamanho 10x10.");
                System.out.println("* Os jogadores tem direito a 1 ataque por rodada.");
                System.out.println(
                                "* Para posicionar as pecas e necessario digitar a linha e coluna desejada (de 0 a 9) respectivamente.");
                System.out.println("* O jogador possui 3 tipos de embarcacoes para posicionar no campo:");
                System.out.println(
                                "*  1 Nexus (dano - vida total), 2 inibidores (dano - peca 1, completo 2) e 3 torres (dano 1).");
                System.out.println("* Os inibidores possuem 2 partes que devem ser colocadas lado a lado.");
                System.out.println(
                                "* Se o nexus for destruido, automaticamente quem atirou e o vencedor da partida.");
                System.out.println(
                                "* Cada jogar comeca com 10 vidas, quem conseguir se manter vivo e o vencedor.");
                System.out.println("");
                System.out.println("*OBS:*Não pode atirar 2 vezes no mesmo local.");
        }

}