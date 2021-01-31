package db.dto;

public class Buyer extends Person{
    private FirearmPermit firearmPermit;

    public FirearmPermit getFirearmPermit() {
        return firearmPermit;
    }

    public void setFirearmPermit(FirearmPermit firearmPermit) {
        this.firearmPermit = firearmPermit;
    }
}
