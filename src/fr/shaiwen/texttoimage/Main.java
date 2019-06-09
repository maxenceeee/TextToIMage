package fr.shaiwen.texttoimage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private String string;
    public Main() throws IOException {
        System.out.println("Ou voulez vous mettre l'image ?");
        File imageRess = new File(scanner.nextLine()+".png");
        System.out.println("Ou ce trouve le fichier du texte ?");
        File textFile = new File(scanner.nextLine());
        if (!textFile.exists()) {
            System.out.println("le fichier n'existe pas !");
            return;
        }
        FileReader reader = new FileReader(textFile);
        BufferedReader br = new BufferedReader(reader);
        char character = ' ';
        String readLine = br.readLine();
        BufferedImage image = new BufferedImage(readLine.length(),readLine.length(), Image.SCALE_DEFAULT);
        int colonne = 0;
        while (readLine != null){
            for (int x = 0;x < readLine.length(); x++) {
                character = readLine.toCharArray()[x];
                if (character == '.') {
                    image.setRGB(x,colonne, Color.HSBtoRGB(180, 100, 97));
                } else {
                    image.setRGB(x,colonne,Color.HSBtoRGB(0, 0, 0));
                }


                System.out.println(colonne);
            }
            colonne++;
            readLine = br.readLine();
        }
        ImageIO.write(image,"png",imageRess);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
