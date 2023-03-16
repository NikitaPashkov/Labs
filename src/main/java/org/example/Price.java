package org.example;

public final class Price {
    private final int roubles;
    private final int copeks;

    public Price(int roubles, int copeks) {
        if (roubles < 0 || copeks < 0 || copeks > 99) {
            throw new IllegalArgumentException("Incorrect params");
        }
        this.roubles = roubles;
        this.copeks = copeks;
    }

    public int getRoubles() {
        return roubles;
    }

    public int getCopeks() {
        return copeks;
    }


    @Override
    public String toString() {
        return roubles + " руб. " + copeks + " коп.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Price) {
            Price other = (Price) obj;
            return this.roubles == other.roubles && this.copeks == other.copeks;
        }
        else return false;
    }
}
