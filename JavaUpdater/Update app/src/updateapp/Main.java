
package updateapp;

/**
 *
 * @author Thomas Otero (H3R3T1C)
 */
public class Main {

    public static void main(String[] args) {
        try {
            if (Integer.parseInt(Updater.getLatestVersion()) > 0) {
                new UpdateInfo(Updater.getWhatsNew());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
