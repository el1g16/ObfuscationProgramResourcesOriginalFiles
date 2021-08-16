public class Original {
    public static void centering(String[] para, int linelength) {
        for (int i = 0; i < para.length; i++) {
            for (int j = 0; j < para[i].length();) {
                try {
                    para[i].substring(j, j + linelength); // catch out last line
                    int newEndChar = (para[i].lastIndexOf(" ", j + linelength)); // finds index of last full word within word count
                    if (newEndChar + 1 == j) { // check if word length is larger than the line_length but no space at the end of the line
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength)); // if yes then move to index of subsequent space
                        String count1 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count1.length()) / 2)) + "s%n", count1);
                        j = newEndChar; // one
                    } else if (newEndChar == j) { // check if word length is larger than the line_length with a space as the last char
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength));
                        String count2 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count2.length()) / 2)) + "s%n", count2);
                        j = newEndChar + 1; // two
                    } else {
                        String count3 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count3.length()) / 2)) + "s%n", count3);
                        j = newEndChar + 1; // three
                    }
                } catch (StringIndexOutOfBoundsException ex) { // deals with last line of each paragraph that is less that line_length
                    String count4 = para[i].substring(j, para[i].length());
                    System.out.format("%" + (linelength - ((linelength - count4.length()) / 2)) + "s%n", count4);
                    break;
                }
            }
        }
    }
}
