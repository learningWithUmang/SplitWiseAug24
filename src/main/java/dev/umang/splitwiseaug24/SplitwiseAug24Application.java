package dev.umang.splitwiseaug24;

import dev.umang.splitwiseaug24.Command.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAug24Application implements CommandLineRunner {

    private CommandExecutor commandExecutor;
    public SplitwiseAug24Application(CommandExecutor commandExecutor,
                                     SettleUpUserCommand settleUpUserCommand,
                                     CreateGroupCommand createGroupCommand,
                                     RegisterUserCommand registerUserCommand){
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseAug24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        while(true){
            String input = scanner.next();
            //give the input to command executor
            commandExecutor.execute(input);
        }
    }
}
