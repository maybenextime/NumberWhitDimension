import java.util.Objects;

public class NumberWithDimension implements Comparable<NumberWithDimension> {
    private Double number;
    private String dimension;

    public NumberWithDimension(String string) {
        this.dimension = new ReDimension(string).GetDimension();
        this.number = new ReDimension(string).GetNumb();
    }

    public NumberWithDimension sum(NumberWithDimension other) {
        NumberWithDimension result = this;
        if (this.dimension.equals(other.dimension)) {
            result.number = this.number + other.number;
            result.dimension = this.dimension;
        } else throw new NumberFormatException();
        return result;
    }

    public NumberWithDimension sub(NumberWithDimension other) {
        NumberWithDimension result = this;
        if (this.dimension.equals(other.dimension)) {
            result.number = this.number - other.number;
            result.dimension = this.dimension;
        } else throw new NumberFormatException();

        return result;
    }

    public NumberWithDimension multi(NumberWithDimension other) {
        NumberWithDimension result = this;
        result.number = this.number * other.number;
        result.dimension = this.dimension + "*" + other.dimension;


        return result;
    }

    public NumberWithDimension div(NumberWithDimension other) {
        NumberWithDimension result = this;
        if (this.dimension.equals(other.dimension)) result.dimension = "";
        else
            result.dimension = this.dimension + "/" + other.dimension;
        result.number = this.number / other.number;
        return result;
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
        if (Objects.equals(this.dimension,"")) return String.valueOf(this.number);
        else return this.number + " " + this.dimension;
    }


    @Override
    public int compareTo(NumberWithDimension o) {
        return 0;
    }
}
