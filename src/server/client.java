/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * A simple Swing-based client for the capitalization server.
 * It has a main frame window with a text field for entering
 * strings and a textarea to see the results of capitalizing
 * them.
 */
public class client {

    private static BufferedReader in;
    private static PrintWriter out;
    private JTextField dataField = new JTextField(40);
    private JTextArea messageArea = new JTextArea(8, 60);

    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Enter in the
     * listener sends the textfield contents to the server.
     */
    public client() {
           // Layout GUI
   
        // Add Listeners
        dataField.addActionListener((ActionEvent e) -> {
            out.println(dataField.getText());
            String response;
            try {
                response = in.readLine();
                if (response == null || response.equals("")) {
                    System.exit(0);
                }
            } catch (IOException ex) {
                response = "Error: " + ex;
            }
            messageArea.append(response + "\n");
            dataField.selectAll();
        } /**
         * Responds to pressing the enter key in the textfield
         * by sending the contents of the text field to the
         * server and displaying the response from the server
         * in the text area.  If the response is "." we exit
         * the whole application, which closes all sockets,
         * streams and windows.
         */ );
    }
    
    public static String read() {
        String mesajServer = new String();
        try {
            mesajServer = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesajServer;
    }
    public static void send(String codedMessage) {
        out.println(codedMessage);
    }
    
    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     * @throws java.io.IOException
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
      
        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 9999);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server

    }

    /**
     * Runs the client application.
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        client client = new client();
        client.connectToServer();
        singup.mainn();
    }
}
