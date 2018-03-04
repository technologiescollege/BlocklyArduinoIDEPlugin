package blocklyarduino;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import processing.app.Editor;
import processing.app.tools.Tool;


public class BlocklyArduino implements Tool {
  Editor editor;

  public void init(Editor editor) {
    this.editor = editor;
  }

  public String getMenuTitle() {
    return "Blockly@rduino";
  }

  public void run() {
	  try {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(new String[] { "F:/speedyfox.exe" } );
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
}
