package org.example;
import java.util.*;


public class SceneManager extends Manager{
    LogManager LM = LogManager.getInstance();


    // Call functions within the Graph<T> Class under SceneManager functions externally ---

    private static SceneManager instance;

    private SceneManager(){
        super();
        this.startUp();
        this.managerType = "SceneManager";
        LM.writeLog("SceneManager is started.");
    }

    //Get instance of SceneManager
    public static SceneManager getInstance(){
        if (instance==null){
            instance = new SceneManager();
        }
        return instance;
    }









}

// Basic HashMap handling to reference to when using SceneManager
class Graph<T>{
    // Resource: https://www.geeksforgeeks.org/java/implementing-generic-graph-in-java/
    LogManager LM = LogManager.getInstance(); // for Logging purposes



    // HashMap to store edges of the SceneGraph

    private Map<T, List<T>> SceneGraph = new HashMap<>();

    // Add a new vertex to graph
    public void addVertex(T s){

        SceneGraph.put(s, new LinkedList<T>());

    }

    // Add edges between source to destination
    // Bi-directional aspect may be removed based on engine needs !!
    public void addEdge(T source, T destination, boolean bidirectional){
        if (!SceneGraph.containsKey(source)){
            addVertex(source);
        }

        if (!SceneGraph.containsKey(destination)){
            addVertex(destination);
        }

        SceneGraph.get(source).add(destination);

        if (bidirectional){ //if bidirectional true
            SceneGraph.get(destination).add(source);
        }

    }

    // Count Scenes
    public void getVertexCount(){
        System.out.println("The SceneGraph has " + SceneGraph.keySet().size() + " vertex");
    }

    // Count Scene Edges
    public void edgesCount(boolean bidirection){
        int count=0;
        for (T v : SceneGraph.keySet()) {
            count += SceneGraph.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The SceneGraph has " + count
                + " edges.");

    }

    // Check whether a vertex on SceneGraph exists (for checking whether a scene is successfully added/ exists or not.

    public void hasVertex(T s)
    {
        if (SceneGraph.containsKey(s)) {
            System.out.println("The SceneGraph contains " + s
                    + " as a vertex.");

        }
        else {
            System.out.println("The SceneGraph does not contain "
                    + s + " as a vertex.");
            LM.writeLog("Error (SceneGraph): Scene " + s + " doest not exist on SceneGraph. Check for invalid insertion." );
        }
    }


}


