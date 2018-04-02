import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Integer.max;
import static java.lang.Integer.min;


public class ReDimension {
    public String Dimensionpart;
    public double numb;
    private String str;

    public ReDimension(String string) {
        if (Arrays.asList(string.split(" ")).size() == 1) {
            Dimensionpart = "";
            numb = Double.parseDouble(string);
        } else {
            str = string.substring(string.indexOf(' ') + 1).replaceAll(" ", "");
            String d0 = "";
            HashMap<String, Integer> pownumb = new HashMap<String, Integer>();
            pownumb.put("T", 12);
            pownumb.put("G", 9);
            pownumb.put("M", 6);
            pownumb.put("k", 3);
            pownumb.put("h", 2);
            pownumb.put("da", 1);
            pownumb.put("d", -1);
            pownumb.put("c", -2);
            pownumb.put("m", -3);
            pownumb.put("µ", -6);
            pownumb.put("n", -9);
            int count1 = 0;
            int count2 = 0;
       /* ArrayList<String> listd = new ArrayList<String>();
        Collections.addAll(listd, str.split("\\*"));
        for (int i = 0; i < listd.size(); i++) {
            List<String> listd2 = Arrays.asList(listd.get(i).split("\\/"));
            if (listd2.get(0).length() > 1 && pownumb.containsKey(String.valueOf(listd2.get(0).charAt(0)))) {
                count1 += (int) pownumb.get(String.valueOf(listd2.get(0).charAt(0)));
                d0 += "*" + listd2.get(0).substring(1);
            } else d0 += "*" + listd2.get(0);
            if (listd2.size() >= 2) {
                for (int j = 1; j < listd2.size(); j++) {
                    if (listd2.get(j).length() > 1 && pownumb.containsKey(String.valueOf(listd2.get(j).charAt(0)))) {
                        count2 += (int) pownumb.get(String.valueOf(listd2.get(j).charAt(0)));
                        d0 += "/" + listd2.get(j).substring(1);
                    } else d0 += "/" + listd2.get(j);
                }
            }
        }*/
            StringBuilder s = new StringBuilder("*" + str);
            int i = 0;
            while (i <= max(s.lastIndexOf("*"), s.lastIndexOf("/")) && i != -1) {
                boolean t;
                if (i == max(s.lastIndexOf("*"), s.lastIndexOf("/"))) t = s.length() - i - 1 > 1;
                else if (s.indexOf("*", i + 1) == -1 || s.indexOf("/", i + 1) == -1)
                    t = max(s.indexOf("*", i + 1), s.indexOf("/", i + 1)) - i - 1 > 1;
                else t = min(s.indexOf("*", i + 1), s.indexOf("/", i + 1)) - i - 1 > 1;
                if (max(s.lastIndexOf("*"), s.lastIndexOf("/")) == -1) t = true;
                if (t && pownumb.containsKey(String.valueOf(s.charAt(i + 1)))) {
                    if (s.charAt(i) == '*') {
                        count1 += pownumb.get(String.valueOf(s.charAt(i + 1)));
                    }
                    if (s.charAt(i) == '/') {
                        count2 += pownumb.get(String.valueOf(s.charAt(i + 1)));
                    }
                    s.deleteCharAt(i + 1);
                }
                if (s.indexOf("*", i + 1) == -1 || s.indexOf("/", i + 1) == -1)
                    i = max(s.indexOf("*", i + 1), s.indexOf("/", i + 1));
                else i = min(s.indexOf("*", i + 1), s.indexOf("/", i + 1));

            }
            numb = Double.parseDouble(string.split(" ")[0]) * Math.pow(10, (count1 - count2));
            Dimensionpart = s.substring(1);
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dimensionpart == null) ? 0 : Dimensionpart.hashCode());
		long temp;
		temp = Double.doubleToLongBits(numb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReDimension other = (ReDimension) obj;
		if (Dimensionpart == null) {
			if (other.Dimensionpart != null)
				return false;
		} else if (!Dimensionpart.equals(other.Dimensionpart))
			return false;
		if (Double.doubleToLongBits(numb) != Double.doubleToLongBits(other.numb))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}
    

}
