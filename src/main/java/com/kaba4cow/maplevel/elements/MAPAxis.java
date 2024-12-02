package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a texture axis of a MAP brush face.
 */
public class MAPAxis implements MAPElement {

	private float x;
	private float y;
	private float z;
	private float offset;

	MAPAxis() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.offset = 0.0f;
	}

	/**
	 * Returns the x component of the normal.
	 * 
	 * @return the x component
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x component of the normal.
	 * 
	 * @param the x component
	 * 
	 * @return a reference to this object
	 */
	public MAPAxis setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Returns the y component of the normal.
	 * 
	 * @return the y component
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y component of the normal.
	 * 
	 * @param the y component
	 * 
	 * @return a reference to this object
	 */
	public MAPAxis setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Returns the z component of the normal.
	 * 
	 * @return the z component
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Sets the z component of the normal.
	 * 
	 * @param the z component
	 * 
	 * @return a reference to this object
	 */
	public MAPAxis setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Returns the offset component of the normal.
	 * 
	 * @return the offset component
	 */
	public float getOffset() {
		return offset;
	}

	/**
	 * Sets the offset component of the normal.
	 * 
	 * @param the offset component
	 * 
	 * @return a reference to this object
	 */
	public MAPAxis setOffset(float offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Converts the texture axis to its MAP string representation.
	 * 
	 * @return the MAP string representation of this texture axis
	 */
	@Override
	public String toMAPString() {
		return String.format("[ %s %s %s %s ]", x, y, z, offset);
	}

	@Override
	public String toString() {
		return String.format("MAPTextureAxis [x=%s, y=%s, z=%s, offset=%s]", x, y, z, offset);
	}

}
