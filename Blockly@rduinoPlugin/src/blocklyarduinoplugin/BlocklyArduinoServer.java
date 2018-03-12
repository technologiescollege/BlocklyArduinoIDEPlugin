/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklyarduinoplugin;

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
public class BlocklyArduinoServer {

    private String lastOpenedLocation = System.getProperty("user.home");
    private Editor editor;
    private Window ownerWindow;
    Runnable runHandler;
    Runnable presentHandler;
    
    public BlocklyArduinoServer(Editor editor, Window ownerWindow){
        this.editor = editor;
        this.ownerWindow = ownerWindow;
    }

    /**
     * Paste the created code to the Arduino IDE.
     *
     * @param code Arduino C code
     */
    public void pasteCode(String code) {

        //System.out.println("uploading code");
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //System.out.println("code upload run method started");
                try{
                    //System.out.println("make method");
                    java.lang.reflect.Method method;
                    //System.out.println("get BlocklyArduinoPlugin class");
                    Class ed = BlocklyArduinoPlugin.editor.getClass();
                    //System.out.println("get args");
                    Class[] cArg = new Class[1];
                    //System.out.println("set first arg as string");
                    cArg[0] = String.class;
                    //System.out.println("get setText method");
                    method = ed.getMethod("setText", cArg);
                    //System.out.println("invoke method");
                    method.invoke(editor, code);
                }catch(NoSuchMethodException e) {
                    //System.out.println("nosuchmethod");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (IllegalAccessException e) {
                    //System.out.println("illegalaccess");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (SecurityException e) {
                    //System.out.println("security");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (InvocationTargetException e) {
                    //System.out.println("invocationtarget");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		}
            }
        });
    }

    /**
     * Paste and verify the created code.
     *
     * @param code Arduino C code
     */
    public void verifyCode(String code) {

        //System.out.println("uploading code");
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //System.out.println("code verify run method started");
                try{
                    //System.out.println("make method");
                    java.lang.reflect.Method method;
                    //System.out.println("get BlocklyArduinoPlugin class");
                    Class ed = BlocklyArduinoPlugin.editor.getClass();
                    //System.out.println("get args");
                    Class[] cArg = new Class[1];
                    //System.out.println("set first arg as string");
                    cArg[0] = String.class;
                    //System.out.println("get setText method");
                    method = ed.getMethod("setText", cArg);
                    //System.out.println("invoke method");
                    method.invoke(editor, code);
                }catch(NoSuchMethodException e) {
                    //System.out.println("nosuchmethod");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (IllegalAccessException e) {
                    //System.out.println("illegalaccess");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (SecurityException e) {
                    //System.out.println("security");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (InvocationTargetException e) {
                    //System.out.println("invocationtarget");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		}        
                //System.out.println("handleExport");
                //BlocklyArduinoPlugin.editor.handleRun(false, Editor.this.presentHandler, Editor.this.runHandler);
                //System.out.println("Done handling export");
            }
        });
    }

    /**
     * Uploads the created code to the Arduino board.
     *
     * @param code Arduino C code
     */
    public void uploadCode(String code) {

        //System.out.println("uploading code");
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //System.out.println("code upload run method started");
                try{
                    //System.out.println("make method");
                    java.lang.reflect.Method method;
                    //System.out.println("get BlocklyArduinoPlugin class");
                    Class ed = BlocklyArduinoPlugin.editor.getClass();
                    //System.out.println("get args");
                    Class[] cArg = new Class[1];
                    //System.out.println("set first arg as string");
                    cArg[0] = String.class;
                    //System.out.println("get setText method");
                    method = ed.getMethod("setText", cArg);
                    //System.out.println("invoke method");
                    method.invoke(editor, code);
                }catch(NoSuchMethodException e) {
                    //System.out.println("nosuchmethod");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (IllegalAccessException e) {
                    //System.out.println("illegalaccess");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (SecurityException e) {
                    //System.out.println("security");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (InvocationTargetException e) {
                    //System.out.println("invocationtarget");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		}        
                //System.out.println("handleExport");
                BlocklyArduinoPlugin.editor.handleExport(false);
                //System.out.println("Done handling export");
            }
        });
    }

    /**
     * This method is called from javascript. It lets the user select a location
     * where to save the generated code to and saves them.
     *
     * @param code The Arduino c code generated from the blocks.
     */
    public void saveCode(String code) {

        //System.out.println("uploading code");
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //System.out.println("code upload run method started");
                try{
                    //System.out.println("make method");
                    java.lang.reflect.Method method;
                    //System.out.println("get BlocklyArduinoPlugin class");
                    Class ed = BlocklyArduinoPlugin.editor.getClass();
                    //System.out.println("get args");
                    Class[] cArg = new Class[1];
                    //System.out.println("set first arg as string");
                    cArg[0] = String.class;
                    //System.out.println("get setText method");
                    method = ed.getMethod("setText", cArg);
                    //System.out.println("invoke method");
                    method.invoke(editor, code);
                }catch(NoSuchMethodException e) {
                    //System.out.println("nosuchmethod");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (IllegalAccessException e) {
                    //System.out.println("illegalaccess");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (SecurityException e) {
                    //System.out.println("security");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (InvocationTargetException e) {
                    //System.out.println("invocationtarget");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		}        
                //System.out.println("handleExport");
                BlocklyArduinoPlugin.editor.handleSaveAs();
                //System.out.println("Done handling export");
            }
        });
    }

    /**
     * This method is called from javascript. It lets the user select a location
     * where to save the screen capture of the workspace.
     *
     * @param code Thecode generated from Blockly@rduino.
     */
    public void saveWorkspaceCapture(String code) {

        //System.out.println("uploading code");
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //System.out.println("code upload run method started");
                try{
                    //System.out.println("make method");
                    java.lang.reflect.Method method;
                    //System.out.println("get BlocklyArduinoPlugin class");
                    Class ed = BlocklyArduinoPlugin.editor.getClass();
                    //System.out.println("get args");
                    Class[] cArg = new Class[1];
                    //System.out.println("set first arg as string");
                    cArg[0] = String.class;
                    //System.out.println("get setText method");
                    method = ed.getMethod("setText", cArg);
                    //System.out.println("invoke method");
                    method.invoke(editor, code);
                }catch(NoSuchMethodException e) {
                    //System.out.println("nosuchmethod");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (IllegalAccessException e) {
                    //System.out.println("illegalaccess");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (SecurityException e) {
                    //System.out.println("security");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		} catch (InvocationTargetException e) {
                    //System.out.println("invocationtarget");
                    BlocklyArduinoPlugin.editor.getCurrentTab().setText(code);
 		}        
                //System.out.println("handleExport");
                BlocklyArduinoPlugin.editor.handleSaveAs();
                //System.out.println("Done handling export");
            }
        });
    }

    /**
     * Loads an xml file in which the user saved his blocks.
     *
     * @return xml data for the block structure.
     */
    public String IDEloadXML() {
        //System.out.println("loading blocks");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(lastOpenedLocation));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XML files", "*.xml")
        );
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);           
        String blockData = "";
        //System.out.println("file selected");
        if (selectedFile != null) {
            lastOpenedLocation = selectedFile.getParent();
            //System.out.println("saved last opened location"); 
            try {
                BufferedReader fReader = new BufferedReader(new FileReader(selectedFile));
                blockData = fReader.lines().collect(Collectors.joining());
                fReader.close();
            } catch (FileNotFoundException ex) {
                //System.out.println("filenotfoundexception");
                Logger.getLogger(BlocklyArduinoServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //System.out.println("ioexception");
                Logger.getLogger(BlocklyArduinoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return blockData;
    }
    
    /**
     * This method is called from javascript. It lets the user select a location
     * where to save the blocks to and saves them.
     *
     * @param xml The xml structure of the created block program.
     */
    public void IDEsaveXML(String xml) {
        //System.out.println("saving blocks");
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(lastOpenedLocation));
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XML files", "*.xml")
        );
        File selectedFile = fileChooser.showSaveDialog(ownerWindow);
        if (selectedFile != null) {
            if (selectedFile.getName().matches("^.*\\.xml$")) {
                // filename is OK as-is
            } else {
                selectedFile = new File(selectedFile.toString() + ".xml");  // append .xml if "foo.jpg.xml" is OK
            }
            lastOpenedLocation = selectedFile.getParent();
            try {
                BufferedWriter bWriter = new BufferedWriter(new FileWriter(selectedFile));
                bWriter.write(xml);
                bWriter.flush();
                bWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(BlocklyArduinoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void exit() {
        Platform.exit();
    }
}