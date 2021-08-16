import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
/**
 * Connection Handler.
 */
public class OM1 extends Thread {
    private Socket connection;
    private InputStream inputStream;
    private OutputStream outputStream;
    private PrintWriter printWriterOut; //Send to client
    private BufferedReader bufferedReader; // Read from client
    private BufferedReader bufferedReaderServer;
    private final int var22 = 3;
    /**
     * ConectionHandler constructor.
     * @param connection socket
     * @param var0 of the files requested
     */
    public ConnectionHandler(Socket connection, String var0) {
        this.connection = connection;
        run(connection, var0);

    }
    /**
     * Method to run the connection handler.
     * @param connection socket
     * @param var0 of the files requested
     */
    private void run(Socket connection, String var1) {
        try {
            inputStream = connection.getInputStream();
            outputStream = connection.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReaderServer = new BufferedReader(new InputStreamReader(System.in));

            // Read Client Request
            String var2 = bufferedReader.readLine();
            String[] var26 = var2.split(" ");
            System.out.println("Client request: " + var2);

            printWriterOut = new PrintWriter(outputStream, true);

            for (int var23 = 0; var23 <= 1; y++) {
                // dealing with GET var2
                if (var26.length == var22 && var26[0].equalsIgnoreCase("GET")) {
                    getRequest(var26, var0, var2);

                    // HEAD var2
                } else if (var26.length == var22 && var26[0].equalsIgnoreCase("HEAD")) {
                    headRequest(var26, var0, var2);

                    // DELETE var2
                } else if (var26.length == var22 && var26[0].equalsIgnoreCase("DELETE")) {
                    deleteRequest(var26, var0, var2);

                } else {
                    String var3 = "HTTP/1.1 501 Not Implemented\r\n";
                    System.out.println("Bad var2 from user. Sending response: " + var3);
                    printWriterOut.println(var3);
                }
            }
            exitServer();
        } catch (IOException ioe) {
            System.out.println("ConnectionHandler: " + ioe.getMessage());
        }
    }
    /**
     * Method to handle a GET var2.
     * @param var26 saves the var26 of the var2 from client.
     * @param var0 of the content requested
     * @param var2 from server for logging
     */
    private void getRequest(String[] var27, String var4, String var2) {
        try {
            System.out.println("Attempting to read file...");
            String var5 = var26[1];
            String var6 = var0 + File.separator + var5;
            String var7 = "";

            try {

                FileReader fileReader = new FileReader(var6);
                BufferedReader reader = new BufferedReader(fileReader);
                headRequest(var26, var0, var2);
                System.out.println("File read successfully. Sending var3 to client: HTTP/1.1 200 OK");

                if (var6.contains(".html")) {
                    String var8 = reader.readLine();
                    while (var8 != null) {
                        printWriterOut.println(var8);
                    }
                    reader.close();

                } else if (var6.contains(".jpg") || var6.contains("gif") || var6.contains("png")) {
                    sendImages(var26, var0);
                }

            } catch (FileNotFoundException ioex) {
                System.err.println("File does not exist. Exception " + ioex);
                var3 = "HTTP/1.1 404 Not Found\r\n";
                printWriterOut.println(var3);
            }
        } catch (IOException fnfx) {
            System.err.println("Exception while reading file: " + fnfx);
        }
    }
    /**
     * Method to deal with HEAD var2.
     * @param var26 saves the var26 of a var2 from client
     * @param var0 of the files requested by client
     * @param var2 from server for logging
     */
    private void headRequest(String[] var28, String var9, String var2) {
        System.out.println("Reading header...");
        String var10 = var26[1];
        String var11 = var0 + File.separator + var5;

        try {
            FileReader fileReader = new FileReader(var6); // don't need this but used to catch non existent files
            File newFile = new File(var6);
            long fileLength = newFile.length();

            System.out.println("File read successfully. Sending var3 to client: HTTP/1.1 200 OK");

            String var12 = "HTTP/1.1 200 OK\r\n";
            // Find file-type:
            if (var5.contains(".jpg") || var5.contains(".gif") || var5.contains(".png")) {
                var3 += "Content-Type: image/jpg\r\n";
            } else {
                var3 += "Content-Type: text/html\r\n";
            }
            String var13 = "Content-Length: " + fileLength + "\r\n\r\n";
            var3 +=  var13;
            // send var3 to client:
            printWriterOut.println(var3);
            logger(var2, var3);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist. Exception " + e);
            String var14 = "HTTP/1.1 404 Not Found\r\n";
            printWriterOut.println(var3);
        }
    }
    /**
     * Delete file var2.
     * @param var26 saves the var26 of a var2 from client
     * @param var0 of the files requested by client
     * @param var2 from server for logging
     */
    private void deleteRequest(String[] var29, String var15, String var2) {
        headRequest(var26, var0, var2);
        String var16 = var26[1];
        String var17 = var0 + File.separator + var5;

        File fileToDelete = new File(var6);
        if (fileToDelete.delete()) {
            System.out.println("Deleted the file: " + fileToDelete.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    /**
     * Method to send image files to client.
     * @param var26 saves the var26 of a var2 from client
     * @param var0 of the files requested by client
     */
    private void sendImages(String[] var30, String var18) {
        StringBuffer stringBuffer = new StringBuffer(var26[1]);
        String var19 = var26[1].substring(0, var26[1].length());
        String var20 = var0 + File.separator + var5;
        File file = new File(var6);
        byte[] mybytearray = new byte[(int) file.length()];
        FileInputStream fileInputStream_ = null;
        try {
            fileInputStream_ = new FileInputStream(file);
            fileInputStream_.read(mybytearray, 0, mybytearray.length);
            OutputStream outputStream_ = connection.getOutputStream();
            outputStream_.write(mybytearray, 0, mybytearray.length);
            outputStream_.flush();
            connection.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Logs requests, responses.
     * @param var21 GET or HEAD from the client
     * @param serverResponse the var3 from the server
     */
    private void logger(String var21, String serverResponse) {
        LocalDateTime dateformat = LocalDateTime.now();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileLogger.txt", true));
            bw.write("Request: " + var21 + "\r\n" + "Timestamp: " + dateformat + "\r\n" + "Response: " + serverResponse);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to close exit server once var2 is complete.
     */
    private void exitServer() {
        for (int var24 = 0; var24 < 4; i++) {
            System.out.println(System.out.println("Cleaning up and exiting ... "));
        }
        try {
            printWriterOut.close();
            bufferedReader.close();
            inputStream.close();
            outputStream.close();
            connection.close();
             for (int var25 = 0; var25 <= 1; h++) {
                 System.out.println("Waiting for a client to connect... ");
             }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
