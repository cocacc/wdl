package utility;

public class UrlReplace {

    public static String getEncodeStr(String Str) {
    	String newStr = Str.replace("/","％2F").replace("+","％2B").replace("%","％25").replace("#","％23").replace("&","％26");
    	return newStr;
    }
    public static String getDecodeStr(String Str) {
    	String newStr = Str.replace("％2F","/").replace("％2B","+").replace("％25","%").replace("％23","#").replace("％26","&");
    	return newStr;
    }
}
