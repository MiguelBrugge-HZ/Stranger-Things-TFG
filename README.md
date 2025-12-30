# Stranger-Things-TFG

## Teamwork & Contributions
This project was developed collaboratively by two team members:
- **Miguel Brugge**
- **Xue Hu**

Design decisions were discussed together, and the overall architecture was agreed upon before implementation.

### Class Diagram
![Class Diagram](images/CD.png)

## Creational Design Pattern

### 1. Singleton

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
### 2. Factory Method

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

### 1. Decorator

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



## Structural Design Pattern

### 2. Facade
In this game, the Facade pattern is used to simplify the combat system by providing a single entry point for handling fights between characters.

Combat involves multiple responsibilities such as:
- Checking whether characters are alive
- Applying damage
- Executing attack moves
- Logging combat actions and results

Instead of letting stages or scenes manage these details directly, all combat-related logic is encapsulated in the `CombatFacade` class. This keeps the game flow clean. 
Scenes only need to call one method to start a fight, without knowing how damage, health, or logging are handled internally.

---

### Implementation
#### CombatFacade: a single entry point for managing combat

`CombatFacade` combine multiple subsystems and exposes `fight()` method to the rest of the game.

```java
public class CombatFacade {
    private final HealthSystem healthSystem = new HealthSystem();
    private final CombatLogger logger = new CombatLogger();

    public void fight(Character player, Character enemy) {
        System.out.println("Combat starts: " + player.getName() + " ⚔️ " + enemy.getName());

        while (healthSystem.isAlive(player) && healthSystem.isAlive(enemy)) {
            executeTurn(player, enemy, true);
            if (!healthSystem.isAlive(enemy)) break;

            executeTurn(enemy, player, false);
        }

        Character winner = healthSystem.isAlive(player) ? player : enemy;
        logger.logWinner(winner);
    }
}
```

#### HealthSystem: handles health and damage logic
```java
public class HealthSystem {

    public void applyDamage(Character target, int damage) {
        int newHealth = target.getHealth() - damage;
        target.setHealth(Math.max(newHealth, 0));
    }

    public boolean isAlive(Character character) {
        return character.getHealth() > 0;
    }
}
```

#### CombatLogger: responsible for combat output
```java
public class CombatLogger {

    public void logAttack(Character attacker, Character defender, int damage) {
        System.out.println(attacker.getName() + " deals " + damage +
                " 💥 damage ➡️ " + defender.getName());
        System.out.println(defender.getName() + " ❤️: " + defender.getHealth());
    }

    public void logWinner(Character winner) {
        System.out.println(winner.getName() + " wins the fight!🎖️");
    }
}
```

#### Move: encapsulates attack behavior
```java
public class Move {
    private final String name;
    private final int minDamage;
    private final int maxDamage;
    private final double hitChance;

    public int execute() {
        if (RANDOM.nextDouble() <= hitChance) {
            return RANDOM.nextInt(maxDamage - minDamage + 1) + minDamage;
        } else {
            return 0;
        }
    }
}
```


## Behavioral Design Pattern

### 1. State
In this game, the State pattern is applied through the scene system.  
Each game scene represents a different state of the game, and encapsulates the behavior that is specific to that stage.

Instead of using large conditional statements (such as `if` or `switch`) in the `GameManager` to control game flow, the behavior of the game changes naturally by switching between different `Scene` objects.

This makes the game flow easier to extend and maintain, as new scenes (states) can be added without modifying existing control logic.

- **State interface**: `Scene`
- **Concrete States**: `DnDScene`, `SchoolScene`, `UpsideDownScene`, `VecnaFightScene`
- **Context**: `GameStage`
---

### Implementation
#### Scene

The `Scene` class defines the common interface for all game states.  
Each concrete scene must implement its own behavior.

```java
public abstract class Scene {
    protected Character player;

    public abstract Character play();
    protected abstract void startScene();
    protected abstract void endScene();

    public void setPlayer(Character player) {
        this.player = player;
    }
}
```

#### DnDScene(Concrete State Example): Each scene controls its own behavior and does not rely on external condition checks to decide what should happen next.

```java
public class DnDScene extends Scene {

    @Override
    public Character play() {
        System.out.println("Stage 1 -- DnD");
        startScene();
        TransitionToSchool.play();
        endScene();
        return player;
    }

    @Override
    public void startScene() {
        System.out.println("DnDScene play");
        player = chooseWeapon(player);
    }

    @Override
    public void endScene() {
        System.out.println("DnDScene end");
    }
}
```

#### GameStage: It decides which Scene (state) is active, but does not know the internal details of that scene.

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


## Behavioral Design Pattern

### 2. Template Method
The Template Method pattern is used in the `GameStage` class to define the fixed structure of how a game stage is executed.

The `start()` method defines the overall for running a stage:
- creating a scene
- assigning the player
- executing the scene logic

While the overall flow remains unchanged, subclasses are allowed to customize the behavior by implementing the `createScene()` method. This ensures consistent stage execution while allowing flexibility for different stage content.

### Implementation
#### GameStage: Only specific steps are delegated to subclasses.

```java
public abstract class GameStage {

    abstract Scene createScene(); // Step to be customized by subclasses

    public Character start(Character player) {
        Scene scene = this.createScene();
        scene.setPlayer(player);
        return scene.play();
    }

    public void playTransition() {
        // Optional
    }
}
```