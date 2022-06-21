import java.util.Scanner;

public class MontarCampo {
    public static void MontarCampo1(String campo1[][], Scanner sc) {
        int axposicao1 = 0, axposicao2 = 0, posicaoib1, posicaoib2;
        int torre = 0, inibidor = 0, c = 1, i = 1;
        //Utilizado para escolher posição da linha e coluna em ordem
        System.out.println("Escolha a posicao do nexus:");
        axposicao1 = sc.nextInt();
        axposicao2 = sc.nextInt();
        //Utilizando um while para que enquanto a posição for = 0, estará livre para ser escolhido
        while ((axposicao1 >= campo1.length) || (axposicao1 < 0) || (axposicao2 >= campo1.length)
                || (axposicao2 < 0)) {
            System.out.println("Digite um espaco valido do campo de 0 a 9:");
            axposicao1 = sc.nextInt();
            axposicao2 = sc.nextInt();
        }
        campo1[axposicao1][axposicao2] = "nexus";
        System.out.println("");
        CampoP1.MostrarCampo1(campo1);
        System.out.println("");
        //Utilizando um while para que enquanto a posição for = 0, estará livre para ser escolhido
        while (inibidor < 2) {
            System.out.println("");
            System.out.println("Escolha a posicao do inibidor " + c + ":");

            if (inibidor == 0) {
                System.out.println("inibidor1:");
            } else {
                System.out.println("inibidor3:");
            }

            axposicao1 = sc.nextInt();
            axposicao2 = sc.nextInt();
        //Utilizando um while para que enquanto a posição for = 0, estará livre para ser escolhido
            while ((axposicao1 >= campo1.length) || (axposicao1 < 0) || (axposicao2 >= campo1.length)
                    || (axposicao2 < 0) || (campo1[axposicao1][axposicao2] != null)) {
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:");
                axposicao1 = sc.nextInt();
                axposicao2 = sc.nextInt();
            }
            if (inibidor == 0) {
                campo1[axposicao1][axposicao2] = "inibidor1";
            } else {
                campo1[axposicao1][axposicao2] = "inibidor3";
            }
            posicaoib1 = axposicao1;
            posicaoib2 = axposicao2;
            System.out.println("");
            CampoP1.MostrarCampo1(campo1);
            System.out.print("");

            System.out.println("");
            if (inibidor == 0) {
                System.out.println("inibidor2:");
            } else {
                System.out.println("inibidor4:");
            }

            axposicao1 = sc.nextInt();
            axposicao2 = sc.nextInt();
            //verificar se as peças estão colocadas conforme pedido, caso não esteja irá dar uma mensagem informando como serem colocadas e pedir novamente 
            while (((axposicao1 >= campo1.length) || (axposicao1 < 0))
                    || ((axposicao2 >= campo1.length) || (axposicao2 < 0))
                    || ((campo1[axposicao1][axposicao2] != null))
                    || ((axposicao2 != posicaoib2) && (axposicao1 != posicaoib1))
                    || ((axposicao1 != posicaoib1 + 1) && (axposicao1 != posicaoib1 - 1)
                            && (axposicao2 != posicaoib2 + 1)
                            && (axposicao2 != posicaoib2 - 1))) {
                System.out.println(
                        "Lembre-se, pecas com uma o mais partes devem ser colocadas lado a lado.");
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:");
                axposicao1 = sc.nextInt();
                axposicao2 = sc.nextInt();
            }

            if (inibidor == 0) {
                campo1[axposicao1][axposicao2] = "inibidor2";
            } else {
                campo1[axposicao1][axposicao2] = "inibidor4";
            }
            System.out.println("");
            CampoP1.MostrarCampo1(campo1);
            System.out.print("");
            inibidor = inibidor + 1;
            c = c + 1;
        }
        while (torre < 3) {
            System.out.println("");
            System.out.println("Escolha a posicao da torre " + i + ":");
            axposicao1 = sc.nextInt();
            axposicao2 = sc.nextInt();

            while ((axposicao1 >= campo1.length) || (axposicao1 < 0)
                    || ((axposicao2 >= campo1.length) || (axposicao2 < 0))
                    || (campo1[axposicao1][axposicao2] != null)) {
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:");
                axposicao1 = sc.nextInt();
                axposicao2 = sc.nextInt();
            }
            campo1[axposicao1][axposicao2] = "torre";
            System.out.println("");
            CampoP1.MostrarCampo1(campo1);
            System.out.print("");
            i++;
            torre++;
        }
    }
}
