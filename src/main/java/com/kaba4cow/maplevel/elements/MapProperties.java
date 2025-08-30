package com.kaba4cow.maplevel.elements;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.kaba4cow.maplevel.MapElement;
import com.kaba4cow.stringview.StringView;

/**
 * Represents a set of properties for an entity in a MAP file.
 */
public class MapProperties implements MapElement {

	private final Map<String, String> properties;

	MapProperties() {
		this.properties = new LinkedHashMap<>();
	}

	/**
	 * Retrieves an unmodifiable map of properties.
	 * 
	 * @return map of properties
	 */
	public Map<String, String> getProperties() {
		return Collections.unmodifiableMap(this.properties);
	}

	/**
	 * Retrieves an unmodifiable set of property names.
	 * 
	 * @return set of property names
	 */
	public Set<String> getPropertyNames() {
		return Collections.unmodifiableSet(this.properties.keySet());
	}

	/**
	 * Retrieves an unmodifiable collection of property values.
	 * 
	 * @return collection of property values
	 */
	public Collection<String> getPropertyValues() {
		return Collections.unmodifiableCollection(this.properties.values());
	}

	/**
	 * Retrieves the property value associated with the specified key.
	 *
	 * @param key the property key
	 * 
	 * @return the property value corresponding to the key, or {@code null} if the key is not found
	 */
	public String get(String key) {
		return this.properties.get(key);
	}

	/**
	 * Creates and returns a {@link StringView} for a property value associated with the specified key.
	 * 
	 * @param key the property key
	 * 
	 * @return a {@link StringView} for the property value corresponding to the key
	 */
	public StringView view(String key) {
		return new StringView(this.get(key));
	}

	/**
	 * Sets the value string representation for a property with the specified key.
	 *
	 * @param key   the key of the property
	 * @param value the value of the property
	 * 
	 * @return a reference to this object
	 */
	public MapProperties set(String key, Object value) {
		this.properties.put(key, Objects.toString(value));
		return this;
	}

	/**
	 * Checks if a property with the specified key exists.
	 *
	 * @param key the key to check for
	 * 
	 * @return {@code true} if a property with the specified key exists, {@code false} otherwise
	 */
	public boolean has(String key) {
		return this.properties.containsKey(key);
	}

	/**
	 * Removes a property with the specified key.
	 *
	 * @param key the key of the property to remove
	 * 
	 * @return a reference to this object
	 */
	public MapProperties remove(String key) {
		this.properties.remove(key);
		return this;
	}

	/**
	 * Clears all properties from the collection.
	 *
	 * @return a reference to this object
	 */
	public MapProperties clear() {
		this.properties.clear();
		return this;
	}

	/**
	 * Returns the number of properties.
	 * 
	 * @return the number of properties
	 */
	public int getPropertyCount() {
		return this.properties.size();
	}

	/**
	 * Converts the set of properties to a MAP format.
	 *
	 * @return the MAP string representation of the properties
	 */
	@Override
	public String toMapString() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> property : this.properties.entrySet())
			builder.append(String.format("\"%s\" \"%s\"\n", property.getKey(), property.getValue()));
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MapProperties [properties=%s]", this.properties);
	}

}
