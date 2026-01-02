package org.example;


import java.io.Console;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        Manager MNG = Manager.getInstance();
        LogManager LM  = LogManager.getInstance();
        LM.writeLog("Hello World. Testing LM.");
        LM.writeLog(LM.managerType);


    }
}