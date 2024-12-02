# MAP Level Library

A lightweight **Java** library for parsing and manipulating **[MAP](https://quakewiki.org/wiki/Quake_Map_Format)** level files.

## Features

- Parse MAP files with complete structural representation
- Support for:
  - Entities
  - Entity properties
  - Brushes
  - Faces
  - Texture properties
- Immutable collections for safe object manipulation
- Detailed string representations of MAP elements

**Note:** This library only supports the **Valve220 MAP** file format.

## Key Components

### `MAPLevel`
Central class representing an entire MAP file, containing:
- Collection of entities
- Methods to add, remove, and manage entities

### `MAPEntity`
Represents a single entity in the MAP file:
- Properties storage (`MAPProperties`)
- Brush collection management

### `MAPBrush`
Represents a brush within an entity:
- Face collection
- Methods for face manipulation

### `MAPFace`
Defines a single face with:
- Three defining points (`MAPPoint`)
- Texture information
- Texture axis (`MAPAxis`)
- Texture transform (`MAPTransform`)

## Usage

```java
MAPLevel level = MAPParser.parse(new FileReader("path/to/your/file.map"), null);
for (MAPEntity entity : level.getEntities()) {
    MAPProperties properties = entity.getProperties();
    for (MAPBrush brush : entity.getBrushes()) {
        List<MAPFace> faces = brush.getFaces("old_texture");
        for (MAPFace face : faces)
            face.setTexture("new_texture");
    }
}
String map = level.toMAPString();
```