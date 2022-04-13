package capstone.interback;

import capstone.interback.dto.UserDTO;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDtoTest {

    @Test
    public void 롬복_기능_테스트(){

        //given
        String name = "woonie";
        String id = "woonie19";

        //when
        UserDTO userDTO = new UserDTO(name, id);

        //then
        assertThat(userDTO.getName()).isEqualTo(name);
        assertThat(userDTO.getId()).isEqualTo(id);
    }
}
