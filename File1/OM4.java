public class OM4 {
    public static void centering(String[] para, int linelength) {
        for (int i = 0; i < para.length; i++) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            for (int j = 0; j < para[i].length();) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                try {
                    para[i].substring(j, j + linelength); // catch out last line
                    int newEndChar = (para[i].lastIndexOf(" ", j + linelength)); // finds index of last full word within word count
                    if (newEndChar + 1 == j) { // check if word length is larger than the line_length but no space at the end of the line
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength)); // if yes then move to index of subsequent space
                        String count1 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count1.length()) / 2)) + "s%n", count1);
                        j = newEndChar; // one
                    } else if (newEndChar == j) { // check if word length is larger than the line_length with a space as the last char
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                        newEndChar = 1 + (para[i].indexOf(" ", j + linelength));
                        String count2 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count2.length()) / 2)) + "s%n", count2);
                        j = newEndChar + 1; // two
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    } else {
                        String count3 = para[i].substring(j, newEndChar);
                        System.out.format("%" + (linelength - ((linelength - count3.length()) / 2)) + "s%n", count3);
                        j = newEndChar + 1; // three
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                } catch (StringIndexOutOfBoundsException ex) { // deals with last line of each paragraph that is less that line_length
                    String count4 = para[i].substring(j, para[i].length());
                    System.out.format("%" + (linelength - ((linelength - count4.length()) / 2)) + "s%n", count4);
                    break;
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
}
