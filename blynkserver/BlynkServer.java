package blynkserver;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import processing.app.Editor;
import processing.app.tools.Tool;


public class BlynkServer implements Tool {
  Editor editor;

  public void init(Editor editor) {
    this.editor = editor;
  }

  public String getMenuTitle() {
    return "Blynk";
  }

  public void run() {
	  try {		
		String PathToExec = Paths.get(".").toAbsolutePath().normalize().toString();
		//System.out.println("Current relative path is: " + PathToExec);
        Runtime runtime = Runtime.getRuntime();
		Process p = Runtime.getRuntime().exec("cmd /c \"" + PathToExec + "\\tools\\BlynkServer\\tool\\server.bat" + "\"");
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
