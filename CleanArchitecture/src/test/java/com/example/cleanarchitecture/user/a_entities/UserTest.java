package com.example.cleanarchitecture.user.a_entities;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void given123Password_WhenPasswordInvalid_thenIsFalse() {
        User user = new User("RathGate", "123");
        assertThat(user.isPasswordValid()).isFalse();
    }

}
