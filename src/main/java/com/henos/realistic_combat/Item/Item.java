package com.henos.realistic_combat.Item;

public class Item {
    public int weight = 0;

    public int getItemWeight() {
        return this.weight;
    }

    public void setWeight(int val) {
        this.weight = val;
    }

    public int determineItemDamage() {
        return this.weight;
    }
}
