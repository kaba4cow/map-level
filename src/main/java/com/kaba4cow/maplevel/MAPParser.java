package com.kaba4cow.maplevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kaba4cow.maplevel.elements.MAPBrush;
import com.kaba4cow.maplevel.elements.MAPEntity;
import com.kaba4cow.maplevel.elements.MAPFace;

/**
 * A utility class for reading MAP data from {@link Reader} or strings and converting it to {@link MAPLevel} objects.
 */
public class MAPParser {

	private MAPParser() {}

	/**
	 * Reads the MAP data from the specified {@link Reader} and converts its contents to an {@link MAPLevel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link MAPLevel#clearEntities()}
	 * {@link MAPLevel#clearObjects()}
	 * 
	 * @param source the {@link Reader} to read the MAP data from
	 * @param target the {@link MAPLevel} to convert the MAP data to, or {@code null}
	 * 
	 * @return the {@link MAPLevel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static MAPLevel parse(Reader source, MAPLevel target) throws IOException {
		Objects.requireNonNull(source, "Source must not be null");
		if (Objects.isNull(target))
			target = new MAPLevel();
		else
			target.clearEntities();
		BufferedReader reader = new BufferedReader(source);
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("{"))
				parseEntity(reader, target);
		}
		reader.close();
		return target;
	}

	/**
	 * Reads the MAP data from the specified string and converts its contents to an {@link MAPLevel} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link MAPLevel#clearEntities()}
	 * 
	 * @param source the string to read the MAP data from
	 * @param target the {@link MAPLevel} to convert the MAP data to, or {@code null}
	 * 
	 * @return the {@link MAPLevel} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static MAPLevel parse(String source, MAPLevel target) throws IOException {
		return parse(new StringReader(source), target);
	}

	private static void parseEntity(BufferedReader reader, MAPLevel level) throws IOException {
		MAPEntity entity = new MAPEntity();
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("{"))
				parseBrush(reader, entity);
			else if (line.startsWith("}"))
				break;
			else if (line.startsWith("\""))
				parseProperty(line, entity);
		}
		level.addEntity(entity);
	}

	private static void parseProperty(String line, MAPEntity entity) {
		Matcher matcher = Pattern.compile("\"([^\"]*)\"\\s*\"([^\"]*)\"").matcher(line);
		if (matcher.matches()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			entity.getProperties().set(key, value);
		}
	}

	private static void parseBrush(BufferedReader reader, MAPEntity entity) throws IOException {
		MAPBrush brush = new MAPBrush();
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty() || line.startsWith("//"))
				continue;
			else if (line.startsWith("}"))
				break;
			else if (line.startsWith("("))
				parseFace(line, brush);
		}
		entity.addBrush(brush);
	}

	private static void parseFace(String line, MAPBrush brush) {
		List<String> tokens = new ArrayList<>();
		String[] parts = line.split("\\s+");
		for (String part : parts)
			if (!part.isEmpty() && !part.matches("[()\\[\\]]"))
				tokens.add(part);
		MAPFace face = new MAPFace();
		int pointer = 0;

		face.getPoint1().setX(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint1().setY(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint1().setZ(Float.parseFloat(tokens.get(pointer++)));

		face.getPoint2().setX(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint2().setY(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint2().setZ(Float.parseFloat(tokens.get(pointer++)));

		face.getPoint3().setX(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint3().setY(Float.parseFloat(tokens.get(pointer++)));
		face.getPoint3().setZ(Float.parseFloat(tokens.get(pointer++)));

		face.setTexture(tokens.get(pointer++));

		face.getAxisU().setX(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisU().setY(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisU().setZ(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisU().setOffset(Float.parseFloat(tokens.get(pointer++)));

		face.getAxisV().setX(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisV().setY(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisV().setZ(Float.parseFloat(tokens.get(pointer++)));
		face.getAxisV().setOffset(Float.parseFloat(tokens.get(pointer++)));

		face.getTransform().setRotation(Float.parseFloat(tokens.get(pointer++)));
		face.getTransform().setScaleX(Float.parseFloat(tokens.get(pointer++)));
		face.getTransform().setScaleY(Float.parseFloat(tokens.get(pointer++)));

		brush.addFace(face);
	}

}
