package Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Domain.*;

public class Loader {

	private String fileName;
    public List<Edge> edges;
    public List<String> nodes;

    public Loader(String f) throws IOException
    {            
        this.fileName = f;
        List<Edge> list1 = new ArrayList<Edge>();
        List<String> list2 = new ArrayList<String>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Edge ed = new Edge(line.split(" ")[0], line.split(" ")[1]);
            list1.add(ed);
            
            if (! list2.contains(line.split(" ")[0]))
            	list2.add(line.split(" ")[0]);
            if (! list2.contains(line.split(" ")[1]))
            	list2.add(line.split(" ")[1]);
        }
        bufferedReader.close();
        edges = list1;
        nodes = list2;
    }
}
