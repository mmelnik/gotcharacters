package interfaces.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoTCharacter {

    private long id;
    private String firstName;
    private String familyName;
    private String shortName;
    private String nickname;

    public GoTCharacter(String firstName, String familyName, String shortName, String nickname) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.shortName = shortName;
        this.nickname = nickname;
    }

}
