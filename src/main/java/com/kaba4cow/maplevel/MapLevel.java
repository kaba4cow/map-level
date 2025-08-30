package com.kaba4cow.maplevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kaba4cow.maplevel.elements.MapEntity;

/**
 * Represents a collection of entities in a MAP file.
 */
public class MapLevel implements MapElement {

	private final List<MapEntity> entities;

	public MapLevel() {
		this.entities = new ArrayList<>();
	}

	/**
	 * Retrieves an unmodifiable list of entities in the model.
	 *
	 * @return an unmodifiable list of {@link MapEntity} objects
	 */
	public List<MapEntity> getEntities() {
		return Collections.unmodifiableList(this.entities);
	}

	/**
	 * Retrieves entities matching a given predicate.
	 *
	 * @param predicate the condition to filter entities
	 * 
	 * @return a list of entities matching the predicate
	 */
	public List<MapEntity> getEntities(Predicate<MapEntity> predicate) {
		return this.entities.stream().filter(predicate).collect(Collectors.toList());
	}

	/**
	 * Retrieves a entity from the model by its index.
	 *
	 * @param index the index of the entity
	 * 
	 * @return a reference to this object
	 */
	public MapEntity getEntity(int index) {
		return this.entities.get(index);
	}

	/**
	 * Adds a entity to the model.
	 *
	 * @param entity the {@link MapEntity} to add
	 * 
	 * @return a reference to this object
	 */
	public MapLevel addEntity(MapEntity entity) {
		this.entities.add(entity);
		return this;
	}

	/**
	 * Removes a entity from the model by its index.
	 *
	 * @param index the index of the entity to remove
	 * 
	 * @return a reference to this object
	 */
	public MapLevel removeEntity(int index) {
		this.entities.remove(index);
		return this;
	}

	/**
	 * Removes a specified entity from the model.
	 *
	 * @param entity the entity to remove
	 * 
	 * @return a reference to this object
	 */
	public MapLevel removeEntity(MapEntity entity) {
		this.entities.remove(entity);
		return this;
	}

	/**
	 * Clears all entities from the model.
	 * 
	 * @return a reference to this object
	 */
	public MapLevel clearEntities() {
		this.entities.clear();
		return this;
	}

	/**
	 * Returns the number of entities in the level.
	 * 
	 * @return the number of entities
	 */
	public int getEntityCount() {
		return this.entities.size();
	}

	/**
	 * Converts the level to its MAP string representation.
	 *
	 * @return the MAP string representation of this level
	 */
	@Override
	public String toMapString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.entities.size(); i++) {
			builder.append(String.format("// Entity %s\n", i));
			builder.append(this.entities.get(i).toMapString());
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MapLevel [entities=%s]", this.entities);
	}

}
