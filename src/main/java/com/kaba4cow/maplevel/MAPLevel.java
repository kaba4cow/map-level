package com.kaba4cow.maplevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.kaba4cow.maplevel.elements.MAPEntity;

/**
 * Represents a collection of entities in a MAP file.
 */
public class MAPLevel implements MAPElement {

	private final List<MAPEntity> entities;

	public MAPLevel() {
		this.entities = new ArrayList<>();
	}

	/**
	 * Retrieves an unmodifiable list of entities in the model.
	 *
	 * @return an unmodifiable list of {@link MAPEntity} objects
	 */
	public List<MAPEntity> getEntities() {
		return Collections.unmodifiableList(entities);
	}

	/**
	 * Retrieves entities matching a given predicate.
	 *
	 * @param predicate the condition to filter entities
	 * 
	 * @return a list of entities matching the predicate
	 */
	public List<MAPEntity> getEntities(Predicate<MAPEntity> predicate) {
		return entities.stream().filter(predicate).collect(Collectors.toList());
	}

	/**
	 * Retrieves a entity from the model by its index.
	 *
	 * @param index the index of the entity
	 * 
	 * @return a reference to this object
	 */
	public MAPEntity getEntity(int index) {
		return entities.get(index);
	}

	/**
	 * Adds a entity to the model.
	 *
	 * @param entity the {@link MAPEntity} to add
	 * 
	 * @return a reference to this object
	 */
	public MAPLevel addEntity(MAPEntity entity) {
		entities.add(entity);
		return this;
	}

	/**
	 * Removes a entity from the model by its index.
	 *
	 * @param index the index of the entity to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPLevel removeEntity(int index) {
		entities.remove(index);
		return this;
	}

	/**
	 * Removes a specified entity from the model.
	 *
	 * @param entity the entity to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPLevel removeEntity(MAPEntity entity) {
		entities.remove(entity);
		return this;
	}

	/**
	 * Clears all entities from the model.
	 * 
	 * @return a reference to this object
	 */
	public MAPLevel clearEntities() {
		entities.clear();
		return this;
	}

	/**
	 * Returns the number of entities in the level.
	 * 
	 * @return the number of entities
	 */
	public int getEntityCount() {
		return entities.size();
	}

	/**
	 * Converts the level to its MAP string representation.
	 *
	 * @return the MAP string representation of this level
	 */
	@Override
	public String toMAPString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < entities.size(); i++) {
			builder.append(String.format("// Entity %s\n", i));
			builder.append(entities.get(i).toMAPString());
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MAPLevel [entities=%s]", entities);
	}

}
