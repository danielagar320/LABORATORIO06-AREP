package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import static spark.Spark.*;

public class RoundRobin {

    public static String url = "http://172.19.16.1:3400";
    private static final String USER_AGENT = "Mozilla/5.0";


    public static void main(String... args){

        port(getPort());

        staticFiles.location("/frontend");

        get("/app", (req,res) -> getItem());

        post("/app", (req,res) -> getPost(req.body()));

    }

    public static String getItem() throws IOException {
        String[] direcciones = {};
        URL obj = new URL(url + getRoundRobin() + "4567/service");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "GET request not worked";
        }
    }

    private static String getRoundRobin(){
        String[] direcciones = {};
        Random i = new Random();
        return direcciones[i.nextInt(3)];
    }

    public static String getPost(String text) throws IOException {
        URL obj = new URL(url + getRoundRobin() + "/service");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/plain");
        con.setRequestProperty("Accept", "text/plain");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(text.getBytes());
        os.flush();
        os.close();
        System.out.println("ADICIONO " + con.getResponseCode());

        return getItem();
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4566;
    }
}
