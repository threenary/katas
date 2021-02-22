import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Survivor> survivors = new ArrayList<Survivor>();
    private List<String> history = new ArrayList<>();

    public List<Survivor> getSurvivors() {
        return survivors;
    }

    public void addSurvivor(Survivor survivor) {
        if (survivors.stream().noneMatch(aSurvivor -> aSurvivor.getName().equals(survivor.getName()))) {
            survivors.add(survivor);
            addEventToHistory("Survivor " + survivor.getName() + " was added to the game");
        }
    }

    public boolean isOver() {
        return survivors.stream().allMatch(Survivor::isDead);
    }

    public Level getLevel() {
        if (survivors.isEmpty()) {
            return Level.BLUE;
        }

        int maxExperienceSurvivor = survivors.stream()
                .mapToInt(Survivor::getExperience)
                .max()
                .getAsInt();

        return Level.getLevelForExperience(maxExperienceSurvivor);
    }

    public List<String> getHistory() {
        return this.history;
    }

    public void addEquipmentToSurvivor(Survivor survivor, String equipment) {
        Survivor survivorInGame = findSurvivorInGame(survivor.getName());
        survivorInGame.addEquipment(equipment);
        addEventToHistory("Survivor " + survivorInGame.getName() + " acquired " + equipment);
    }

    private Survivor findSurvivorInGame(String survivorName) {
        for (Survivor aSurvivor : survivors) {
            if (survivorName.equals(aSurvivor.getName())) {
                return aSurvivor;
            }
        }
        // TODO - Throw exception if survivor is not in the game
        return null;
    }

    private void addEventToHistory(String event) {
        history.add(event);
    }

    public void woundSurvivor(Survivor survivor) {
        Survivor survivorInGame = findSurvivorInGame(survivor.getName());
        survivorInGame.hurt();
        addEventToHistory("Survivor " + survivorInGame.getName() + " was wounded");

        if (survivorInGame.isDead()) {
            addEventToHistory("Survivor " + survivorInGame.getName() + " was killed");
            if (survivors.stream().allMatch(Survivor::isDead)) {
                addEventToHistory("Game over");
            }
        }

    }

    public void killZombieBy(Survivor survivor) {
        Survivor survivorInGame = findSurvivorInGame(survivor.getName());
        Level survivorLevelBeforeKilling = survivor.getLevel();
        Level gameLevelBeforeKilling = this.getLevel();
        survivorInGame.killZombie();

        if (isSurvivorLevelUp(survivorLevelBeforeKilling, survivorInGame) || isSurvivorReachingLevelAgain(survivorInGame)) {
            if (isSurvivorLevelUp(survivorLevelBeforeKilling, survivorInGame)) {
                addEventToHistory("Survivor " + survivor.getName() + " level up");

                if (isGameLevelUp(gameLevelBeforeKilling)) {
                    addEventToHistory("Game level up");
                }
            }
            unlockSkillForSurvivor(survivorInGame);
        }

    }

    private boolean isSurvivorReachingLevelAgain(Survivor survivorInGame) {
        return survivorInGame.getExperience() == 61
                || survivorInGame.getExperience() == 86
                || survivorInGame.getExperience() == 105
                || survivorInGame.getExperience() == 129;
    }

    private boolean isSurvivorLevelUp(Level levelBeforeKilling, Survivor survivor) {
        return levelBeforeKilling != survivor.getLevel();
    }

    private boolean isGameLevelUp(Level levelBeforeKilling) {
        return levelBeforeKilling != this.getLevel();
    }

    private void unlockSkillForSurvivor(Survivor survivor) {
        if (isSurvivorReachingLevelAgain(survivor)) {
            if (survivor.getExperience() == 61) {
                survivor.getSkills().add("+1 Free Move Action");
                return;
            }

            if (survivor.getExperience() == 86) {
                survivor.getSkills().add("Hoard");
                survivor.MAX_EQUIPMENT++;
                return;
            }

            if (survivor.getExperience() == 105) {
                survivor.getSkills().add("Sniper");
                return;
            }

            if (survivor.getExperience() == 129) {
                survivor.getSkills().add("Tough");
                return;
            }
        }

        if (survivor.getLevel().equals(Level.YELLOW)) {
            survivor.getSkills().add("+1 Action");
            survivor.setActions(4);
        }

        if (survivor.getLevel().equals(Level.ORANGE)) {
            survivor.getSkills().add("+1 Die (Ranged)");
        }

        if (survivor.getLevel().equals(Level.RED)) {
            survivor.getSkills().add("+1 Die (Melee)");
        }
    }
}
