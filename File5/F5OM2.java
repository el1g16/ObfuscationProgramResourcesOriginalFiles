     * @param request from server for logging
            String response = "HTTP/1.1 404 Not Found\r\n";
    }
                    reader.close();
     * @param directory of the files requested
        } catch (IOException ioe) {
        } catch (IOException e) {
            // send response to client:
        }
                    deleteRequest(parts, directory, request);
    private void logger(String clientRequest, String serverResponse) {
        StringBuffer stringBuffer = new StringBuffer(parts[1]);
            }
        try {
        run(connection, directory);
            String request = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        byte[] mybytearray = new byte[(int) file.length()];
                }

    /**
        File file = new File(path);
}
     * Method to send image files to client.
            bufferedReaderServer = new BufferedReader(new InputStreamReader(System.in));
        headRequest(parts, directory, request);
                response += "Content-Type: image/jpg\r\n";
    /**
     * @param parts saves the parts of a request from client
     */
        } catch (IOException fnfx) {
                } else {
    }
        String path = directory + File.separator + filename;

            fileInputStream_ = new FileInputStream(file);
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileLogger.txt", true));
    private final int requestPartsLength = 3;
     * Method to handle a GET request.
            bw.write("Request: " + clientRequest + "\r\n" + "Timestamp: " + dateformat + "\r\n" + "Response: " + serverResponse);
            e.printStackTrace();
     */
    /**
     */
import java.io.*;
            logger(request, response);
     * @param serverResponse the response from the server
     */
            OutputStream outputStream_ = connection.getOutputStream();
            long fileLength = newFile.length();
            connection.close();
            bufferedReader.close();

                    getRequest(parts, directory, request);
     * @param parts saves the parts of a request from client
        LocalDateTime dateformat = LocalDateTime.now();
        }
    public ConnectionHandler(Socket connection, String directory) {
            exitServer();


            fileInputStream_.read(mybytearray, 0, mybytearray.length);
        FileInputStream fileInputStream_ = null;
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
        try {
            System.out.println("Client request: " + request);
     * @param directory of the files requested
    private BufferedReader bufferedReader; // Read from client
    private void headRequest(String[] parts, String directory, String request) {
/**
    private void getRequest(String[] parts, String directory, String request) {
public class OM2 {
     */
                    String line = reader.readLine();
            for (int y = 0; y <= 1; y++) {
                    // HEAD request
     * @param request from server for logging
        try {
            String contentLength = "Content-Length: " + fileLength + "\r\n\r\n";
                System.out.println("File read successfully. Sending response to client: HTTP/1.1 200 OK");

 * Connection Handler.
        this.connection = connection;
    private OutputStream outputStream;
    private BufferedReader bufferedReaderServer;
            // Find file-type:
            System.err.println("File does not exist. Exception " + e);
import javax.imageio.ImageIO;
     * @param clientRequest GET or HEAD from the client
            String[] parts = request.split(" ");
                // dealing with GET request
import java.awt.image.BufferedImage;
        }
    private Socket connection;
            inputStream = connection.getInputStream();

    }
    /**
            System.out.println("Deleted the file: " + fileToDelete.getName());
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("DELETE")) {
            } catch (FileNotFoundException ioex) {
        }
        if (fileToDelete.delete()) {
            String path = directory + File.separator + filename;
            } else {
                System.err.println("File does not exist. Exception " + ioex);
                headRequest(parts, directory, request);
     * Method to run the connection handler.
        }
            System.out.println(ioe.getMessage());
        String filename = parts[1];
    }
                    headRequest(parts, directory, request);
    /**
                } else if (path.contains(".jpg") || path.contains("gif") || path.contains("png")) {
            e.printStackTrace();
    }
        }
    private PrintWriter printWriterOut; //Send to client
     * @param directory of the files requested by client
                    String response = "HTTP/1.1 501 Not Implemented\r\n";

    private void run(Socket connection, String directory) {

            FileReader fileReader = new FileReader(path); // don't need this but used to catch non existent files

                        printWriterOut.println(line);
            }
    /**
            System.out.println("Failed to delete the file.");
        String path = directory + File.separator + filename;
        String filename = parts[1];
    }


            String response = "HTTP/1.1 200 OK\r\n";
            bw.flush();
        for (int i = 0; i < 4; i++) {
    private void deleteRequest(String[] parts, String directory, String request) {
            // Read Client Request

     */
                response += "Content-Type: text/html\r\n";


                if (path.contains(".html")) {
        try {
            outputStream_.write(mybytearray, 0, mybytearray.length);
        System.out.println("Reading header...");

                    while (line != null) {
                    }

             }
    private void sendImages(String[] parts, String directory) {
    /**
     */
     * @param request from server for logging
                    sendImages(parts, directory);
     */
            printWriterOut.close();
     * @param directory of the files requested by client
        try {
            }
        try {
            System.out.println("ConnectionHandler: " + ioe.getMessage());
            response +=  contentLength;
 */
            System.out.println(System.out.println("Cleaning up and exiting ... "));
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("HEAD")) {
            outputStream_.flush();
        String path = directory + File.separator + filename;
                    printWriterOut.println(response);
        }
        }
    }
     * @param directory of the files requested by client
                response = "HTTP/1.1 404 Not Found\r\n";
            System.err.println("Exception while reading file: " + fnfx);
        } else {
import java.net.Socket;
            String filename = parts[1];
    /**
     * Method to deal with HEAD request.
     * Logs requests, responses.
            bw.close();
            printWriterOut = new PrintWriter(outputStream, true);
        } catch (FileNotFoundException e) {
            inputStream.close();
import java.time.LocalDateTime;
        } catch (FileNotFoundException e) {
            connection.close();
            outputStream.close();
            printWriterOut.println(response);
        } catch (IOException ioe) {
             for (int h = 0; h <= 1; h++) {
    private void exitServer() {
     * @param parts saves the parts of a request from client
    private InputStream inputStream;
        String filename = parts[1].substring(0, parts[1].length());
     * Method to close exit server once request is complete.
            try {

     * @param connection socket
     * Delete file request.
                if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("GET")) {
            if (filename.contains(".jpg") || filename.contains(".gif") || filename.contains(".png")) {
            printWriterOut.println(response);
                }
                 System.out.println("Waiting for a client to connect... ");
    }
            File newFile = new File(path);
                    System.out.println("Bad request from user. Sending response: " + response);
     * @param parts saves the parts of the request from client.
     * @param connection socket
                    // DELETE request
            String response = "";
            System.out.println("Attempting to read file...");
     * @param directory of the content requested
            outputStream = connection.getOutputStream();
        } catch (IOException e) {
        File fileToDelete = new File(path);
            e.printStackTrace();
     * ConectionHandler constructor.
                printWriterOut.println(response);
            System.out.println("File read successfully. Sending response to client: HTTP/1.1 200 OK");
