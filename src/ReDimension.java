import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReDimension {
    private String Dimensionpart;
    private int pow1;
    private String str;

    public ReDimension(String string) {
        str = string;
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
        pownumb.put("p", -12);
        int count1 = 0;
        int count2 = 0;
        List<String> listd = Arrays.asList(string.split("\\*"));
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
        }
        pow1 = count1 - count2;
        Dimensionpart = d0.substring(1);
    }

    public int getpow() {
        return new ReDimension(str).pow1;
    }

    public String getdim() {
        return new ReDimension(str).Dimensionpart;
    }
}
