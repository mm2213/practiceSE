package com.mihir.model.parking.strategy;

import java.util.TreeSet;

import com.mihir.exception.NoFreeSlotAvailableException;

/**
 * Parking strategy in which the natural ordering numbers are used for deciding the slot numbers.
 * For example, 1st car will be parked in slot 1, then next in slot 2, then in slot 3, and so on.
 */
public class NaturalOrderingParkingStrategy {
	TreeSet<Integer> slotTreeSet;

	  public NaturalOrderingParkingStrategy() {
	    this.slotTreeSet = new TreeSet<>();
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public void addSlot(Integer slotNumber) {
	    this.slotTreeSet.add(slotNumber);
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public void removeSlot(Integer slotNumber) {
	    this.slotTreeSet.remove(slotNumber);
	  }

	  /**
	   * {@inheritDoc}
	   */
	  public Integer getNextSlot() {
	    if (slotTreeSet.isEmpty()) {
	      throw new NoFreeSlotAvailableException();
	    }
	    return this.slotTreeSet.first();
	  }
}
