import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
/**
 * Connection Handler.
 */
public class ConnectionHandler extends Thread {
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
                // dealing with GET request
                if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("GET")) {
                    getRequest(parts, directory, request);

                    // HEAD request
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("HEAD")) {
                    headRequest(parts, directory, request);

                    // DELETE request
                } else if (parts.length == requestPartsLength && parts[0].equalsIgnoreCase("DELETE")) {
                    deleteRequest(parts, directory, request);

                } else {
                    String response = "HTTP/1.1 501 Not Implemented\r\n";
                    System.out.println("Bad request from user. Sending response: " + response);
                    printWriterOut.println(response);
                }
            }
            exitServer();
        } catch (IOException ioe) {
            System.out.println("ConnectionHandler: " + ioe.getMessage());
        }
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
                    String line = reader.readLine();
                    while (line != null) {
                        printWriterOut.println(line);
                    }
                    reader.close();

                } else if (path.contains(".jpg") || path.contains("gif") || path.contains("png")) {
                    sendImages(parts, directory);
                }

            } catch (FileNotFoundException ioex) {
                System.err.println("File does not exist. Exception " + ioex);
                response = "HTTP/1.1 404 Not Found\r\n";
                printWriterOut.println(response);
            }
        } catch (IOException fnfx) {
            System.err.println("Exception while reading file: " + fnfx);
        }
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
                response += "Content-Type: image/jpg\r\n";
            } else {
                response += "Content-Type: text/html\r\n";
            }
            String contentLength = "Content-Length: " + fileLength + "\r\n\r\n";
            response +=  contentLength;
            // send response to client:
            printWriterOut.println(response);
            logger(request, response);

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist. Exception " + e);
            String response = "HTTP/1.1 404 Not Found\r\n";
            printWriterOut.println(response);
        }
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
            System.out.println("Deleted the file: " + fileToDelete.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to close exit server once request is complete.
     */
    private void exitServer() {
        for (int i = 0; i < 4; i++) {
            System.out.println(System.out.println("Cleaning up and exiting ... "));
        }
        try {
            printWriterOut.close();
            bufferedReader.close();
            inputStream.close();
            outputStream.close();
            connection.close();
             for (int h = 0; h <= 1; h++) {
                 System.out.println("Waiting for a client to connect... ");
             }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
