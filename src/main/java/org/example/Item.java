package org.example;

public final class Item {
    private String name;
    private final int code;

    public Item(String name, int code) {
        if (code < 0)
            throw new IllegalArgumentException("Invalid code");
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Item) {
            Item other = (Item) obj;
            return this.name.equals(other.name) && this.code == other.code;
        } else return false;
    }
}
