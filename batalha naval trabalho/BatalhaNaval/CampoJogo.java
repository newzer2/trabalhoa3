import java.util.Random;

public class CampoJogo {
    public static void GerarCampoIA(String campoIA[][], Random gerador) {
        int numrandom1, numrandom2, escolhaverif, verifcima, verifbaixo, verifdireita, verifesquerda;
        int qnexus = 0, qinibidor = 0, qtorre = 0;

        while (qnexus < 1) {
            numrandom1 = gerador.nextInt(campoIA.length);
            numrandom2 = gerador.nextInt(campoIA.length);
            if (campoIA[numrandom1][numrandom2] == null) {
                campoIA[numrandom1][numrandom2] = "nexus";
                qnexus = qnexus + 1;
                System.out.println("O NEXUS DO IA está na posicao: " + numrandom1 + " : " + numrandom2);
            }
        }
        while (qinibidor < 2) {
            numrandom1 = gerador.nextInt(campoIA.length);
            numrandom2 = gerador.nextInt(campoIA.length);
            verifcima = numrandom1 - 1;
            verifbaixo = numrandom1 + 1;
            verifdireita = numrandom2 + 1;
            verifesquerda = numrandom2 - 1;
            escolhaverif = gerador.nextInt(9);

            if (campoIA[numrandom1][numrandom2] == null) {
                if (escolhaverif == 0) {
                    if ((verifcima < campoIA.length) && (verifcima >= 0)
                            && (campoIA[verifcima][numrandom2] == null)) {
                        if (qinibidor == 0) {
                            campoIA[numrandom1][numrandom2] = "inibidor1";
                            campoIA[verifcima][numrandom2] = "inibidor2";
                        } else {
                            campoIA[numrandom1][numrandom2] = "inibidor 3";
                            campoIA[verifcima][numrandom2] = "inibidor 4";
                        }
                        qinibidor = qinibidor + 1;
                    }
                }
                if (escolhaverif == 1) {
                    if ((verifbaixo < campoIA.length) && (verifbaixo >= 0)
                            && (campoIA[verifbaixo][numrandom2] == null)) {
                        if (qinibidor == 0) {
                            campoIA[numrandom1][numrandom2] = "inibidor1";
                            campoIA[verifbaixo][numrandom2] = "inibidor2";
                        } else {
                            campoIA[numrandom1][numrandom2] = "inibidor3";
                            campoIA[verifbaixo][numrandom2] = "inibidor4";
                        }
                        qinibidor = qinibidor + 1;
                    }
                }
                if (escolhaverif == 2) {
                    if ((verifdireita < campoIA.length) && (verifdireita >= 0)
                            && (campoIA[numrandom1][verifdireita] == null)) {
                        if (qinibidor == 0) {
                            campoIA[numrandom1][numrandom2] = "inibidor1";
                            campoIA[verifdireita][numrandom2] = "inibidor2";
                        } else {
                            campoIA[numrandom1][numrandom2] = "inibidor3";
                            campoIA[verifdireita][numrandom2] = "inibidor1";
                        }
                        qinibidor = qinibidor + 1;
                    }
                }
                if (escolhaverif == 3) {
                    if ((verifesquerda < campoIA.length) && (verifesquerda >= 0)
                            && (campoIA[numrandom1][verifesquerda] == null)) {
                        if (qinibidor == 0) {
                            campoIA[numrandom1][numrandom2] = "inibidor1";
                            campoIA[verifesquerda][numrandom2] = "inibidor2";
                        } else {
                            campoIA[numrandom1][numrandom2] = "inibidor3";
                            campoIA[verifesquerda][numrandom2] = "inibidor4";
                        }
                        qinibidor = qinibidor + 1;
                    }
                }
            }
        }
        while (qtorre < 3) {
            numrandom1 = gerador.nextInt(campoIA.length);
            numrandom2 = gerador.nextInt(campoIA.length);
            if (campoIA[numrandom1][numrandom2] == null) {
                campoIA[numrandom1][numrandom2] = "Torre";
                qtorre = qtorre + 1;
                System.out.println("A TORRE DO IA está na posicao: " + numrandom1 + " : " + numrandom2);
            }
        }
    }
}
