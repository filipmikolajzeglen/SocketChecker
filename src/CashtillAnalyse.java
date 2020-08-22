import java.io.IOException;
import java.net.*;

public class CashtillAnalyse {
    private boolean isAnalised = false;
    private String message = "";
    private int code = 0;

    public String getAnalyse() {
        if (!this.isAnalised) {
            this.analyse();
        }
        return this.message;
    }

    public boolean getState() {
        if (!this.isAnalised) {
            this.analyse();
        }
        return this.code == 0;
    }

    private void analyse() {
        try {
            URL url = new URL("https://clientcode.webside.com/");
            HttpURLConnection connection;
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int code = connection.getResponseCode();
            this.message = "Connection GOOD. Code: " + code;
            System.out.println(this.message);
        } catch (Exception e) {
            this.message = "Error Connection";
            System.out.println(this.message);
        }
    }
}
