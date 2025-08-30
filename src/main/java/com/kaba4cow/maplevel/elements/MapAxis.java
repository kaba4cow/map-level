package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MapElement;

/**
 * Represents a texture axis of a MAP brush face.
 */
public class MapAxis implements MapElement {

	private float x;
	private float y;
	private float z;
	private float offset;

	MapAxis() {
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
		return this.x;
	}

	/**
	 * Sets the x component of the normal.
	 * 
	 * @param the x component
	 * 
	 * @return a reference to this object
	 */
	public MapAxis setX(float x) {
		this.x = x;
		return this;
	}

	/**
	 * Returns the y component of the normal.
	 * 
	 * @return the y component
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * Sets the y component of the normal.
	 * 
	 * @param the y component
	 * 
	 * @return a reference to this object
	 */
	public MapAxis setY(float y) {
		this.y = y;
		return this;
	}

	/**
	 * Returns the z component of the normal.
	 * 
	 * @return the z component
	 */
	public float getZ() {
		return this.z;
	}

	/**
	 * Sets the z component of the normal.
	 * 
	 * @param the z component
	 * 
	 * @return a reference to this object
	 */
	public MapAxis setZ(float z) {
		this.z = z;
		return this;
	}

	/**
	 * Returns the offset component of the normal.
	 * 
	 * @return the offset component
	 */
	public float getOffset() {
		return this.offset;
	}

	/**
	 * Sets the offset component of the normal.
	 * 
	 * @param the offset component
	 * 
	 * @return a reference to this object
	 */
	public MapAxis setOffset(float offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Converts the texture axis to its MAP string representation.
	 * 
	 * @return the MAP string representation of this texture axis
	 */
	@Override
	public String toMapString() {
		return String.format("[ %s %s %s %s ]", this.x, this.y, this.z, this.offset);
	}

	@Override
	public String toString() {
		return String.format("MapAxis [x=%s, y=%s, z=%s, offset=%s]", this.x, this.y, this.z, this.offset);
	}

}
