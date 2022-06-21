public class CampoP2 {
    public static void MostrarCampoIAFake(String campoIAFake[][]) {
        int c, i;
        System.out.println(" Seu campo:");
        System.out.println("");
        System.out.println("   0    1    2    3    4    5    6    7    8    9");
        for (c = 0; c <= campoIAFake.length - 1; c++) {
            for (i = 0; i <= campoIAFake.length - 1; i++) {
                System.out.println("| " + campoIAFake[c][i] + " ");
            }
            System.out.println("| " + c);
        }
    }
}
