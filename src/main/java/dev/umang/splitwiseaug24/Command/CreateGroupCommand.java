package dev.umang.splitwiseaug24.Command;

import org.springframework.stereotype.Component;

@Component
public class CreateGroupCommand implements Command{
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
