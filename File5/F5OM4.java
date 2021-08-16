import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
/**
 * Connection Handler.
 */
public class OM4 {
    private Socket connection;
    private InputStream inputStream;
    private OutputStream outputStream;
    private PrintWriter printWriterOut; //Send to client
    private BufferedReader bufferedReader; // Read from client
    private BufferedReader bufferedReaderServer;
    private final int requestPartsLength = 3;
    /**
     * ConectionHandler constructor.
     * @param connection socket
     * @param directory of the files requested
     */
    public ConnectionHandler(Socket connection, String directory) {
        this.connection = connection;
        run(connection, directory);

int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Method to run the connection handler.
     * @param connection socket
     * @param directory of the files requested
     */
    private void run(Socket connection, String directory) {
        try {
            inputStream = connection.getInputStream();
            outputStream = connection.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReaderServer = new BufferedReader(new InputStreamReader(System.in));

            // Read Client Request
            String request = bufferedReader.readLine();
            String[] parts = request.split(" ");
            System.out.println("Client request: " + request);

            printWriterOut = new PrintWriter(outputStream, true);

            for (int y = 0; y <= 1; y++) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                // dealing with GET request
                if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("GET")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    getRequest(parts, directory, request);

                    // HEAD request
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("HEAD")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    headRequest(parts, directory, request);

                    // DELETE request
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("DELETE")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    deleteRequest(parts, directory, request);

int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                } else {
                    String response = "HTTP/1.1 501 Not Implemented\r\n";
                    System.out.println("Bad request from user. Sending response: " + response);
                    printWriterOut.println(response);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            }
            exitServer();
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (IOException ioe) {
            System.out.println("ConnectionHandler: " + ioe.getMessage());
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Method to handle a GET request.
     * @param parts saves the parts of the request from client.
     * @param directory of the content requested
     * @param request from server for logging
     */
    private void getRequest(String[] parts, String directory, String request) {
        try {
            System.out.println("Attempting to read file...");
            String filename = parts[1];
            String path = directory + File.separator + filename;
            String response = "";

            try {

                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                headRequest(parts, directory, request);
                System.out.println("File read successfully. Sending response to client: HTTP/1.1 200 OK");

                if (path.contains(".html")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    String line = reader.readLine();
                    while (line != null) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                        printWriterOut.println(line);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    }
                    reader.close();

                } else if (path.contains(".jpg") || path.contains("gif") || path.contains("png")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                    sendImages(parts, directory);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                }

int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            } catch (FileNotFoundException ioex) {
                System.err.println("File does not exist. Exception " + ioex);
                response = "HTTP/1.1 404 Not Found\r\n";
                printWriterOut.println(response);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (IOException fnfx) {
            System.err.println("Exception while reading file: " + fnfx);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Method to deal with HEAD request.
     * @param parts saves the parts of a request from client
     * @param directory of the files requested by client
     * @param request from server for logging
     */
    private void headRequest(String[] parts, String directory, String request) {
        System.out.println("Reading header...");
        String filename = parts[1];
        String path = directory + File.separator + filename;

        try {
            FileReader fileReader = new FileReader(path); // don't need this but used to catch non existent files
            File newFile = new File(path);
            long fileLength = newFile.length();

            System.out.println("File read successfully. Sending response to client: HTTP/1.1 200 OK");

            String response = "HTTP/1.1 200 OK\r\n";
            // Find file-type:
            if (filename.contains(".jpg") || filename.contains(".gif") || filename.contains(".png")) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                response += "Content-Type: image/jpg\r\n";
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            } else {
                response += "Content-Type: text/html\r\n";
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            }
            String contentLength = "Content-Length: " + fileLength + "\r\n\r\n";
            response +=  contentLength;
            // send response to client:
            printWriterOut.println(response);
            logger(request, response);

int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist. Exception " + e);
            String response = "HTTP/1.1 404 Not Found\r\n";
            printWriterOut.println(response);
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Delete file request.
     * @param parts saves the parts of a request from client
     * @param directory of the files requested by client
     * @param request from server for logging
     */
    private void deleteRequest(String[] parts, String directory, String request) {
        headRequest(parts, directory, request);
        String filename = parts[1];
        String path = directory + File.separator + filename;

        File fileToDelete = new File(path);
        if (fileToDelete.delete()) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            System.out.println("Deleted the file: " + fileToDelete.getName());
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } else {
            System.out.println("Failed to delete the file.");
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Method to send image files to client.
     * @param parts saves the parts of a request from client
     * @param directory of the files requested by client
     */
    private void sendImages(String[] parts, String directory) {
        StringBuffer stringBuffer = new StringBuffer(parts[1]);
        String filename = parts[1].substring(0, parts[1].length());
        String path = directory + File.separator + filename;
        File file = new File(path);
        byte[] mybytearray = new byte[(int) file.length()];
        FileInputStream fileInputStream_ = null;
        try {
            fileInputStream_ = new FileInputStream(file);
            fileInputStream_.read(mybytearray, 0, mybytearray.length);
            OutputStream outputStream_ = connection.getOutputStream();
            outputStream_.write(mybytearray, 0, mybytearray.length);
            outputStream_.flush();
            connection.close();

int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (IOException e) {
            e.printStackTrace();
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Logs requests, responses.
     * @param clientRequest GET or HEAD from the client
     * @param serverResponse the response from the server
     */
    private void logger(String clientRequest, String serverResponse) {
        LocalDateTime dateformat = LocalDateTime.now();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileLogger.txt", true));
            bw.write("Request: " + clientRequest + "\r\n" + "Timestamp: " + dateformat + "\r\n" + "Response: " + serverResponse);
            bw.flush();
            bw.close();
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (IOException e) {
            e.printStackTrace();
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
    }
    /**
     * Method to close exit server once request is complete.
     */
    private void exitServer() {
        for (int i = 0; i < 4; i++) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
            System.out.println(System.out.println("Cleaning up and exiting ... "));
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        }
        try {
            printWriterOut.close();
            bufferedReader.close();
            inputStream.close();
            outputStream.close();
            connection.close();
             for (int h = 0; h <= 1; h++) {
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
                 System.out.println("Waiting for a client to connect... ");
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
             }
int var_a = 5;
int var_b = var_a;
System.out.println(var_b);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
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
