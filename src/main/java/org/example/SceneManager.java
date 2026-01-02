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

    // Object of SceneGraph is created. Scenes are stored as Strings
    Graph<String> SGMap = new Graph<String>();

    // When called, developer can connect source scene and destination scene, with the option of bidirectionality.
    public void addScene(String source, String destination, boolean bidirectional){
        SGMap.addEdge(source, destination, bidirectional);
        LM.writeLog("Scene "+ source+ " has been connected to "+ destination);

        //Check if source and destination were added successfully
        SGMap.hasVertex(source);
        SGMap.hasVertex(destination);

        //Check if source and destination were linked successfully
        SGMap.hasEdge(source, destination);

        // Check neighbours of source
        SGMap.neighbours(source);

        // Check neighbours of destination

        SGMap.neighbours(destination);
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
            LM.writeLog("Error (SceneGraph-vertex): Scene " + s + " doest not exist on SceneGraph. Check for invalid insertion." );
        }
    }

    // Check if edges between s and d were added properly
    public void hasEdge(T s, T d){
        if (SceneGraph.get(s).contains(d)) {
            System.out.println(
                    "The SceneGraph has an edge between scenes " + s
                            + " and " + d + ".");
        }
        else {
            System.out.println(
                    "The SceneGraph has no edge between scenes " + s
                            + " and " + d + ".");
            LM.writeLog("Error (SceneGraph-edge): Scenes " + s + " and " + d + " are not connected properly. Check for invalid insertion." );
        }

    }

    public void neighbours(T s)
    {
        if(!SceneGraph.containsKey(s))
            return ;
        System.out.println("The neighbours of "+s+" are");
        for(T w:SceneGraph.get(s))
            System.out.print(w+",");
    }


}


