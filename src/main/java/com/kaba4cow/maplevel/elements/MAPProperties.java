package com.kaba4cow.maplevel.elements;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.kaba4cow.maplevel.MAPElement;
import com.kaba4cow.stringview.StringView;

/**
 * Represents a set of properties for an entity in a MAP file.
 */
public class MAPProperties implements MAPElement {

	private final Map<String, String> properties;

	MAPProperties() {
		this.properties = new LinkedHashMap<>();
	}

	/**
	 * Retrieves an unmodifiable map of properties.
	 * 
	 * @return map of properties
	 */
	public Map<String, String> getProperties() {
		return Collections.unmodifiableMap(properties);
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
	 * Retrieves the property value associated with the specified key, or default value string representation if the property is
	 * not set.
	 *
	 * @param key          the property key
	 * @param defaultValue the default value to return if the key is not found
	 * 
	 * @return the property value corresponding to the key, or {@code defaultValue} string representation if the key is not
	 *             found
	 */
	public String get(String key, Object defaultValue) {
		return properties.getOrDefault(key, Objects.toString(defaultValue));
	}

	/**
	 * Creates and returns a {@link StringView} for a property value associated with the specified key.
	 * 
	 * @param key the property key
	 * 
	 * @return a {@link StringView} for the property value corresponding to the key
	 */
	public StringView view(String key) {
		return new StringView(get(key));
	}

	/**
	 * Creates and returns a {@link StringView} for a property value associated with the specified key, or for the specified
	 * default value string representation.
	 * 
	 * @param key          the property key
	 * @param defaultValue the default value for the {@link StringView} if the key is not found
	 * 
	 * @return a {@link StringView} for the property value corresponding to the key
	 */
	public StringView view(String key, Object defaultValue) {
		return new StringView(get(key)).orElse(Objects.toString(defaultValue));
	}

	/**
	 * Sets the value string representation for a property with the specified key.
	 *
	 * @param key   the key of the property
	 * @param value the value of the property
	 * 
	 * @return a reference to this object
	 */
	public MAPProperties set(String key, Object value) {
		properties.put(key, Objects.toString(value));
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
		return properties.containsKey(key);
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
		return String.format("MAPProperties %s", properties);
	}

}
