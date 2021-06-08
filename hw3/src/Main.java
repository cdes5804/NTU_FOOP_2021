/**
 * The File System Commandline will be started from the Main class.
 */

import Commands.*;
import FileSystem.FileSystem;
import CLI.CLI;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Commands.Cat());
        commands.add(new Commands.ChangeDirectory());
        commands.add(new Commands.Exit());
        commands.add(new Commands.Listing());
        commands.add(new Commands.MakeDirectory());
        commands.add(new Commands.Remove());
        commands.add(new Commands.Search());
        commands.add(new Commands.SoftLink());
        commands.add(new Commands.Touch());

        FileSystem fileSystem = new FileSystem();
        CLI cli = new CLI(commands, fileSystem);
        cli.start();
    }
}
