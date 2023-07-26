package App_MVC.Modelo;

public class Db_Products {
    private String id;
    private String name;
    private String section;
    private String price;
    private String country;

    public Db_Products() {
        this.id = "";
        this.name = "";
        this.section = "";
        this.price = "";
        this.country = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
