package org.example;


public class Manager {

    private static Manager instance;
    private boolean running;
    public String managerType;

    protected Manager(){}

    //check for instance, if null start a Manager
    public static Manager getInstance(){
        if(instance==null){
            instance = new Manager();
        }
        return instance;
    }

    public void startUp(){
        running = true;
        managerType = "Manager";

    }
    public void shutDown(){
        System.exit(0);

    }

    public void setType(){
        managerType = new String(managerType);


    }




}
