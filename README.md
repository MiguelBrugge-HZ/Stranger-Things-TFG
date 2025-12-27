# Stranger-Things-TFG

## Creational Design Pattern

### 1. Singleton Pattern

In this game, the Singleton pattern is used to make sure that there is only one `GameManager` controlling the game flow and one `InputManager` handling all console input.

`GameManager` manages the entire game process, including starting the game, progressing through stages, and restarting the game when the player chooses to replay.

`InputManager` handles all user input using a single `Scanner` instance. This avoids creating multiple `Scanner` objects for `System.in` and keeps input behavior consistent during character selection, combat, and replay.

Because the game runs in a linear flow with multiple stages, combat rounds, and replay functionality, having multiple instances of these classes would lead to inconsistent game state and duplicated input handling. The Singleton pattern ensures that a single shared instance is used throughout the game.

---

### Implementation

#### GameManager: Controls the overall game flow
- Starts the game
- Progresses through multiple stages
- Handles character selection
- Restarts the game when the player chooses to replay

```java
public class GameManager {
    private static GameManager instance;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
}
```

#### InputManager: centralize all console input.
```java
public class InputManager {
    private static InputManager instance;
    private final Scanner scanner;

    private InputManager() {
        scanner = new Scanner(System.in);
    }

    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }
}
```

## Creational Design Pattern
### 2. Factory Method Pattern

In this game, the Factory Method pattern is used to create different types of game scenes, the main game flow doesn't need to know the exact scene classes.

The `GameStage` class defines a method for creating a `Scene`, but does not decide which specific scene is created. Each concrete stage is responsible for providing its own scene implementation. This allows the game to add new stages and scenes without changing the core game logic.

---

### Implementation

#### GameStage

`GameStage` defines the factory method `createScene()` and contains the shared logic for starting a stage.

```java
public abstract class GameStage {
    abstract Scene createScene();

    public Character start(Character player) {
        Scene scene = this.createScene();
        scene.setPlayer(player);
        return scene.play();
    }
}
```

#### Stage1
`Stage1` overrides the factory method `createScene()` to create a DnDScene.
```java
public class Stage1 extends GameStage {
    @Override
    Scene createScene() {
        return new DnDScene();
    }
}
```

## Structural Design Pattern

### 1. Decorator Pattern

In this game, the Decorator pattern is used to add weapons to a character during gameplay without modifying the original character classes.

Base characters such as `Eleven` are created first. During the stage, the player chooses a weapon. That weapon is applied by wrapping the existing character with a weapon decorator. This allows the character to gain new moves while keeping the original character implementation unchanged.

Using the Decorator pattern avoids creating many subclasses such as `ElevenWithBat` or `ElevenWithHammer` and makes it easy to add new weapons in the future.

---

### Implementation
#### CharacterDecorator: It copies the existing character’s state (name, health, moves) and allows subclasses to extend or modify behavior.

```java
public abstract class CharacterDecorator extends Character {

    protected final Character wrapped;

    protected CharacterDecorator(Character wrapped) {
        super(
            wrapped.getName(),
            wrapped.getHealth(),
            new ArrayList<>(wrapped.getMoves())
        );
        this.wrapped = wrapped;
    }

    @Override
    public Move chooseMove() {
        return super.chooseMove();
    }
}
```

#### BatDecorator: Adding bat weapon to a character by introducing a new attack move.

```java
public class BatDecorator extends CharacterDecorator {

    public BatDecorator(Character wrapped) {
        super(wrapped);
        moves.add(new Move("🏏 Bat Slash", 8, 18, 0.85));
    }

    @Override
    public String getName() {
        return wrapped.getName() + " with Bat";
    }
}
```