import java.util.Objects;

public final class NumberWithDimension implements Comparable<NumberWithDimension> {
    private Double number;
    private String dimension;


    NumberWithDimension(final String string) {
        this.dimension = new ReDimension(string.split(" ")[1]).GetDimension();
        this.number = Double.parseDouble(string.split(" ")[0]) * new ReDimension(string.split(" ")[1]).GetPow();
    }

    NumberWithDimension(final Double number, final String string) {
        this.number = number * new ReDimension(string).GetPow();
        this.dimension = new ReDimension(string).GetDimension();
    }

    NumberWithDimension Sum(NumberWithDimension other) {

        if (this.dimension.equals(other.dimension)) {
            return new NumberWithDimension(this.number + other.number, this.dimension);
        } else throw new NumberFormatException();
    }

    NumberWithDimension Sub(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension)) {
            return new NumberWithDimension(this.number - other.number, this.dimension);
        } else throw new NumberFormatException();
    }

    NumberWithDimension Multi(NumberWithDimension other) {
        return new NumberWithDimension(this.number * other.number, this.dimension + "*" + other.dimension);
    }

    NumberWithDimension Div(NumberWithDimension other) {
        if (this.dimension.equals(other.dimension))
            return new NumberWithDimension(this.number / other.number, "");
        else return new NumberWithDimension(this.number / other.number, this.dimension + "/" + other.dimension);
    }

    public int compareTo(NumberWithDimension other) {
        if (!this.dimension.equals(other.dimension)) throw new NumberFormatException();
        else {
            return this.number.compareTo(other.number);
        }
    }

    double GetNumber() {
        return number;
    }

    String GetDim() {
        return dimension;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dimension == null) ? 0 : dimension.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
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
        NumberWithDimension other = (NumberWithDimension) obj;
        if (dimension == null) {
            if (other.dimension != null)
                return false;
        } else if (!dimension.equals(other.dimension))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (Objects.equals(this.dimension, "")) return String.valueOf(this.number);
        else return this.number + " " + this.dimension;
    }
}
