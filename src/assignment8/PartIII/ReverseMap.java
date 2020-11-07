package assignment8.PartIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseMap {

	public static Map<Object, Set<Object>> getInverted(Map<Object, Object> mp) {

        Map<Object, Set<Object>> resultMap = new HashMap<Object, Set<Object>>();
        if (mp.size() == 0) {
            System.out.println("Empty map");
            return  resultMap;
        }

        for (Object newValue: mp.keySet()
             ) {
                Object newKey = mp.get(newValue);
                if (!resultMap.containsKey(newKey)) {
                    Set<Object> valueSet = new HashSet<>();
                    valueSet.add(newValue);
                    resultMap.put(newKey, valueSet);
                } else {
                    resultMap.get(newKey).add(newValue);
                }
        }
        return resultMap;

	}
	public static void main(String[] args) {
		Map<Object,Object> m = new HashMap<Object,Object>();
		m.put("Key1", new Integer(2));
		m.put("Key2", new Integer(5));
		m.put("Key4", new Integer(2));
		m.put("Key5", new Integer(8));
		m.put("Key6", new Integer(18));
		m.put("Key7", new Integer(24));
		System.out.println("hashmap is " + m);

		System.out.println("inverted: " + ReverseMap.getInverted(m));


	}

}
