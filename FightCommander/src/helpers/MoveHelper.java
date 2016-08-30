package helpers;

import java.util.HashMap;
import java.util.Map;


public class MoveHelper {
	
	private static final Map<String,Integer> helper = new HashMap<String,Integer>();
	private static final Map<String, Map<String, Integer>> movementsMap = new HashMap<String, Map<String, Integer>>();
    static {
    	helper.put("sand",2);
    	helper.put("grass",1);
    	helper.put("water", Integer.MAX_VALUE);
    	
    	movementsMap.put("FirstWarrior", helper);
    }
    
    public static int getNeededSteps(String Figure, String texture){
    	return movementsMap.get(Figure).get(texture);
    }
}
