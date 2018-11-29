/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledmatrixplugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.SwingUtilities;

import java.lang.reflect.InvocationTargetException;
import processing.app.Editor;

/**
 *
 * @author Tom for Dwenguino
 */
public class LedMatrixServer {

    private String lastOpenedLocation = System.getProperty("user.home");
    private Editor editor;
    private Window ownerWindow;
    Runnable runHandler;
    Runnable presentHandler;
    
    public LedMatrixServer(Editor editor, Window ownerWindow){
        this.editor = editor;
        this.ownerWindow = ownerWindow;
    }

    public void exit() {
        Platform.exit();
    }
}