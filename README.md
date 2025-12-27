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


