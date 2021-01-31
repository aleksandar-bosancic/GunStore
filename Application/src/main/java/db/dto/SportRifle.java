package db.dto;

public class SportRifle extends Rifle{
    private int muzzleVelocity;
    private int range;

    public int getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(int muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
