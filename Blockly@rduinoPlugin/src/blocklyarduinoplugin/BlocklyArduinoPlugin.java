/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklyarduinoplugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import processing.app.Editor;

import processing.app.tools.Tool;

/**
 *
 * @author Tom for Dwenguino https://github.com/dwengovzw/Blockly-for-Dwenguino
 */
public class BlocklyArduinoPlugin implements Tool {

    public static Editor editor;
    
    public static long startTimestamp = 0;
    
    private final int JFXPANEL_WIDTH_INT = 1024;
    private final int JFXPANEL_HEIGHT_INT = 768;       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlocklyArduinoPlugin.startApplication();
    }

    public static void startApplication(){
        startTimestamp = System.currentTimeMillis();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Platform.setImplicitExit(false);
                BlocklyArduinoPlugin plugin = new BlocklyArduinoPlugin();
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (Exception e) {
                }
                
                try {
                    plugin.initGUI();
                    }catch(NullPointerException ex){
                    //System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
                }
            }
        });
    }

    private JFrame window;
    private JFXPanel jfxPanel;
    private Browser browser;   
    
    private void initGUI()  {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setSize(1024, 768);
        window.setLocationRelativeTo(null);
        window.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Platform.runLater(() -> {
                        //browser.webEngine.load("about:blank");
                        SwingUtilities.invokeLater(() -> {
                            //System.out.println("test");
                            try{
                                e.getWindow().dispose();
                            }catch (NullPointerException ex){
                                //System.out.println("This is a bug in java: https://bugs.openjdk.java.net/browse/JDK-8089371");
                            }                            
                        });
                    });
                });  
            }
        });
        
        jfxPanel = new JFXPanel();
        jfxPanel.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        window.add(jfxPanel, BorderLayout.CENTER);
        window.setVisible(true);
        
        Platform.runLater(() -> {
            showBrowser();
        });        
    }

    private void showBrowser() { 
            try {
                browser = new Browser(editor);
                jfxPanel.setScene(new Scene(browser, 800, 600, Color.web("#666970")));
            } catch (NullPointerException ex) {
                //System.out.println("Houston we have a problem");
                //System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
            }        
    }
    
    public static void printMemoryUsage(){
        Runtime runtime = Runtime.getRuntime();
        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
        sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
        sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
        sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");

        //System.out.println(sb.toString());
    }

    @Override
    public void run() {
        try{
            BlocklyArduinoPlugin.editor.toFront();
            // Fill in author.name, author.url, tool.prettyVersion and
            // project.prettyName in build.properties for them to be auto-replaced here.
            BlocklyArduinoPlugin.startApplication();
        }catch(NullPointerException ex){
            //System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        }        
    }

    @Override
    public String getMenuTitle() {
        return "Blockly@rduino";
    }

    @Override
    public void init(Editor editor) {
        BlocklyArduinoPlugin.editor = editor;        
    }
}