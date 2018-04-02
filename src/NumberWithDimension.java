public class NumberWithDimension {
    private Double number;
    private String dimension;

    public NumberWithDimension(String string) {
        this.dimension = new ReDimension(string).Dimensionpart;
        this.number = new ReDimension(string).numb;
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

    public int compareTo(Object o) {
        return Double.compare(this.number, ((NumberWithDimension) o).number);
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
        return this.number + " " + this.dimension;
    }
}
