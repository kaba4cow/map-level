# MAP Level Library

A lightweight **Java** library for parsing and manipulating **[MAP](https://quakewiki.org/wiki/Quake_Map_Format)** level files.

## Features

- Parse MAP files with complete structural representation
- Support for entities, entity properties, brushes, faces and texture properties
- Immutable collections for safe object manipulation
- Detailed string representations of MAP elements

**Note:** This library only supports the **Valve220 MAP** file format.

## Key Components

### `MapLevel`
Central class representing an entire MAP file, containing:
- Collection of entities
- Methods to add, remove, and manage entities

### `MapEntity`
Represents a single entity in the MAP file:
- Properties storage (`MapProperties`)
- Brush collection management

### `MapBrush`
Represents a brush within an entity:
- Face collection
- Methods for face manipulation

### `MapFace`
Defines a single face with:
- Three defining points (`MapPoint`)
- Texture information
- Texture axis (`MapAxis`)
- Texture transform (`MapTransform`)

## Usage

```java
MapLevel level = MapParser.parse(new FileReader("path/to/your/file.map"), null);
for (MapEntity entity : level.getEntities()) {
    MapProperties properties = entity.getProperties();
    for (MapBrush brush : entity.getBrushes()) {
        List<MapFace> faces = brush.getFaces("old_texture");
        for (MapFace face : faces)
            face.setTexture("new_texture");
    }
}
String map = level.toMapString();
```

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.