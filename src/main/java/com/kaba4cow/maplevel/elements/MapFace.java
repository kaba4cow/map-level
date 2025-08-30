package com.kaba4cow.maplevel.elements;

import com.kaba4cow.maplevel.MapElement;

/**
 * Represents a face in a MAP file.
 */
public class MapFace implements MapElement {

	private final MapPoint point1;
	private final MapPoint point2;
	private final MapPoint point3;
	private String texture;
	private final MapAxis axisU;
	private final MapAxis axisV;
	private final MapTransform transform;

	/**
	 * Creates a new MAP face.
	 */
	public MapFace() {
		this.point1 = new MapPoint();
		this.point2 = new MapPoint();
		this.point3 = new MapPoint();
		this.texture = null;
		this.axisU = new MapAxis();
		this.axisV = new MapAxis();
		this.transform = new MapTransform();
	}

	/**
	 * Returns the first point of the face plane.
	 * 
	 * @return the first point of the plane
	 */
	public MapPoint getPoint1() {
		return this.point1;
	}

	/**
	 * Returns the second point of the face plane.
	 * 
	 * @return the second point of the plane
	 */
	public MapPoint getPoint2() {
		return this.point2;
	}

	/**
	 * Returns the third point of the face plane.
	 * 
	 * @return the third point of the plane
	 */
	public MapPoint getPoint3() {
		return this.point3;
	}

	/**
	 * Returns the texture of the face.
	 * 
	 * @return the face texture
	 */
	public String getTexture() {
		return this.texture;
	}

	/**
	 * Sets the texture of the face.
	 * 
	 * @param texture the face texture
	 * 
	 * @return a reference to this object
	 */
	public MapFace setTexture(String texture) {
		this.texture = texture;
		return this;
	}

	/**
	 * Returns the U texture axis of the face.
	 * 
	 * @return the U axis
	 */
	public MapAxis getAxisU() {
		return this.axisU;
	}

	/**
	 * Returns the V texture axis of the face.
	 * 
	 * @return the V axis
	 */
	public MapAxis getAxisV() {
		return this.axisV;
	}

	/**
	 * Returns the texture transform of the face.
	 * 
	 * @return the texture transform
	 */
	public MapTransform getTransform() {
		return this.transform;
	}

	/**
	 * Converts the face to its MAP string representation.
	 *
	 * @return the MAP string representation of this face
	 */
	@Override
	public String toMapString() {
		return String.format("%s %s %s %s %s %s %s", //
				this.point1.toMapString(), this.point2.toMapString(), this.point3.toMapString(), //
				this.texture, this.axisU.toMapString(), this.axisV.toMapString(), this.transform.toMapString());
	}

	@Override
	public String toString() {
		return String.format("MapFace [point1=%s, point2=%s, point3=%s, texture=%s, axisU=%s, axisV=%s, transform=%s]",
				this.point1, this.point2, this.point3, this.texture, this.axisU, this.axisV, this.transform);
	}

}
