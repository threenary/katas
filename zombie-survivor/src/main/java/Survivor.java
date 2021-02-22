import sun.security.x509.AVA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Survivor {

    private static final int MAX_WOUNDS_UNTIL_DEAD = 2;
    private static final int MAX_EQUIPMENT_IN_HAND = 2;
    private static final int AVAILABLE_ACTIONS = 3;
    public int MAX_EQUIPMENT = 5;

    private final String name;
    private int wounds;
    private List<String> equipmentInHand = new ArrayList();
    private List<String> equipmentInReserve = new ArrayList();
    private int experience;
    private int actions = AVAILABLE_ACTIONS;
    private List<String> skills = new ArrayList<>();

    public Survivor(String name) {
        this.name = name;
    }

    public void hurt() {
        if (isDead())
            return;

        wounds++;

        if (!equipmentInReserve.isEmpty()) {
            equipmentInReserve.remove(0);
        } else if (!equipmentInHand.isEmpty()) {
            equipmentInHand.remove(0);
        }
    }

    public Collection getEquipment() {
        List<String> equipment = new ArrayList<String>();
        equipment.addAll(equipmentInHand);
        equipment.addAll(equipmentInReserve);
        return equipment;
    }

    public void addEquipment(String piece) {
        if (isEquipmentFull()) {
            removePieceOfReserve();
        }

        if (!isHandEquipmentFull()) {
            equipmentInHand.add(piece);
        } else {
            equipmentInReserve.add(piece);
        }
    }

    private boolean isHandEquipmentFull() {
        return equipmentInHand.size() >= MAX_EQUIPMENT_IN_HAND;
    }

    private void removePieceOfReserve() {
        equipmentInReserve.remove(equipmentInReserve.iterator().next());
    }

    private boolean isEquipmentFull() {
        int capacity = MAX_EQUIPMENT - wounds;
        return getEquipment().size() == capacity;
    }

    public boolean isDead() {
        return wounds >= MAX_WOUNDS_UNTIL_DEAD;
    }

    public Collection getEquipmentInHand() {
        return equipmentInHand;
    }

    public Collection getEquipmentInReserve() {
        return equipmentInReserve;
    }

    public String getName() {
        return name;
    }

    public int getWounds() {
        return wounds;
    }

    public Level getLevel() {
        return Level.getLevelForExperience(experience);
    }

    public void killZombie() {
        experience++;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getActions() {
        return actions;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    public List<String> getSkills() {
        return this.skills;
    }
}
