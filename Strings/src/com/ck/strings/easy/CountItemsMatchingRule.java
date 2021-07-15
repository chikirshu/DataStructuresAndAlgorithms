package com.ck.strings.easy;

import java.util.ArrayList;
import java.util.List;

// LC - 1773 : Count Items matching a rule
public class CountItemsMatchingRule {

	public static void main(String[] args) {
		List<List<String>> items = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("phone");
		list.add("blue");
		list.add("pixel");
		items.add(list);
		//list.clear() and then reusing the same list was causing the issue
		list = new ArrayList<>();
		
		list.add("computer");
		list.add("silver");
		list.add("lenovo");
		items.add(list);
		list = new ArrayList<>();
		
		list.add("phone");
		list.add("gold");
		list.add("iphone");
		items.add(list);
		
		System.out.println(countMatches(items, "color", "silver"));
	}
	
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt=0;
        for(List<String> item : items){
            if((ruleKey.equals("type")&&item.get(0).equals(ruleValue)) ||
              (ruleKey.equals("color")&&item.get(1).equals(ruleValue)) ||
              (ruleKey.equals("name")&&item.get(2).equals(ruleValue))){
                cnt++;
            }
        }
        return cnt;
    }

}
