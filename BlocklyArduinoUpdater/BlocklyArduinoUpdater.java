package blocklyarduinoupdater;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import processing.app.Editor;
import processing.app.tools.Tool;


public class BlocklyArduinoUpdater implements Tool {
  Editor editor;

  public void init(Editor editor) {
    this.editor = editor;
  }

  public String getMenuTitle() {
    return "Blockly@rduino updater";
  }

  public void run() {
        //String[] run = {"java","-jar","UpdateApp.jar"};
		String[] run = {"UpdateApp.jar"};
        try {
            Runtime.getRuntime().exec(run);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
  }
}
