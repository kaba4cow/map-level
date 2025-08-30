package com.kaba4cow.maplevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kaba4cow.maplevel.elements.MapAxis;
import com.kaba4cow.maplevel.elements.MapBrush;
import com.kaba4cow.maplevel.elements.MapEntity;
import com.kaba4cow.maplevel.elements.MapFace;
import com.kaba4cow.maplevel.elements.MapPoint;
import com.kaba4cow.maplevel.elements.MapTransform;

/**
 * A utility class for reading MAP data from {@link Reader} or strings and converting it to {@link MapLevel} objects.
 */
public class MapParser {

	private static final Pattern PROPERTY_PATTERN = Pattern.compile("\"([^\"]*)\"\\s*\"([^\"]*)\"");

	private MapParser() {}

	/**
	 * Reads the MAP data from the specified {@link Reader} and converts its contents to an {@link MapLevel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link MapLevel#clearEntities()}
	 * {@link MapLevel#clearObjects()}
	 * 
	 * @param source the {@link Reader} to read the MAP data from
	 * @param target the {@link MapLevel} to convert the MAP data to, or {@code null}
	 * 
	 * @return the {@link MapLevel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static MapLevel parse(Reader source, MapLevel target) throws IOException {
		Objects.requireNonNull(source, "Source must not be null");
		if (Objects.isNull(target))
			target = new MapLevel();
		else
			target.clearEntities();
		BufferedReader reader = new BufferedReader(source);
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("{"))
				MapParser.parseEntity(reader, target);
		}
		reader.close();
		return target;
	}

	/**
	 * Reads the MAP data from the specified string and converts its contents to an {@link MapLevel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link MapLevel#clearEntities()}
	 * 
	 * @param source the string to read the MAP data from
	 * @param target the {@link MapLevel} to convert the MAP data to, or {@code null}
	 * 
	 * @return the {@link MapLevel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static MapLevel parse(String source, MapLevel target) throws IOException {
		return MapParser.parse(new StringReader(source), target);
	}

	private static void parseEntity(BufferedReader reader, MapLevel level) throws IOException {
		MapEntity entity = new MapEntity();
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("{"))
				MapParser.parseBrush(reader, entity);
			else if (line.startsWith("}"))
				break;
			else if (line.startsWith("\""))
				MapParser.parseProperty(line, entity);
		}
		level.addEntity(entity);
	}

	private static void parseProperty(String line, MapEntity entity) {
		Matcher matcher = MapParser.PROPERTY_PATTERN.matcher(line);
		if (matcher.matches()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			entity.getProperties().set(key, value);
		}
	}

	private static void parseBrush(BufferedReader reader, MapEntity entity) throws IOException {
		MapBrush brush = new MapBrush();
		String line;
		while (Objects.nonNull(line = reader.readLine())) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("}"))
				break;
			else if (line.startsWith("("))
				MapParser.parseFace(line, brush);
		}
		entity.addBrush(brush);
	}

	private static void parseFace(String line, MapBrush brush) {
		Iterator<String> tokens = MapParser.parseFaceTokens(line).iterator();

		MapFace face = new MapFace();

		MapParser.initializePoint(face.getPoint1(), tokens);
		MapParser.initializePoint(face.getPoint2(), tokens);
		MapParser.initializePoint(face.getPoint3(), tokens);

		MapParser.initializeTexture(face, tokens);

		MapParser.initializeAxis(face.getAxisU(), tokens);
		MapParser.initializeAxis(face.getAxisV(), tokens);

		MapParser.initializeTransform(face.getTransform(), tokens);

		brush.addFace(face);
	}

	private static List<String> parseFaceTokens(String line) {
		List<String> tokens = new ArrayList<>();
		String[] parts = line.split("\\s+");
		for (String part : parts)
			if (!part.isEmpty() && !part.matches("[()\\[\\]]"))
				tokens.add(part);
		return tokens;
	}

	private static void initializePoint(MapPoint point, Iterator<String> tokens) {
		point.setX(Float.parseFloat(tokens.next()));
		point.setY(Float.parseFloat(tokens.next()));
		point.setZ(Float.parseFloat(tokens.next()));
	}

	private static void initializeTexture(MapFace face, Iterator<String> tokens) {
		face.setTexture(tokens.next());
	}

	private static void initializeAxis(MapAxis axis, Iterator<String> tokens) {
		axis.setX(Float.parseFloat(tokens.next()));
		axis.setY(Float.parseFloat(tokens.next()));
		axis.setZ(Float.parseFloat(tokens.next()));
		axis.setOffset(Float.parseFloat(tokens.next()));
	}

	private static void initializeTransform(MapTransform transform, Iterator<String> tokens) {
		transform.setRotation(Float.parseFloat(tokens.next()));
		transform.setScaleX(Float.parseFloat(tokens.next()));
		transform.setScaleY(Float.parseFloat(tokens.next()));
	}

}
