package hu.nagy_gabor.filmdb;

public class Termek {
    private int id;
    private String kodszam;
    private String name;
    private int price;
    private int quantity;
    private String url;
    private String kategoria;

    public Termek(int id, String kodszam, String name, int price, int quantity, String url, String kategoria) {
        this.id = id;
        this.kodszam = kodszam;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
        this.kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public String getKodszam() {
        return kodszam;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUrl() {
        return url;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKodszam(String kodszam) {
        this.kodszam = kodszam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
