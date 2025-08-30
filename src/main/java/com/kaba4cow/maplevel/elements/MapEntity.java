package com.kaba4cow.maplevel.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kaba4cow.maplevel.MapElement;

/**
 * Represents an entity in a MAP file.
 */
public class MapEntity implements MapElement {

	private final MapProperties properties;
	private final List<MapBrush> brushes;

	public MapEntity() {
		this.properties = new MapProperties();
		this.brushes = new ArrayList<>();
	}

	/**
	 * Retrieves the entity properties.
	 * 
	 * @return entity properties
	 */
	public MapProperties getProperties() {
		return this.properties;
	}

	/**
	 * Retrieves an unmodifiable list of brushes.
	 *
	 * @return an unmodifiable list of {@link MapBrush} objects
	 */
	public List<MapBrush> getBrushes() {
		return Collections.unmodifiableList(this.brushes);
	}

	/**
	 * Retrieves a brush from the model by its index.
	 *
	 * @param index the index of the brush
	 * 
	 * @return a reference to this object
	 */
	public MapBrush getBrush(int index) {
		return this.brushes.get(index);
	}

	/**
	 * Adds a brush to the model.
	 *
	 * @param brush the {@link MapBrush} to add
	 * 
	 * @return a reference to this object
	 */
	public MapEntity addBrush(MapBrush brush) {
		this.brushes.add(brush);
		return this;
	}

	/**
	 * Removes a brush from the model by its index.
	 *
	 * @param index the index of the brush to remove
	 * 
	 * @return a reference to this object
	 */
	public MapEntity removeBrush(int index) {
		this.brushes.remove(index);
		return this;
	}

	/**
	 * Removes a specified brush from the model.
	 *
	 * @param brush the brush to remove
	 * 
	 * @return a reference to this object
	 */
	public MapEntity removeBrush(MapBrush brush) {
		this.brushes.remove(brush);
		return this;
	}

	/**
	 * Clears all brushes from the model.
	 * 
	 * @return a reference to this object
	 */
	public MapEntity clearBrushes() {
		this.brushes.clear();
		return this;
	}

	/**
	 * Returns the number of brushes in the entity.
	 * 
	 * @return the number of brushes
	 */
	public int getBrushCount() {
		return this.brushes.size();
	}

	@Override
	public String toMapString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		builder.append(this.properties.toMapString());
		for (int i = 0; i < this.brushes.size(); i++) {
			builder.append(String.format("// Brush %s\n", i));
			builder.append(this.brushes.get(i).toMapString()).append("\n");
		}
		builder.append("}");
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MapEntity [properties=%s, brushes=%s]", this.properties, this.brushes);
	}

}
