package db.dto;

public class Rifle extends Item{
    private String caliber;
    private int magazineCapacity;

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }
}
