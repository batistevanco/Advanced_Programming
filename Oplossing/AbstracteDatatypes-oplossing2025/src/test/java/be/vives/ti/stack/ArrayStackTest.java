package be.vives.ti.stack;

import be.vives.ti.adt.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArrayStackTest {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack(5);
    }

    @Test
    void makeStackWithInvalidCapacity() {
        assertThatThrownBy(() -> new ArrayStack(0))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void pushOnEmptyStack() {
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.peek()).isNull();

        stack.push("one");

        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.peek()).isEqualTo("one");

    }

    @Test
    void pushOnNotEmptyStack() {
        stack.push("one");
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.peek()).isEqualTo("one");

        stack.push("two");

        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.peek()).isEqualTo("two");
    }

    @Test
    void pushOnFullStack() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");

        assertThatThrownBy(() -> stack.push("six"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Stack is vol");
    }

    @Test
    void popOnEmptyStack() {
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.peek()).isNull();

        assertThat(stack.pop()).isNull();

        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    void popOnStack() {
        stack.push("one");
        stack.push("two");
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.peek()).isEqualTo("two");

        assertThat(stack.pop()).isEqualTo("two");

        assertThat(stack.peek()).isEqualTo("one");
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(1);
    }

}