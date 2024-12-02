package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a plane point of a MAP brush face.
 */
public class MAPPoint implements MAPElement {

	private float x;
	private float y;
	private float z;

	MAPPoint() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}

	/**
	 * Returns the x component of the point.
	 * 
	 * @return the x component
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x component of the point.
	 * 
	 * @param the x component
	 * 
	 * @return a reference to this object
	 */
	public MAPPoint setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Returns the y component of the point.
	 * 
	 * @return the y component
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y component of the point.
	 * 
	 * @param the y component
	 * 
	 * @return a reference to this object
	 */
	public MAPPoint setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Returns the z component of the point.
	 * 
	 * @return the z component
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the z component of the point.
	 * 
	 * @param the z component
	 * 
	 * @return a reference to this object
	 */
	public MAPPoint setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Converts the plane point to its MAP string representation.
	 * 
	 * @return the MAP string representation of this plane point
	 */
	@Override
	public String toMAPString() {
		return String.format("( %s %s %s )", x, y, z);
	}

	@Override
	public String toString() {
		return String.format("MAPPlanePoint [x=%s, y=%s, z=%s]", x, y, z);
	}

}
