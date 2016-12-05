package com.aquabarnes.spiritedaway.commands;

import java.util.Arrays;

import java.util.List;
import java.util.Random;

import com.aquabarnes.spiritedaway.enums.EnumColor;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.util.text.TextComponentString;

public class CommandHelp extends CommandBase
{

public String getCommandName() {

	return "sa";
}

public String getCommandUsage(ICommandSender sender) {

	return "/sa <subcommand> <arguments>";
}

public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

	
}
}
