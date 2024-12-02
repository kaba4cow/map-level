package com.kaba4cow.maplevel.elements;

import java.util.LinkedHashMap;
import java.util.Map;

import com.kaba4cow.maplevel.MAPElement;

/**
 * Represents a set of properties for an entity in a MAP file.
 */
public class MAPProperties implements MAPElement {

	private final Map<String, String> properties;

	MAPProperties() {
		this.properties = new LinkedHashMap<>();
	}

	/**
	 * Retrieves the property value associated with the specified key.
	 *
	 * @param key the property key
	 * 
	 * @return the property value corresponding to the key, or {@code null} if the key is not found
	 */
	public String get(String key) {
		return properties.get(key);
	}

	/**
	 * Retrieves the property value associated with the specified key, or a default value if the property is not set.
	 *
	 * @param key          the property key
	 * @param defaultValue the default value to return if the key is not found
	 * 
	 * @return the property value corresponding to the key, or {@code defaultValue} if the key is not found
	 */
	public String get(String key, String defaultValue) {
		return properties.getOrDefault(key, defaultValue);
	}

	/**
	 * Sets the value for a property with the specified key.
	 *
	 * @param key   the key of the property
	 * @param value the value of the property
	 * 
	 * @return a reference to this object
	 */
	public MAPProperties set(String key, String value) {
		properties.put(key, value);
		return this;
	}

	/**
	 * Removes a property with the specified key.
	 *
	 * @param key the key of the property to remove
	 * 
	 * @return a reference to this object
	 */
	public MAPProperties remove(String key) {
		properties.remove(key);
		return this;
	}

	/**
	 * Clears all properties from the collection.
	 *
	 * @return a reference to this object
	 */
	public MAPProperties clear() {
		properties.clear();
		return this;
	}

	/**
	 * Returns the number of properties.
	 * 
	 * @return the number of properties
	 */
	public int getPropertyCount() {
		return properties.size();
	}

	/**
	 * Converts the set of properties to a MAP format.
	 *
	 * @return the MAP string representation of the properties
	 */
	@Override
	public String toMAPString() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> property : properties.entrySet())
			builder.append(String.format("\"%s\" \"%s\"\n", property.getKey(), property.getValue()));
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("MAPProperties [properties=%s]", properties);
	}

}
