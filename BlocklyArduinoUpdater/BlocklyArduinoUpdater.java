package blocklyarduinoupdater;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
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
	  try {		
		String PathToExec = Paths.get(".").toAbsolutePath().normalize().toString();
		PathToExec += "\\tools\\BlocklyArduinoUpdater\\tool\\";
		//System.out.println("Current relative path is: " + PathToExec);
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(new String[] { PathToExec + "updater.bat" } );
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
