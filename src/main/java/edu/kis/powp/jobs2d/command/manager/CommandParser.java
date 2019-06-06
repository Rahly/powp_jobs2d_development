package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private List<DriverCommand> commands = new ArrayList<DriverCommand>();

    public void parseCommand(String inputCommand){
        String args[] = inputCommand.split(" ");
        if(args[0].contains("set-position")){
            commands.add(new SetPositionCommand(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
        }
        else if(args[0].contains("operate-to")){
            commands.add(new OperateToCommand(Integer.parseInt(args[1]),Integer.parseInt(args[2])));
        }

        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, "Parser Command");
    }

    public List getCommandsList(){
        return commands;
    }

    public void clearCommands(){
        commands.clear();
    }
}
