package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a texture transform of a MAP brush face.
 */
public class MAPTransform implements MAPElement {

	private float rotation;
	private float scaleX;
	private float scaleY;

	MAPTransform() {
		this.rotation = 0.0f;
		this.scaleX = 0.0f;
		this.scaleY = 0.0f;
	}

	/**
	 * Returns the rotation of the transform.
	 * 
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * Sets the rotation of the transform.
	 * 
	 * @param the rotation
	 * 
	 * @return a reference to this object
	 */
	public MAPTransform setRotation(float rotation) {
		this.rotation = rotation;
		return this;
	}

	/**
	 * Returns the x component of the scale.
	 * 
	 * @return the x component
	 */
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * Sets the x component of the scale.
	 * 
	 * @param the x component
	 * 
	 * @return a reference to this object
	 */
	public MAPTransform setScaleX(float scaleX) {
		this.scaleX = scaleX;
		return this;
	}

	/**
	 * Returns the y component of the scale.
	 * 
	 * @return the y component
	 */
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * Sets the y component of the scale.
	 * 
	 * @param the y component
	 * 
	 * @return a reference to this object
	 */
	public MAPTransform setScaleY(float scaleY) {
		this.scaleY = scaleY;
		return this;
	}

	/**
	 * Converts the texture transform to its MAP string representation.
	 * 
	 * @return the MAP string representation of this texture transform
	 */
	@Override
	public String toMAPString() {
		return String.format("%s %s %s", rotation, scaleX, scaleY);
	}

	@Override
	public String toString() {
		return String.format("MAPTextureTransform [rotation=%s, scaleX=%s, scaleY=%s]", rotation, scaleX, scaleY);
	}

}
