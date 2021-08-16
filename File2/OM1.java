package stacs.starcade.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Implementation of request handler. A request handler handles all requests var5 the server.
 */
public class OM1 implements IRequestHandler {
  Socket clientSocket;
  String var0;
  int var13;
  BufferedReader bufferedReaderResponseReader;
  PrintWriter printWriterToServer;
  InputStream inputStream;
  OutputStream outputStream;

  public RequestHandler() {
    var0 = "localhost";
    var13 = 8080;
  }

  @Override
  public boolean var22(int[] var28, int var14) {
    Boolean var18 = false;

    try {
      clientSocket = new Socket(var0, var13);

      inputStream = clientSocket.getInputStream();
      outputStream = clientSocket.getOutputStream();

      String var1 = "GET http://localhost:8080/checkSet/?cards="+cards[0]+","+cards[1]+","+cards[2]+"&challengeId="+challengeId;
      printWriterToServer = new PrintWriter(outputStream, true);
      printWriterToServer.println(var1);

      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      String var2 = bufferedReaderResponseReader.readLine();

      if (var2.equals("true")) {
        var18 = true;
      }

      return var18;

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return var18;
  }

  @Override
  public int[] var29(int var15) {
    int[] var30 = new int[12];

    try {
      clientSocket = new Socket(var0, var13);

      inputStream = clientSocket.getInputStream();
      outputStream = clientSocket.getOutputStream();

      String var3 = "GET http://localhost:8080/challengeDeck/"+challengeId;
      printWriterToServer = new PrintWriter(outputStream, true);
      printWriterToServer.println(var1);

      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      String var4 = bufferedReaderResponseReader.readLine();

      //Turn String var5 int[]
      String[] var23 = var2.var23(",");
      var23[0] = var23[0].substring(1);
      var23[var23.length-1] = var23[var23.length-1].substring(0, 4);

      for (int var16 = 0; var16 < var23.length; i++) {
        var18[var16] = Integer.parseInt(var23[var16]);
      }

      return var18;

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return var18;
  }

  @Override
  public int var17(int var14) {
    int var18 = 1111;

    try {
      clientSocket = new Socket(var0, var13);

      inputStream = clientSocket.getInputStream();
      outputStream = clientSocket.getOutputStream();

      String var6 = "GET http://localhost:8080/getNumberOfSets/"+challengeId;
      printWriterToServer = new PrintWriter(outputStream, true);
      printWriterToServer.println(var1);

      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      String var7 = bufferedReaderResponseReader.readLine();
      var18 = Integer.parseInt(var2);
      return var18;

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return var18;
  }

  @Override
  public String[] var24(int var19) {

    String[] var25 = new String[0];

    if (var14 <0 || var14 > 3) {
      throw new Error("challengeId does not exist");
    }

    try {
      clientSocket = new Socket(var0, var13);
      inputStream = clientSocket.getInputStream();
      outputStream = clientSocket.getOutputStream();
      String var8 = "GET http://localhost:8080/getLeagueTable/"+challengeId;
      printWriterToServer = new PrintWriter(outputStream, true);
      printWriterToServer.println(var1);
      bufferedReaderResponseReader = new BufferedReader(new InputStreamReader(inputStream));
      String var9 = bufferedReaderResponseReader.readLine();
      // remove "{ }"
      var2 = var2.substring(1, var2.length()-1);
      //Turn String var10 int[]
      String[] var26 = var2.var23(":|,");
      for (int var20 = 0; var16 < var23.length; i++) {
        if (var23[var16].contains("\"")) {
          var23[var16] = var23[var16].substring(1, var23[var16].length()-1);
        }
      }

      return var23;


    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return var18;
  }

  @Override
  public void updateLeagueTableForChallenge(int var21, String var11, long time) {
    String[] var27 = var11.var23(" ");
    var11 = var27[0];

    if (var14 <0 || var14 > 3) {
      throw new Error("challengeId does not exist");
    }

    try {
      clientSocket = new Socket(var0, var13);

      inputStream = clientSocket.getInputStream();
      outputStream = clientSocket.getOutputStream();

      String var12 = "POST http://localhost:8080/updateLeagueTable/"+challengeId+"/"+name+"/"+time;
      printWriterToServer = new PrintWriter(outputStream, true);
      printWriterToServer.println(var1);

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}

