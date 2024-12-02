package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a face in a MAP file.
 */
public class MAPFace implements MAPElement {

	private final MAPPoint point1;
	private final MAPPoint point2;
	private final MAPPoint point3;
	private String texture;
	private final MAPAxis axisU;
	private final MAPAxis axisV;
	private final MAPTransform transform;

	/**
	 * Creates a new MAP face.
	 */
	public MAPFace() {
		this.point1 = new MAPPoint();
		this.point2 = new MAPPoint();
		this.point3 = new MAPPoint();
		this.texture = null;
		this.axisU = new MAPAxis();
		this.axisV = new MAPAxis();
		this.transform = new MAPTransform();
	}

	/**
	 * Returns the first point of the face plane.
	 * 
	 * @return the first point of the plane
	 */
	public MAPPoint getPoint1() {
		return point1;
	}

	/**
	 * Returns the second point of the face plane.
	 * 
	 * @return the second point of the plane
	 */
	public MAPPoint getPoint2() {
		return point2;
	}

	/**
	 * Returns the third point of the face plane.
	 * 
	 * @return the third point of the plane
	 */
	public MAPPoint getPoint3() {
		return point3;
	}

	/**
	 * Returns the texture of the face.
	 * 
	 * @return the face texture
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * Sets the texture of the face.
	 * 
	 * @param texture the face texture
	 * 
	 * @return a reference to this object
	 */
	public MAPFace setTexture(String texture) {
		this.texture = texture;
		return this;
	}

	/**
	 * Returns the U texture axis of the face.
	 * 
	 * @return the U axis
	 */
	public MAPAxis getAxisU() {
		return axisU;
	}

	/**
	 * Returns the V texture axis of the face.
	 * 
	 * @return the V axis
	 */
	public MAPAxis getAxisV() {
		return axisV;
	}

	/**
	 * Returns the texture transform of the face.
	 * 
	 * @return the texture transform
	 */
	public MAPTransform getTransform() {
		return transform;
	}

	/**
	 * Converts the face to its MAP string representation.
	 *
	 * @return the MAP string representation of this face
	 */
	@Override
	public String toMAPString() {
		return String.format("%s %s %s %s %s %s %s", //
				point1.toMAPString(), point2.toMAPString(), point3.toMAPString(), //
				texture, axisU.toMAPString(), axisV.toMAPString(), transform.toMAPString());
	}

	@Override
	public String toString() {
		return String.format("MAPFace [point1=%s, point2=%s, point3=%s, texture=%s, axisU=%s, axisV=%s, transform=%s]", point1,
				point2, point3, texture, axisU, axisV, transform);
	}

}
