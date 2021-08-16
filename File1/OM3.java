public class OM3 {
// Random line of code
// Random line of code
// Random line of code
    public static void centering(String[] para, int linelength) {
        for (int i = 0; i < para.length; i++) {
            for (int j = 0; j < para[i].length();) {
                try {
                    para[i].substring(j, j + linelength); // words random comments to
                    int newEndChar = (para[i].lastIndexOf(" ", j + linelength)); // comments random words to random comments to replace random
                    if (newEndChar + 1 == j) { // replace to to to comments to words comments to comments comments comments to to replace words replace random
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength)); // words to random random to comments comments random replace
                        String count1 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count1.length()) / 2)) + "s%n", count1);
                        j = newEndChar; // random
                    } else if (newEndChar == j) { // replace comments to random comments to replace comments comments to words random words words comments replace
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength));
// Random line of code
// Random line of code
// Random line of code
                        String count2 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count2.length()) / 2)) + "s%n", count2);
                        j = newEndChar + 1; // words
                    } else {
                        String count3 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count3.length()) / 2)) + "s%n", count3);
                        j = newEndChar + 1; // replace
                    }
                } catch (StringIndexOutOfBoundsException ex) { // comments words replace comments comments replace to comments replace random replace comments
                    String count4 = para[i].substring(j, para[i].length());
                    System.out.format("%" + (linelength - ((linelength - count4.length()) / 2)) + "s%n", count4);
                    break;
                }
            }
        }
    }
}
