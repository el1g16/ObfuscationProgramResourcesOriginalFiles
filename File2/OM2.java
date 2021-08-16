      e.printStackTrace();

      return split;
    } catch (IOException e) {
      outputStream = clientSocket.getOutputStream();
    String[] response = new String[0];


    int[] response = new int[12];
  @Override
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));

      printWriterToServer.println(clientRequest);
      clientSocket = new Socket(host, port);

    try {
  public String[] getLeagueTableForChallenge(int challengeId) {
  @Override
import java.net.Socket;
  int port;
  @Override

    try {
 * Implementation of request handler. A request handler handles all requests to the server.



      printWriterToServer = new PrintWriter(outputStream, true);

      outputStream = clientSocket.getOutputStream();
          split[i] = split[i].substring(1, split[i].length()-1);

      inputStream = clientSocket.getInputStream();
      //Turn String to int[]
      return response;
      printWriterToServer.println(clientRequest);

    } catch (IOException e) {
      printWriterToServer.println(clientRequest);

    }


        response[i] = Integer.parseInt(split[i]);
      outputStream = clientSocket.getOutputStream();

    name = nameSplit[0];
      outputStream = clientSocket.getOutputStream();
    } catch (UnknownHostException e) {
  }
    }

      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
        if (split[i].contains("\"")) {
  }

      inputStream = clientSocket.getInputStream();
    try {

      printWriterToServer.println(clientRequest);
      String clientRequest = "GET http://localhost:8080/checkSet/?cards="+cards[0]+","+cards[1]+","+cards[2]+"&challengeId="+challengeId;
      throw new Error("challengeId does not exist");
      String clientRequest = "GET http://localhost:8080/getNumberOfSets/"+challengeId;
      }
      printWriterToServer.println(clientRequest);
      clientSocket = new Socket(host, port);
import java.net.UnknownHostException;

      outputStream = clientSocket.getOutputStream();
      clientSocket = new Socket(host, port);
  public int[] fetchChallengeDeck(int challengeId) {
      inputStream = clientSocket.getInputStream();

    }
    Boolean response = false;
    } catch (IOException e) {
        response = true;
      // remove "{ }"

      String clientRequest = "GET http://localhost:8080/getLeagueTable/"+challengeId;
      responseFromServer = responseFromServer.substring(1, responseFromServer.length()-1);
    return response;
  }
  }
      e.printStackTrace();

  Socket clientSocket;

  @Override
      for (int i = 0; i < split.length; i++) {

      if (responseFromServer.equals("true")) {
    if (challengeId <0 || challengeId > 3) {
      e.printStackTrace();
      String clientRequest = "GET http://localhost:8080/challengeDeck/"+challengeId;
      String[] split = responseFromServer.split(":|,");
      return response;
      printWriterToServer = new PrintWriter(outputStream, true);
    int response = 1111;
  BufferedReader bufferedReaderResponseReader;

 */
  }
    }
      String responseFromServer = bufferedReaderResponseReader.readLine();

  @Override
    try {
    return response;
      e.printStackTrace();


    port = 8080;



    if (challengeId <0 || challengeId > 3) {
      String responseFromServer = bufferedReaderResponseReader.readLine();

      clientSocket = new Socket(host, port);
    } catch (UnknownHostException e) {
        }
    }
      e.printStackTrace();
  String host;


      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      printWriterToServer = new PrintWriter(outputStream, true);


      e.printStackTrace();
      //Turn String to int[]
  public void updateLeagueTableForChallenge(int challengeId, String name, long time) {

      String responseFromServer = bufferedReaderResponseReader.readLine();

      printWriterToServer = new PrintWriter(outputStream, true);
    return response;
      for (int i = 0; i < split.length; i++) {
      e.printStackTrace();
    }
    }
package stacs.starcade.client;
public class OM2 {
      e.printStackTrace();
      String responseFromServer = bufferedReaderResponseReader.readLine();
      }
    try {
  public RequestHandler() {
      String[] split = responseFromServer.split(",");
    host = "localhost";
      split[0] = split[0].substring(1);
}
      response = Integer.parseInt(responseFromServer);

      split[split.length-1] = split[split.length-1].substring(0, 4);

  PrintWriter printWriterToServer;
  InputStream inputStream;
    } catch (IOException e) {
      inputStream = clientSocket.getInputStream();

    String[] nameSplit = name.split(" ");
      e.printStackTrace();
  public int fetchSetsIncludedInChallenge(int challengeId) {
import java.io.*;

  public boolean checkSet(int[] cards, int challengeId) {
      clientSocket = new Socket(host, port);

  }
      inputStream = clientSocket.getInputStream();
    return response;
/**
      return response;
      printWriterToServer = new PrintWriter(outputStream, true);
      throw new Error("challengeId does not exist");
    } catch (UnknownHostException e) {
    } catch (UnknownHostException e) {

  OutputStream outputStream;
      String clientRequest = "POST http://localhost:8080/updateLeagueTable/"+challengeId+"/"+name+"/"+time;
    } catch (IOException e) {
