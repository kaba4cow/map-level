package com.kaba4cow.maplevel;

/**
 * Represents a generic element in a MAP file. Each implementing class defines how to convert the element to its MAP string
 * representation.
 */
public interface MAPElement {

	/**
	 * Converts this element to its MAP string representation.
	 *
	 * @return the MAP string representation of this element
	 */
	public String toMAPString();

}
