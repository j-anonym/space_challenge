package com.company;

public interface SpaceShipInterface {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public void carry(Item item);
}
