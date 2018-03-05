/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklyarduinoplugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import processing.app.Editor;

/**
 *
 * @author Tom for Dwenguino https://github.com/dwengovzw/Blockly-for-Dwenguino
 */
public class StartupApplet extends JApplet {

    private JFXPanel fxContainer;
    private final int JFXPANEL_WIDTH_INT = 1024;
    private final int JFXPANEL_HEIGHT_INT = 768;
    private Editor editor;
    private Thread activeThread;
    private Browser browser;

    public StartupApplet(Editor editor){
        this.editor = editor;
    }
    
    @Override
    public void init() {
        BlocklyArduinoPlugin.startTimestamp = System.currentTimeMillis();
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        Platform.setImplicitExit(false);
        Runnable activeRunnable = new Runnable() {
            @Override
            public void run() {
                createScene();
            }
        };        
        Platform.runLater(activeRunnable);
    }

    private void createScene() {
        browser = new Browser(editor);
        fxContainer.setScene(new Scene(browser, 1024, 768, Color.web("#666970")));
    }
    
    @Override
    public void stop() {
        browser.webEngine.load("about:blank");
        SwingUtilities.invokeLater(() -> {
            fxContainer.removeNotify();
        });
    }
}