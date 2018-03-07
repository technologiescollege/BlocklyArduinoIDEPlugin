package updateapp;

/**
 *
 * @author Thomas Otero (H3R3T1C)
 */
public class Main {
        
    public static void main(String[] args) {
        try {            
            if (Integer.parseInt(Updater.getLatestVersion()) > Integer.parseInt(Updater.getLocalVersion())) {
                new UpdateInfo(Updater.getWhatsNew());
            } else {
                new UpdateInfo(Updater.getData(Updater.nothingURL));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}