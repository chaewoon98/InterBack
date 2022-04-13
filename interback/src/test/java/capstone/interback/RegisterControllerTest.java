package capstone.interback;

import capstone.interback.controller.RegisterController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void ok가_리턴됨() throws Exception{
        String str = "ok";

        mvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(str));
    }

    @Test
    public void userDTO가_리턴됨() throws Exception {
        String name = "woonie";
        String id = "woonie19";

         mvc.perform(get("/register/dto")
                 .param("name", name)
                 .param("id", id))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.name", is(name)))
                 .andExpect(jsonPath("$.id", is(id)));
    }
}
