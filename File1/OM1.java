public class OM1 {
    public static void b( String[] var8, int var4) {
        for (int var5 = 0; var5 < var8.length; i++) {
            for (int var6 = 0; var6 < var8[var5].length();) {
                try {
                    var8[var5].substring(var6, var6 + var4); // catch out last line
                    int var7 = (var8[var5].lastIndexOf(" ", var6 + var4)); // finds index of last full word within word count
                    if (var7 + 1 == var6) { // check if word length is larger than the line_length but no space at the end of the line
                        var7 = 1 + (var8[var5].indexOf(" ", var6 + var4)); // if yes then move to index of subsequent space
                        String var0 = var8[var5].substring(var6, var7);
                        System.out.format("%" + (var4 - ((var4 - var0.length()) / 2)) + "s%n", var0);
                        var6 = var7; // one
                    } else if (var7 == var6) { // check if word length is larger than the line_length with a space as the last char
                        var7 = 1 + (var8[var5].indexOf(" ", var6 + var4));
                        String var1 = var8[var5].substring(var6, var7);
                        System.out.format("%" + (var4 - ((var4 - var1.length()) / 2)) + "s%n", var1);
                        var6 = var7 + 1; // two
                    } else {
                        String var2 = var8[var5].substring(var6, var7);
                        System.out.format("%" + (var4 - ((var4 - var2.length()) / 2)) + "s%n", var2);
                        var6 = var7 + 1; // three
                    }
                } catch (StringIndexOutOfBoundsException ex) { // deals with last line of each paragraph that is less that line_length
                    String var3 = var8[var5].substring(var6, var8[var5].length());
                    System.out.format("%" + (var4 - ((var4 - var3.length()) / 2)) + "s%n", var3);
                    break;
                }
            }
        }
    }
}
