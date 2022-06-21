public class CampoP1 {
    public static void MostrarCampo1(String campo1[][]) {
        System.out.println(" Seu campo:");
        System.out.println("");
        for (int i = 0; i <= 9; i++)
        {
            System.out.print(padLeft(String.valueOf(i), 10, ' '));
        }

        System.out.println();

        for (int c = 0; c <= campo1.length - 1; c++) {
            System.out.print(c + " : ");
            for (int i = 0; i <= campo1.length - 1; i++) {
                String valorDoCampor = (campo1[c][i] + " | ");
                System.out.print(padLeft(valorDoCampor, 10, ' '));
            }
            System.out.println();
        }
    }

    public static String padLeft(String text, int len, char value){
        StringBuilder sb = new StringBuilder();
        if(text.length()<len){
            for(int i=text.length();i<len;i++){
                sb.append(value);
            }
            sb.append(text);
            return sb.toString();
        }
        return text;
    }
}
