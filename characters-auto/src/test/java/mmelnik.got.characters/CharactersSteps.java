package mmelnik.got.characters;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interfaces.rest.GoTCharacter;
import mmelnik.got.characters.interfaces.rest.CharacterRestService;

public class CharactersSteps {

    private CharacterRestService characterRestService;

    private GoTCharacter character1;
    private GoTCharacter character2;

    public CharactersSteps() {
        this.characterRestService = new CharacterRestService();
    }

    @Given("^I created new character$")
    public void createNewCharacter() {
        character1 = GoTCharacter.builder()
                .nickname("Hodor")
                .build();
    }

    @When("^I add created character to character list$")
    public void addCreatedCharacter() {
        character1 = characterRestService.add(character1);
    }

    @Then("^Created character appears in characters list$")
    public void сreatedCharacterAppearsInCharacterList() {
        List<GoTCharacter> list = characterRestService.list();
        assertThat(list).contains(character1);
    }

    @Given("^I have character from list that exists in system$")
    public void thereIsACharacterInCharacterList() {
        character1 = characterRestService.get(character1.getId());
    }

    @When("^I update character with new values$")
    public void iUpdateCharacterWithNewValues() {
        character1.setFamilyName("Baratheon");
        character1.setFirstName("Jofrey");
        characterRestService.update(character1.getId(), character1);
    }

    @Then("^Character is updated in characters list$")
    public void characterIsUpdatedInCharactersList() {
        GoTCharacter actual = characterRestService.get(character1.getId());
        assertThat(actual).isEqualTo(character1);
    }

    @When("^I delete character$")
    public void iDeleteCharacter() {
        characterRestService.delete(character1.getId());
    }

    @Then("^Character is not present in characters list$")
    public void characterIsNotPresentInCharactersList() {
        assertThat(characterRestService.list()).doesNotContain(character1);
    }

    @When("^I select character from the list by id$")
    public void iSelectCharacterFromTheListById() {
        character2 = characterRestService.get(character1.getId());
    }

    @Then("^Existing character is returned$")
    public void existingCharacterIsReturned() {
        assertThat(character2).isEqualTo(character1);
    }
}
