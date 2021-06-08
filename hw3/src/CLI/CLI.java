package CLI;
import static utils.Inputs.readCommand;
import Commands.Command;
import FileSystem.FileSystem;
import FileSystem.Node;

import java.util.List;
import java.util.Arrays;

public class CLI {
    private FileSystem fileSystem;
    private Node currentWorkingDirectory;
    private List<Command> commands;
    private Boolean sessionAlive;

    public CLI(List<Command> commands, FileSystem fileSystem) {
        this.fileSystem = fileSystem;
        this.currentWorkingDirectory = this.fileSystem.getRootDirectory();
        this.sessionAlive = true;
        this.commands = commands;
    }

    public void start() {
        while (sessionAlive) {
            printCurrentPath();
            String command = readCommand();
            executeCommand(command);
        }
    }

    private void printCurrentPath() {
        System.out.println("Current path: " + currentWorkingDirectory.getFullPath());
    }

    public void executeCommand(String command) {
        List<String> segments = Arrays.asList(command.split("\\s"));

        try {
            String commandName = segments.get(0);
            Command commandProgram = getCommandProgram(commandName);
            List<String> parameters = segments.size() > 1 ? segments.subList(1, segments.size()) : null;
            commandProgram.action(parameters, this, fileSystem);
        } catch (Exception err) {
            System.out.println("Illegal command.");
        }
    }

    private Command getCommandProgram(String commandName) {
        for (Command command : commands) {
            if (command.toString().equals(commandName)) {
                return command;
            }
        }

        return null;
    }

    public void endSession() {
        sessionAlive = false;
    }

    public Node getCurrentWorkingDirectory() {
        return currentWorkingDirectory;
    }

    public void setCurrentWorkingDirectory(Node directory) {
        currentWorkingDirectory = directory;
    }
}
