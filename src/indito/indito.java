/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indito;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 *
 * @author tokajia
 */
public class indito {
    public static void main(String[] args) throws Exception {

        // Letoltjuk a teszt indito fajlt
                           File i = new File("./prog_teszt.jar");
                            if(!i.exists() && !i.isDirectory()) {
                            System.out.println("Nem találom az inditófájlt, letöltöm.");
                            URL teszt = new URL("http://thokay.hu/prog_teszt.jar");
                            ReadableByteChannel rbc = Channels.newChannel(teszt.openStream());
                            FileOutputStream fos = new FileOutputStream("./prog_teszt.jar");
                            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}}

  

