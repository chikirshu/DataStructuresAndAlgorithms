package com.ck.tree.easy;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass> {

	@Override
	public int compare(MyClass o1, MyClass o2) {
		if (o1.getAge() > o2.getAge())
			return 1;
		else if (o1.getAge() < o2.getAge())
			return -1;
		else
			return o1.getEmpName().compareTo(o2.getEmpName());
	}

}
