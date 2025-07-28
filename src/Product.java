/*
 *  This class represents a simple product.
 */
public class Product {

    private String name;
    private float weightInPounds;

    public Product() {
        name = "?";
        weightInPounds = 0;
    }

    public Product(String name, float weightInPounds) {
        this.name = name;
        this.weightInPounds = weightInPounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weightInPounds;
    }

    public void setWeight(float weight) {
        this.weightInPounds = weight;
    }

    @Override
    public String toString() {

        return  "Name: " + name + " | " +
                "Weight (lb): " + weightInPounds;
    }
}
