package com.kaba4cow.maplevel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kaba4cow.maplevel.MapElement;

/**
 * Represents a single brush of a MAP entity.
 */
public class MapBrush implements MapElement {

	private final List<MapFace> faces;

	/**
	 * Creates a new MAP brush.
	 */
	public MapBrush() {
		this.faces = new ArrayList<>();
	}

	/**
	 * Retrieves an unmodifiable list of faces in the model.
	 *
	 * @return an unmodifiable list of {@link MapFace} objects
	 */
	public List<MapFace> getFaces() {
		return Collections.unmodifiableList(this.faces);
	}

	/**
	 * Retrieves faces matching a given predicate.
	 *
	 * @param predicate the condition to filter faces
	 * 
	 * @return a list of faces matching the predicate
	 */
	public List<MapFace> getFaces(Predicate<MapFace> predicate) {
		return this.faces.stream().filter(predicate).collect(Collectors.toList());
	}

	/**
	 * Retrieves faces with a specified texture.
	 *
	 * @param texture the texture to search for
	 * 
	 * @return a list of faces with the specified texture
	 */
	public List<MapFace> getFaces(String texture) {
		return this.getFaces(face -> Objects.equals(face.getTexture(), texture));
	}

	/**
	 * Retrieves a face from the model by its index.
	 *
	 * @param index the index of the face
	 * 
	 * @return a reference to this object
	 */
	public MapFace getFace(int index) {
		return this.faces.get(index);
	}

	/**
	 * Adds a face to the model.
	 *
	 * @param face the {@link MapFace} to add
	 * 
	 * @return a reference to this object
	 */
	public MapBrush addFace(MapFace face) {
		this.faces.add(face);
		return this;
	}

	/**
	 * Removes a face from the model by its index.
	 *
	 * @param index the index of the face to remove
	 * 
	 * @return a reference to this object
	 */
	public MapBrush removeFace(int index) {
		this.faces.remove(index);
		return this;
	}

	/**
	 * Removes a specified face from the model.
	 *
	 * @param face the face to remove
	 * 
	 * @return a reference to this object
	 */
	public MapBrush removeFace(MapFace face) {
		this.faces.remove(face);
		return this;
	}

	/**
	 * Clears all faces from the model.
	 * 
	 * @return a reference to this object
	 */
	public MapBrush clearFaces() {
		this.faces.clear();
		return this;
	}

	/**
	 * Returns the number of faces in the brush.
	 * 
	 * @return the number of faces
	 */
	public int getFaceCount() {
		return this.faces.size();
	}

	/**
	 * Converts the brush to its MAP string representation.
	 * 
	 * @return the MAP string representation of the brush
	 */
	@Override
	public String toMapString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		for (MapFace face : this.faces)
			builder.append(face.toMapString()).append("\n");
		builder.append("}");
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MapBrush [faces=%s]", this.faces);
	}

}
