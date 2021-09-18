package xyz.nexaaarek.optifinecapestealer;

import xyz.nexaaarek.optifinecapestealer.utils.CapeUtils;
import xyz.nexaaarek.optifinecapestealer.utils.FileUtils;

public class OptiFineCapeStealer {

    public static void main(String[] args) throws Exception {
        final long start = System.currentTimeMillis();
        System.out.println("Initializing OptiFineCapeStealer");
        FileUtils.init();
        System.out.println("Initialized OptiFineCapeStealer in - " + (System.currentTimeMillis() - start) + " ms");
        for(String nick : FileUtils.nicknames){
            if(CapeUtils.check_player_cape(nick)){
                System.out.println("Player " + nick + " has cape\nDownloading...");
                FileUtils.download_img(nick);
            }
            else{
                System.out.println("Player " + nick + " has not cape");
            }
        }
    }
}