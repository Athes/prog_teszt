package prog_teszt;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Scanner;
import java.util.Random;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;
//import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class prog_teszt {

  public static void main(String argv[]) throws IOException {
      System.out.println("Hányszor gyakoroljunk?");
      Scanner hanyszor = new Scanner(System.in);
      int j = hanyszor.nextInt();
      //hanyszor.close();
      int i;

   for(i=0;i<j;i++){
                 URL url;
                 
                 //Toroljuk a kepernyot
                    clearScreen();
                    
		try {
			File f = new File("./feladatok.xml");
                        if(!f.exists() && !f.isDirectory()) {
                            System.out.println("Nem találom a forrásfájlt.");
                            System.out.println("Adja meg a forrásfájl helyét a következő formában: http://domain/feladatok.xml");
                            Scanner forras = new Scanner(System.in);
                            String forrasFajl = forras.next();
                        //    forras.close();
                        // get URL content
                           
                            URL website = new URL(forrasFajl);
                            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                            FileOutputStream fos = new FileOutputStream("./feladatok.xml");
                            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//			url = new URL(forrasFajl);
//			URLConnection conn = url.openConnection();
//
//			// open the stream and put it into BufferedReader
//			BufferedReader br = new BufferedReader(
//                               new InputStreamReader(conn.getInputStream()));
//
//			String inputLine;
//
//			//save to this filename
//			String fileName = "./feladatok.xml";
//			File file = new File(fileName);
//
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			//use FileWriter to write file
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//
//			while ((inputLine = br.readLine()) != null) {
//				bw.write(inputLine);
//			}
//
//			bw.close();
//			br.close();

			System.out.println("Done");
                        }
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//fájl letöltése
	File fXmlFile = new File("./feladatok.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	doc.getDocumentElement().normalize();

	
	Random rand = new Random();
        int randomNumber = rand.nextInt(210)+1;
 		
	NodeList nList = doc.getElementsByTagName("feladat"+randomNumber);
			
	//System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("Sorszám: " + eElement.getAttribute("sorszam"));
			System.out.println("Kérdés: " + eElement.getElementsByTagName("feladat_kerdes").item(0).getTextContent());
			System.out.println("Válaszlehetőségek: ");
                        System.out.println(eElement.getElementsByTagName("feladat_valasz1").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz2").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz3").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz4").item(0).getTextContent());
			System.out.println("Az Ön válasza: ");
       
      Scanner megoldas = new Scanner(System.in);
      String inputString = megoldas.nextLine();
 
      //megoldas.close(); 
      String m=eElement.getElementsByTagName("megoldas").item(0).getTextContent();
      if            (   m.equals(inputString)) {
          System.out.println("Gratulálunk! A megoldás: "+eElement.getElementsByTagName("megoldas").item(0).getTextContent());
                    } else {
          System.out.println("Rossz válasz! A megoldás: "+eElement.getElementsByTagName("megoldas").item(0).getTextContent());
                    }

		}
	}
    }   catch (Exception e) {
	e.printStackTrace();
    }
    
  }
}
  
  
  // Kiiratunk 3 ures sort, hogy tagolt legyen
private static final int PAGE_SIZE = 3;

private static void clearScreen() {
    for (int i = 0; i < PAGE_SIZE; i++) {
        System.out.println();
    }
}
  
}

  
