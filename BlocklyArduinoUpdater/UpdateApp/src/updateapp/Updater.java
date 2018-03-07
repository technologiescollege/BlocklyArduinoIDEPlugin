package updateapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 *
 * @author Thomas Otero H3R3T1C
 */
public class Updater {
    private final static String versionURL = "http://www.technologiescollege.fr/blockly@rduino/version.txt";
    private final static String historyURL = "http://www.technologiescollege.fr/blockly@rduino/history.txt";    
    
    public final static String nothingURL = "http://www.technologiescollege.fr/blockly@rduino/nothingNew.txt";
    
    public static String getLocalVersion() throws Exception
    {
        String dataLocal = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("version.txt")));
        return dataLocal.substring(dataLocal.indexOf("[version]")+9,dataLocal.indexOf("[/version]"));
    }
    
    public static String getLatestVersion() throws Exception
    {
        String data = getData(versionURL);
        return data.substring(data.indexOf("[version]")+9,data.indexOf("[/version]"));
    }
    
    public static String getWhatsNew() throws Exception
    {
        String data = getData(historyURL);
        return data.substring(data.indexOf("[history]")+9,data.indexOf("[/history]"));
    }
   
    public static String getData(String address)throws Exception
    {
        URL url = new URL(address);        
        InputStream html = null;
        html = url.openStream();        
        int c = 0;
        StringBuffer buffer = new StringBuffer("");
        while(c != -1) {
            c = html.read();            
            buffer.append((char)c);
        }
        return buffer.toString();
    }
}