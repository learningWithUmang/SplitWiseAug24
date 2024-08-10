package dev.umang.splitwiseaug24.Command;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {
    private SettleUpUserCommand settleUpUserCommand;
    private RegisterUserCommand registerUserCommand;
    private CreateGroupCommand createGroupCommand;
    public CommandExecutor(SettleUpUserCommand settleUpUserCommand,
                           RegisterUserCommand registerUserCommand,
                           CreateGroupCommand createGroupCommand){
        this.settleUpUserCommand = settleUpUserCommand;
        this.registerUserCommand = registerUserCommand;
        this.createGroupCommand = createGroupCommand;
    }
    public List<Command> commands = List.of(
            settleUpUserCommand, createGroupCommand, registerUserCommand
    );

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
