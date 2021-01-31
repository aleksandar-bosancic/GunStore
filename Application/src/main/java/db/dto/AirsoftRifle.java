package db.dto;

public class AirsoftRifle extends Rifle{
    private int range;
    private int muzzleVelocity;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(int muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
    }
}
