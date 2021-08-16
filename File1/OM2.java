                    if (newEndChar + 1 == j) { // check if word length is larger than the line_length but no space at the end of the line
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength));
                    int newEndChar = (para[i].lastIndexOf(" ", j + linelength)); // finds index of last full word within word count
                    } else if (newEndChar == j) { // check if word length is larger than the line_length with a space as the last char
                    para[i].substring(j, j + linelength); // catch out last line
                        System.out.format("%" + (linelength - ((linelength - count3.length()) / 2)) + "s%n", count3);
                        String count3 = para[i].substring(j, newEndChar);
                        String count2 = para[i].substring(j, newEndChar);
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength)); // if yes then move to index of subsequent space
        }
}
    public static void centering(String[] para, int linelength) {
                try {
    }
public class OM2 {
                    }
                    } else {
                    System.out.format("%" + (linelength - ((linelength - count4.length()) / 2)) + "s%n", count4);
                        System.out.format("%" + (linelength - ((linelength - count2.length()) / 2)) + "s%n", count2);
                        System.out.format("%" + (linelength - ((linelength - count1.length()) / 2)) + "s%n", count1);
                        j = newEndChar; // one
                        String count1 = para[i].substring(j, newEndChar);
        for (int i = 0; i < para.length; i++) {
            }
                        j = newEndChar + 1; // two
            for (int j = 0; j < para[i].length();) {
                } catch (StringIndexOutOfBoundsException ex) { // deals with last line of each paragraph that is less that line_length
                    break;
                        j = newEndChar + 1; // three
                    String count4 = para[i].substring(j, para[i].length());
                }
