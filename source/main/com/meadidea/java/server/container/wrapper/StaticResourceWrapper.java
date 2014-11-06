package com.meadidea.java.server.container.wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.meadidea.java.server.http.HttpRequest;
import com.meadidea.java.server.http.HttpResponse;

public class StaticResourceWrapper implements Wrapper{
	  private static final int BUFFER_SIZE = 1024;
	  

	@Override
	public void process(HttpRequest request, HttpResponse response) {
		try {
			this.sendStaticResource(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendStaticResource(HttpRequest request, HttpResponse response) throws IOException {
	    byte[] bytes = new byte[BUFFER_SIZE];
	    FileInputStream fis = null;
	    try {
	      /* request.getUri has been replaced by request.getRequestURI */
	      File file = new File(Constants.WEB_ROOT, request.getRequestURI());
		    System.out.println("##StaticResourceWrapper##file.path="+file.getAbsolutePath());
	      fis = new FileInputStream(file);
	      /*
	         HTTP Response = Status-Line
	           *(( general-header | response-header | entity-header ) CRLF)
	           CRLF
	           [ message-body ]
	         Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
	      */
	      int ch = fis.read(bytes, 0, BUFFER_SIZE);
	      while (ch!=-1) {
	    	  response.getOutput().write(bytes, 0, ch);
	        ch = fis.read(bytes, 0, BUFFER_SIZE);
	      }
	    }
	    catch (FileNotFoundException e) {
	      String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
	        "Content-Type: text/html\r\n" +
	        "Content-Length: 23\r\n" +
	        "\r\n" +
	        "<h1>File Not Found</h1>";
	      response.getOutput().write(errorMessage.getBytes());
	    }
	    finally {
	      if (fis!=null)
	        fis.close();
	    }
	  }

}
