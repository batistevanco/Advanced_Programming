package be.vives.ti.stack;

import be.vives.ti.adt.Stack;

public class ArrayStack implements Stack<String>
{
    private final String[] stack;
    private int top;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Ongeldige capaciteit");
        }
        stack = new String[capacity];
        top = 0;
    }


    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void push(String s) {
        if(isStackFull()){
            throw new IllegalStateException("Stack is vol");
        }

        stack[top++] = s;
    }

    @Override
    public String pop() {
        if(isEmpty()){
            return null;
        }
        top--;
        String element = stack[top];
        stack[top] = null;
        return element;
    }

    @Override
    public String peek() {
        if(isEmpty()){
            return null;
        }
        return stack[top - 1];
    }

    private boolean isStackFull() {
        return top == stack.length;
    }

}
