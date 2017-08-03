/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverexile;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dark
 */
public class Get  implements HttpHandler {

         @Override
         public void handle(HttpExchange he) throws IOException {
                 // parse request
                 Map<String, Object> parameters = new HashMap<String, Object>();
                 URI requestedUri = he.getRequestURI();
                 String query = requestedUri.getRawQuery();
                 System.out.println("esta en el methodo get "+query);
                 //parseQuery(query, parameters);

                 // send response
                 String response = "";
                 for (String key : parameters.keySet())
                          response += key + " = " + parameters.get(key) + "\n";
                 he.sendResponseHeaders(200, response.length());
                 OutputStream os = he.getResponseBody();
                 os.write(response.toString().getBytes());
                 os.close();
         }
}