import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SurvivorShould {

    private Survivor survivor;

    @Before
    public void setUp() throws Exception {
        survivor = new Survivor("Pepito");
    }

    @Test
    public void be_instantiated_with_name_no_wounds_experience_and_level_blue() {
        String name = "Pepito";
        assertThat(survivor.getName(), is(name));
        assertThat(survivor.getWounds(), is(0));
        assertThat(survivor.getExperience(), is(0));
        assertThat(survivor.getLevel(), is(Level.BLUE));
        assertThat(survivor.getActions(), is(3));
    }

    @Test
    public void die_when_receives_two_wounds() {
        survivor.hurt();
        survivor.hurt();
        assertTrue(survivor.isDead());
    }

    @Test
    public void ignore_more_than_two_wounds() {
        survivor.hurt();
        survivor.hurt();
        survivor.hurt();
        survivor.hurt();

        assertThat(survivor.getWounds(), is(2));
    }

    @Test
    public void has_five_pieces_of_equipment_when_add_six() {
        survivor.addEquipment("Axe");
        survivor.addEquipment("Baseball bat");
        survivor.addEquipment("Pistol");
        survivor.addEquipment("Katana");
        survivor.addEquipment("Bottled Water");
        survivor.addEquipment("Molotov");

        assertNotNull(survivor.getEquipment());
        assertThat(survivor.getEquipment().size(), is(5));
    }

    @Test
    public void has_two_pieces_of_equipment_in_hand_when_has_three_total_pieces() {
        survivor.addEquipment("Axe");
        survivor.addEquipment("Baseball bat");
        survivor.addEquipment("Pistol");

        assertThat(survivor.getEquipment().size(), is(3));
        assertThat(survivor.getEquipmentInHand().size(), is(2));
        assertThat(survivor.getEquipmentInReserve().size(), is(1));
    }

    @Test
    public void has_two_pieces_of_equipment_and_lose_one_when_wounded() {
        survivor.addEquipment("Axe");
        survivor.addEquipment("Baseball bat");
        survivor.hurt();

        assertThat(survivor.getEquipment().size(), is(1));
    }

    @Test
    public void reduces_capacity_when_wounded() {
        survivor.addEquipment("Axe");
        survivor.addEquipment("Baseball bat");
        survivor.addEquipment("Pistol");
        survivor.addEquipment("Katana");
        survivor.addEquipment("Molotov");

        survivor.hurt();
        survivor.hurt();

        survivor.addEquipment("Shotgun");

        assertThat(survivor.getEquipment().size(), is(3));
        assertThat(survivor.getEquipmentInHand().size(), is(2));
        assertThat(survivor.getEquipmentInReserve().size(), is(1));
    }

    @Test
    public void increase_experience_when_killing_zombie() {
        survivor.killZombie();
        assertThat(survivor.getExperience(), is(1));
    }

    @Test
    public void return_level_blue_when_experience_below_6() {
        survivor.setExperience(4);
        assertThat(survivor.getLevel(), is(Level.BLUE));
    }

    @Test
    public void return_level_yellow_when_experience_exceeds_6_and_18() {
        survivor.setExperience(12);
        assertThat(survivor.getLevel(), is(Level.YELLOW));
    }

    @Test
    public void return_level_orange_when_experience_exceeds_19_and_42() {
        survivor.setExperience(30);
        assertThat(survivor.getLevel(), is(Level.ORANGE));
    }

    @Test
    public void return_level_orange_when_experience_exceeds_42() {
        survivor.setExperience(100);
        assertThat(survivor.getLevel(), is(Level.RED));
    }
}
