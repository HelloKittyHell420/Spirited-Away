package com.aquabarnes.spiritedaway.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandCamera extends CommandBase
{
	
@Override
public String getCommandName() {

	return "camera";
}

public int getRequiredPermissionLevel()
{
    return 3;
}

@Override
public String getCommandUsage(ICommandSender sender) {

	return "/camera";
}

@Override
public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
	
	
}

}