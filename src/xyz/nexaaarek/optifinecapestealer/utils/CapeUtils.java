package xyz.nexaaarek.optifinecapestealer.utils;

import sun.net.www.protocol.http.HttpURLConnection;

import java.net.URL;

public class CapeUtils {

    public static String api_optifine = "http://s.optifine.net/capes/";

    public static boolean check_player_cape(String nickname) throws Exception {
        URL url = new URL(api_optifine + nickname + ".png");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if(httpURLConnection.getResponseCode() == 200){
            return true;
        }
        else if(httpURLConnection.getResponseCode() == 404){
            return false;
        }
        return false;
    }
}