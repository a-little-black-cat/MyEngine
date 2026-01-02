package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    static LogManager LM  = LogManager.getInstance();
    static SceneManager SM = SceneManager.getInstance();
    public static void main(String[] args) {

        LM.writeLog("Hello World. Testing LM.");
        LM.writeLog(LM.managerType);

        testSceneAddition();








    }

    public static void testSceneAddition(){
        SM.addScene("Scene 1", "Scene 2", true);
        SM.addScene("Scene 2", "Scene 3", false);


    }
}