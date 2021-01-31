package db.dto;

public class Munition extends Item{
    private MunitionType munitionType;
    private int packageSize;
    private String caliber;

    public MunitionType getMunitionType() {
        return munitionType;
    }

    public void setMunitionType(MunitionType munitionType) {
        this.munitionType = munitionType;
    }

    public int getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(int packageSize) {
        this.packageSize = packageSize;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }
}
