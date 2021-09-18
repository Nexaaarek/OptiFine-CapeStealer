package xyz.nexaaarek.optifinecapestealer.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static ArrayList<String> nicknames = new ArrayList<String>();
    private static final String pathname = "./capes/";

    public static void init() throws Exception {
        final long start = System.currentTimeMillis();
        System.out.println("Initializing FileUtils");
        File path = new File(pathname);
        System.out.println("Checking if path exists...");
        if(!path.exists()){
            System.out.println("Path not exists\nCreating...");
            path.mkdir();
            System.out.println("Created");
        }
        File file = new File("./nicknames.txt");
        System.out.println("Checking if nicknames file exists...");
        if(!file.exists()){
            System.out.println("Nicknames file not exists\nCreating...");
            file.createNewFile();
            System.out.println("Created");
            System.exit(0);
        }
        else{
            System.out.println("Loading nicknames from file...");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String nick = scanner.next();
                nicknames.add(nick);
            }
            if(nicknames.isEmpty()){
                System.out.println("Please enter nicknames in file");
                System.exit(0);
            }
            System.out.println("Loaded " + nicknames.size() + " nicknames");
        }
        System.out.println("Initialized FileUtils in - " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void download_img(String nickname) throws Exception {
        BufferedImage img;
        img = ImageIO.read(new URL(CapeUtils.api_optifine + nickname + ".png"));
        File file = new File(pathname + nickname + ".png");
        file.createNewFile();
        ImageIO.write(img, "png", file);
    }
}