import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class ReDimension {
    private String Dimensionpart;
    private double Pow;
    private String Str;

    private boolean DimCheck(String str, List<String> base) {
        for (String aBase : base) if (str.contains(aBase) && str.length() == aBase.length()) return true;
        return false;
    }

    ReDimension(String string) {
        Str = string;
        if (string.equals("")) {
            Pow = 1.0;
            Dimensionpart = "";
        } else {
            HashMap<String, Integer> PowNumb = new HashMap<>();
            PowNumb.put("T", 12);
            PowNumb.put("G", 9);
            PowNumb.put("M", 6);
            PowNumb.put("k", 3);
            PowNumb.put("h", 2);
            PowNumb.put("da", 1);
            PowNumb.put("d", -1);
            PowNumb.put("c", -2);
            PowNumb.put("m", -3);
            PowNumb.put("µ", -6);
            PowNumb.put("n", -9);
            PowNumb.put("p", -12);
            List<String> base = Arrays.asList("m", "g", "A", "K", "cd", "mol", "rad", "sr", "Hz", "N", "Pa", "J", "W", "C", "V", "F", "Ω", "S", "Wb", "T", "H", "lm", "lx", "Bq", "Gy", "Sv", "kat");

            int count1 = 0;
            int count2 = 0;

            StringBuilder s = new StringBuilder("*" + Str);
            int i = 0;
            int j;
            while (i < s.length()) {
                if (s.indexOf("*", i + 1) == -1 || s.indexOf("/", i + 1) == -1)
                    j = max(s.indexOf("*", i + 1), s.indexOf("/", i + 1));
                else j = min(s.indexOf("*", i + 1), s.indexOf("/", i + 1));
                if (j == -1) j = s.length();
                String part = s.substring(i + 1, j);
                if (!DimCheck(part, base) && PowNumb.containsKey(String.valueOf(s.charAt(i + 1)))) {
                    if (s.charAt(i) == '*') {
                        count1 += PowNumb.get(String.valueOf(s.charAt(i + 1)));
                    }
                    if (s.charAt(i) == '/') {
                        count2 += PowNumb.get(String.valueOf(s.charAt(i + 1)));
                    }
                    s.deleteCharAt(i + 1);
                    j--;
                }
                i = j;

            }
            Pow = Math.pow(10, (count1 - count2));
            Dimensionpart = s.substring(1);
        }
    }


    Double GetPow() {
        return Pow;
    }

    String GetDimension() {
        return Dimensionpart;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Dimensionpart == null) ? 0 : Dimensionpart.hashCode());
        long temp;
        temp = Double.doubleToLongBits(Pow);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Str == null) ? 0 : Str.hashCode());
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
        if (Double.doubleToLongBits(Pow) != Double.doubleToLongBits(other.Pow))
            return false;
        if (Str == null) {
            if (other.Str != null)
                return false;
        } else if (!Str.equals(other.Str))
            return false;
        return true;
    }


}
