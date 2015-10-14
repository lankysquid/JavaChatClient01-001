/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.util.Scanner;

/**
 *
 * @author stefan
 */
public class ChatClientApp {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter desired chat port: ");
        Scanner keyboard = new Scanner(System.in);
        int port = keyboard.nextInt();
        System.out.println( "Opening Chat client on port " + port);
        ChatClient client = new ChatClient("localHost", port);
        System.out.println("System End.");      
    }
}
