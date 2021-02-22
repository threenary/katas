import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameShould {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void have_no_survivors_when_created() {
        assertTrue(game.getSurvivors().isEmpty());
    }

    @Test
    public void have_three_survivors_when_three_added() {
        game.addSurvivor(new Survivor("Pepito"));
        game.addSurvivor(new Survivor("Wanchope"));
        game.addSurvivor(new Survivor("Josecito"));

        assertThat(game.getSurvivors().size(), is(3));
    }

    @Test
    public void have_three_survivors_when_fourth_has_repeated_name() {
        game.addSurvivor(new Survivor("Pepito"));
        game.addSurvivor(new Survivor("Wanchope"));
        game.addSurvivor(new Survivor("Josecito"));
        game.addSurvivor(new Survivor("Josecito"));

        assertThat(game.getSurvivors().size(), is(3));
    }

    @Test
    public void finish_when_all_survivors_die() {
        Survivor pepito = new Survivor("Pepito");
        game.addSurvivor(pepito);
        Survivor wanchope = new Survivor("Wanchope");
        game.addSurvivor(wanchope);

        pepito.hurt();
        pepito.hurt();
        wanchope.hurt();
        wanchope.hurt();

        assertTrue(game.isOver());
    }

    @Test
    public void be_level_blue_when_survivor_is_new() {
        Survivor survivor = new Survivor("Pepito");
        game.addSurvivor(survivor);

        assertThat(game.getLevel(), is(Level.BLUE));
    }

    @Test
    public void be_level_orange_when_survivor_is_orange_level() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(20);
        game.addSurvivor(survivor);

        assertThat(game.getLevel(), is(Level.ORANGE));
    }

    @Test
    public void be_level_red_when_at_least_one_survivor_is_red_level() {
        Survivor blueSurvivor = new Survivor("Blue");
        blueSurvivor.setExperience(3);
        game.addSurvivor(blueSurvivor);

        Survivor yellowSurvivor = new Survivor("Yellow");
        yellowSurvivor.setExperience(10);
        game.addSurvivor(yellowSurvivor);

        Survivor orangeSurvivor = new Survivor("Orange");
        orangeSurvivor.setExperience(20);
        game.addSurvivor(orangeSurvivor);

        Survivor redSurvivor = new Survivor("Red");
        redSurvivor.setExperience(209);
        game.addSurvivor(redSurvivor);

        assertThat(game.getLevel(), is(Level.RED));
    }

    @Test
    public void be_level_yellow_when_max_level_survivor_is_yellow_level() {
        Survivor blueSurvivor1 = new Survivor("Blue");
        blueSurvivor1.setExperience(3);
        game.addSurvivor(blueSurvivor1);

        Survivor yellowSurvivor1 = new Survivor("Yellow");
        yellowSurvivor1.setExperience(10);
        game.addSurvivor(yellowSurvivor1);

        Survivor blueSurvivor2 = new Survivor("Blue");
        blueSurvivor2.setExperience(5);
        game.addSurvivor(blueSurvivor2);

        Survivor yellowSurvivor2 = new Survivor("Yellow");
        yellowSurvivor2.setExperience(17);
        game.addSurvivor(yellowSurvivor2);

        assertThat(game.getLevel(), is(Level.YELLOW));
    }

    @Test
    public void be_level_blue_when_game_starts_without_survivors() {
        assertThat(game.getLevel(), is(Level.BLUE));
    }

    @Test
    public void get_history_with_survivor_added_to_the_game_when_a_survivor_is_added_to_the_game() {
        game.addSurvivor(new Survivor("Pepito"));

        assertTrue(game.getHistory().contains("Survivor Pepito was added to the game"));
    }

    @Test
    public void get_history_with_survivor_acquires_equipment_when_a_survivor_acquires_equipment() {
        Survivor survivor = new Survivor("Pepito");
        game.addSurvivor(survivor);
        game.addEquipmentToSurvivor(survivor, "Axe");

        assertTrue(game.getHistory().contains("Survivor Pepito acquired Axe"));
    }

    @Test
    public void get_history_with_survivor_wounded_when_a_survivor_is_wounded() {
        Survivor survivor = new Survivor("Pepito");
        game.addSurvivor(survivor);
        game.woundSurvivor(survivor);

        assertTrue(game.getHistory().contains("Survivor Pepito was wounded"));
    }

    @Test
    public void get_history_with_survivor_dead_when_a_survivor_dies() {
        Survivor survivor = new Survivor("Pepito");
        game.addSurvivor(survivor);
        game.woundSurvivor(survivor);
        game.woundSurvivor(survivor);

        assertTrue(game.getHistory().contains("Survivor Pepito was killed"));
    }

    @Test
    public void get_history_with_survivor_levels_up_when_a_survivor_increases_its_level() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(6);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(game.getHistory().contains("Survivor Pepito level up"));
    }

    @Test
    public void get_history_with_game_levels_up_when_a_game_increases_its_level() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(6);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(game.getHistory().contains("Game level up"));
    }

    @Test
    public void get_history_with_game_end_when_all_survivors_die() {
        Survivor survivor = new Survivor("Pepito");
        game.addSurvivor(survivor);
        game.woundSurvivor(survivor);
        game.woundSurvivor(survivor);

        assertTrue(game.getHistory().contains("Game over"));
    }

    @Test
    public void make_survivor_level_up_to_yellow_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(6);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertThat(survivor.getActions(), is(4));
        assertTrue(survivor.getSkills().contains("+1 Action"));
    }

    @Test
    public void make_survivor_level_up_to_orange_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(18);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("+1 Die (Ranged)"));
    }

    @Test
    public void make_survivor_level_up_to_red_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(42);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("+1 Die (Melee)"));
    }

    @Test
    public void make_survivor_level_up_to_orange_second_time_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(60);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("+1 Free Move Action"));
    }

    @Test
    public void make_survivor_level_up_to_red_second_time_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(85);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("Hoard"));
        assertThat(survivor.MAX_EQUIPMENT, is(6));
    }

    @Test
    public void make_survivor_level_up_to_orange_third_time_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(104);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("Sniper"));
    }

    @Test
    public void make_survivor_level_up_to_red_third_time_when_survivor_kills_zombie_and_experience_level_is_reached() {
        Survivor survivor = new Survivor("Pepito");
        survivor.setExperience(128);
        game.addSurvivor(survivor);
        game.killZombieBy(survivor);

        assertTrue(survivor.getSkills().contains("Tough"));
    }
}
