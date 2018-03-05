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
                BlocklyArduinoPlugin.editor.handleRun(false, editor.this.presentHandler, editor.this.runHandler);
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

    public void exit() {
        Platform.exit();
    }
}