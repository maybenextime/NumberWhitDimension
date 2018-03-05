import java.util.Arrays;

public class NumberWithDimension {
    private Double number;
    private String dimension;

    public NumberWithDimension(String string) {
        String a = string.substring(string.indexOf(' ') + 1).replaceAll(" ", "");
        this.dimension = new ReDimension(a).getdim();
        if (Arrays.asList(string.split(" ")).size() == 1) this.dimension = "";
        this.number = Double.parseDouble(string.split(" ")[0]) * Math.pow(10, (int) new ReDimension(a).getpow());
    }

    public NumberWithDimension sum(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension)) {
            this.number = this.number + other.number;
        } else throw new NumberFormatException();
        return this;
    }

    public NumberWithDimension sub(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension)) {
            this.number = this.number - other.number;
            this.dimension = this.dimension;
        } else throw new NumberFormatException();

        return this;
    }

    public NumberWithDimension multi(NumberWithDimension other) {

        this.dimension = this.dimension + "*" + other.dimension;
        this.number = this.number * other.number;

        return this;
    }

    public NumberWithDimension div(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension)) this.dimension = "";
        else
            this.dimension = this.dimension + "/" + other.dimension;
        this.number = this.number / other.number;
        return this;
    }

    public int compare(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension)) {
            if (this.number > other.number) return 1;
            if (this.number < other.number) return -1;
            else return 0;
        } else throw new NumberFormatException();
    }

    @Override
    public String toString() {
        return this.number + " " + this.dimension;
    }
}
