package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitStringsWithComma() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitString() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메서드 인덱스 범위 에러 테스트")
    void charAt() {
        assertThatThrownBy(() -> {
            Character result = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
