package prog_teszt;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class prog_teszt {

  public static void main(String argv[]) throws IOException {
      //Ellenőrizzük, hogy van-e újabb verzió, ha van, akkor engedélyt kérünk a letöltésre.
      URL version = new URL("https://raw.githubusercontent.com/Athes/prog_teszt/master/src/prog_teszt/version");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(version.openStream()));

        double inputLine=in.read();
        System.out.println(inputLine);
        in.close();
        
        //ov=our version
        double ov=1.0;
        if (ov<inputLine){
            System.out.println("Van újabb verzió");
        }
      
      
      
      
                 URL url;
                   
		try {
			File f = new File("./feladatok.xml");
                        if(!f.exists() && !f.isDirectory()) {
                            
                        // Letöltjük a forrásfájlt, ha még nincs meg.
                           
                            URL website = new URL("http://thokay.hu/feladatok.xml");
                            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                            FileOutputStream fos = new FileOutputStream("./feladatok.xml");
                            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                            System.out.println("A forrásfájlt letöltöttem.");
                        }

                        //Megkérdezzük a felhasználótól, hogy hány kérdésre szeretne válaszolni.
                        System.out.println("Hány kérdést kér?");
                        Scanner hanyszor = new Scanner(System.in);
                        int j = hanyszor.nextInt();
                        int i;

        for(i=0;i<j;i++){
            //Felcsúsztatjuk a kimenetet, ezzel tagolunk.
            
                           clearScreen();
        //Feldolfozzuk az XML fájlt.
	File fXmlFile = new File("./feladatok.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();

	//Generálunk egy random számot 0-210 között, majd hozzáadunk 1-et, mert 211 kérdés van.
	Random rand = new Random();
        int randomNumber = rand.nextInt(210)+1;
 	//Beolvassuk a feladatot.	
	NodeList nList = doc.getElementsByTagName("feladat"+randomNumber);
			
	
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			
			System.out.println("Kérdés: " + eElement.getElementsByTagName("feladat_kerdes").item(0).getTextContent());
			System.out.println("Válaszlehetőségek: ");
                        System.out.println(eElement.getElementsByTagName("feladat_valasz1").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz2").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz3").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("feladat_valasz4").item(0).getTextContent());
			System.out.println("Az Ön válasza: ");
       
      Scanner megoldas = new Scanner(System.in);
      String inputString = megoldas.nextLine();
 
      
      String m=eElement.getElementsByTagName("megoldas").item(0).getTextContent();
      if            (   m.equals(inputString)) {
          System.out.println("Gratulálunk! A megoldás: "+eElement.getElementsByTagName("megoldas").item(0).getTextContent());
                    } else {
          System.out.println("Rossz válasz! A megoldás: "+eElement.getElementsByTagName("megoldas").item(0).getTextContent());
                    }

		}
	}
   }
    }   catch (Exception e) {
	e.printStackTrace();
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