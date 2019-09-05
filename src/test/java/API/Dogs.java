package API;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Dogs {
    protected static SoftAssert s_assert = new SoftAssert();

    @Test
    public void verifyBreedExists () throws Exception {
        JSONObject jsonObject = readJsonFile("C:\\Users\\mecer\\eclipse-workspace\\ee\\QA-Assessment\\src\\main\\resources\\Files\\DogBreeds.json");
        JSONObject dogJSONObject = jsonObject.getJSONObject("message");
        
        Iterator<?> keys = dogJSONObject.keys();
        ArrayList<String> dogBreeds = new ArrayList<>();
        while (keys.hasNext()) {                                        
        	String key = (String) keys.next();
            dogBreeds.add(key);
        }
        System.out.println("retriever breed is in the list : " + dogBreeds.contains("retriever"));              
        
    }

    private static JSONObject readJsonFile(String a) throws FileNotFoundException { 
        File f1 = new File(a);

        FileReader fr = new FileReader(f1.getAbsolutePath());
        JSONTokener tokener = new JSONTokener(fr);
        JSONObject jsonObject = new JSONObject(tokener);

        return jsonObject;
    }
}