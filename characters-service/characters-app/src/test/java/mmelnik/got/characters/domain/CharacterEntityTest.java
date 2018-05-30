package mmelnik.got.characters.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CharacterEntityTest {

    private CharacterEntity testing;

    @Before
    public void setUp() {
        testing = new CharacterEntity();
    }

    @Test
    public void starkShouldDieInNextSeason() {
        testing.setFamilyName("Stark");
        assertThat(testing.shouldDieInNextSeason()).isTrue();
    }

    @Test
    public void targarienShouldNotDieInNextSeason() {
        testing.setFamilyName("Targarien");
        assertThat(testing.shouldDieInNextSeason()).isFalse();
    }

}