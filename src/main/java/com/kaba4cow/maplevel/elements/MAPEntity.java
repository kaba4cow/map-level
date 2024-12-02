package com.kaba4cow.maplevel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents an entity in a MAP file.
 */
public class MAPEntity implements MAPElement {

	private final MAPProperties properties;
	private final List<MAPBrush> brushes;

	public MAPEntity() {
		this.properties = new MAPProperties();
		this.brushes = new ArrayList<>();
	}

	/**
	 * Retrieves the entity properties.
	 * 
	 * @return entity properties
	 */
	public MAPProperties getProperties() {
		return properties;
	}

	/**
	 * Retrieves an unmodifiable list of brushes.
	 *
	 * @return an unmodifiable list of {@link MAPBrush} objects
	 */
	public List<MAPBrush> getBrushes() {
		return Collections.unmodifiableList(brushes);
	}

	/**
	 * Retrieves a brush from the model by its index.
	 *
	 * @param index the index of the brush
	 * 
	 * @return a reference to this object
	 */
	public MAPBrush getBrush(int index) {
		return brushes.get(index);
	}

	/**
	 * Adds a brush to the model.
	 *
	 * @param brush the {@link MAPBrush} to add
	 * 
	 * @return a reference to this object
	 */
	public MAPEntity addBrush(MAPBrush brush) {
		brushes.add(brush);
		return this;
	}

	/**
	 * Removes a brush from the model by its index.
	 *
	 * @param index the index of the brush to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPEntity removeBrush(int index) {
		brushes.remove(index);
		return this;
	}

	/**
	 * Removes a specified brush from the model.
	 *
	 * @param brush the brush to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPEntity removeBrush(MAPBrush brush) {
		brushes.remove(brush);
		return this;
	}

	/**
	 * Clears all brushes from the model.
	 * 
	 * @return a reference to this object
	 */
	public MAPEntity clearBrushes() {
		brushes.clear();
		return this;
	}

	/**
	 * Returns the number of brushes in the entity.
	 * 
	 * @return the number of brushes
	 */
	public int getBrushCount() {
		return brushes.size();
	}

	@Override
	public String toMAPString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		builder.append(properties.toMAPString());
		for (int i = 0; i < brushes.size(); i++) {
			builder.append(String.format("// Brush %s\n", i));
			builder.append(brushes.get(i).toMAPString()).append("\n");
		}
		builder.append("}");
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MAPEntity [properties=%s, brushes=%s]", properties, brushes);
	}

}
