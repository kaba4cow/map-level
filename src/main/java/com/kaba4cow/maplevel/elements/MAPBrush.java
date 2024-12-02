package com.kaba4cow.maplevel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a single brush of a MAP entity.
 */
public class MAPBrush implements MAPElement {

	private final List<MAPFace> faces;

	/**
	 * Creates a new MAP brush.
	 */
	public MAPBrush() {
		this.faces = new ArrayList<>();
	}

	/**
	 * Retrieves an unmodifiable list of faces in the model.
	 *
	 * @return an unmodifiable list of {@link MAPFace} objects
	 */
	public List<MAPFace> getFaces() {
		return Collections.unmodifiableList(faces);
	}

	/**
	 * Retrieves faces matching a given predicate.
	 *
	 * @param predicate the condition to filter faces
	 * 
	 * @return a list of faces matching the predicate
	 */
	public List<MAPFace> getFaces(Predicate<MAPFace> predicate) {
		return faces.stream().filter(predicate).collect(Collectors.toList());
	}

	/**
	 * Retrieves faces with a specified texture.
	 *
	 * @param texture the texture to search for
	 * 
	 * @return a list of faces with the specified texture
	 */
	public List<MAPFace> getFaces(String texture) {
		return getFaces(face -> Objects.equals(face.getTexture(), texture));
	}

	/**
	 * Retrieves a face from the model by its index.
	 *
	 * @param index the index of the face
	 * 
	 * @return a reference to this object
	 */
	public MAPFace getFace(int index) {
		return faces.get(index);
	}

	/**
	 * Adds a face to the model.
	 *
	 * @param face the {@link MAPFace} to add
	 * 
	 * @return a reference to this object
	 */
	public MAPBrush addFace(MAPFace face) {
		faces.add(face);
		return this;
	}

	/**
	 * Removes a face from the model by its index.
	 *
	 * @param index the index of the face to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPBrush removeFace(int index) {
		faces.remove(index);
		return this;
	}

	/**
	 * Removes a specified face from the model.
	 *
	 * @param face the face to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPBrush removeFace(MAPFace face) {
		faces.remove(face);
		return this;
	}

	/**
	 * Clears all faces from the model.
	 * 
	 * @return a reference to this object
	 */
	public MAPBrush clearFaces() {
		faces.clear();
		return this;
	}

	/**
	 * Returns the number of faces in the brush.
	 * 
	 * @return the number of faces
	 */
	public int getFaceCount() {
		return faces.size();
	}

	/**
	 * Converts the brush to its MAP string representation.
	 * 
	 * @return the MAP string representation of the brush
	 */
	@Override
	public String toMAPString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		for (MAPFace face : faces)
			builder.append(face.toMAPString()).append("\n");
		builder.append("}");
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MAPBrush [faces=%s]", faces);
	}

}
