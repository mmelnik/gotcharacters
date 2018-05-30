package mmelnik.got.characters.interfaces.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import interfaces.rest.GoTCharacter;

public class CharacterRestService {

    private static final String BASE_URL = "/characters";

    private final RestTemplate restTemplate = new RestTemplate();
    private String home = "http://localhost:8080";

    public List<GoTCharacter> list() {
        return Arrays.asList(restTemplate.getForObject(home + BASE_URL, GoTCharacter[].class));
    }

    public GoTCharacter add(GoTCharacter character) {
        return restTemplate.postForObject(home + BASE_URL, character, GoTCharacter.class);
    }

    public GoTCharacter get(long id) {
        return restTemplate.getForObject(home + BASE_URL + "/" + id, GoTCharacter.class);
    }

    public void update(long id, GoTCharacter character) {
        restTemplate.put(home + BASE_URL + "/" + id, character);
    }

    public void delete(long id) {
        restTemplate.delete(home + BASE_URL + "/" + id);
    }

}
