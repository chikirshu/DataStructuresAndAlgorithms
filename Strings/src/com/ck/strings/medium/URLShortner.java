package com.ck.strings.medium;

public class URLShortner {

	public static void main(String[] args) {
		String s = getSlug(1234567);
		System.out.println(s);
		System.out.println(getCounter(s));
	}

	public static String getSlug(int counter) {
		String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int n = counter;
		StringBuilder res = new StringBuilder();

		while (n > 0) {
			res.append(dict.charAt(n % 62));
			n = n / 62;
		}
		return res.reverse().toString();
	}

	public static int getCounter(String slug) {

		int id = 0;
		for (int i = 0; i < slug.length(); i++) {
			if ('a' <= slug.charAt(i) && slug.charAt(i) <= 'z')
				id = id * 62 + slug.charAt(i) - 'a' + 26; // small letters starts at 26th position
			if ('A' <= slug.charAt(i) && slug.charAt(i) <= 'Z')
				id = id * 62 + slug.charAt(i) - 'A';
			if ('0' <= slug.charAt(i) && slug.charAt(i) <= '9')
				id = id * 62 + slug.charAt(i) - '0' + 52; // digits starts at 52nd position
		}
		return id;
	}

}
