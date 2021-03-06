package com.theprogrammingturkey.turkeybot.commands;

import com.theprogrammingturkey.ggserver.ServerCore;
import com.theprogrammingturkey.ggserver.ServerCore.Level;
import com.theprogrammingturkey.ggserver.commands.CommandManager;
import com.theprogrammingturkey.ggserver.commands.SimpleCommand;
import com.theprogrammingturkey.turkeybot.TurkeyBot;

public class ConsoleCommands
{

	public static void initCommands()
	{
		CommandManager.registerCommand(new SimpleCommand("turkeybot", "Commands related to TurkeyBot")
		{
			public void onCommand(String[] args)
			{
				String command = args[0];
				if(command.equalsIgnoreCase("Join"))
				{
					if(args.length > 1)
					{
						String channelName = args[1].toLowerCase();
						Integer channelID = TurkeyBot.bot.getChannelID(channelName);
						if(channelID != -1)
							TurkeyBot.bot.connectToChannel(channelID);
						else
							ServerCore.output(Level.Error, "TurkeyBot", channelName + " is not a valid channel!");
					}
					else
					{
						ServerCore.output(Level.Alert, "TurkeyBot", "Your number of arguments is incorrect! try /Join (Channel)");
					}
				}
				else if(command.equalsIgnoreCase("leave"))
				{
					if(args.length > 1)
					{
						String channelName = args[1].toLowerCase();
						Integer channelID = TurkeyBot.bot.getChannelID(channelName);
						if(channelID != -1)
							TurkeyBot.bot.disconnectFromChannel(channelID);
						else
							ServerCore.output(Level.Error, "TurkeyBot", channelName + " is not a valid channel!");
					}
				}
				else if(command.equalsIgnoreCase("add"))
				{
					if(args.length > 1)
					{
						String channelName = args[1].toLowerCase();
						Integer channelID = TurkeyBot.bot.getChannelID(channelName);
						if(channelID != -1)
						{
							TurkeyBot.bot.addWatchedChannel(channelID, true);
							ServerCore.output(Level.Info, "TurkeyBot", "Added " + args[1].toLowerCase() + " to the watched channels");
						}
						else
						{
							ServerCore.output(Level.Error, "TurkeyBot", channelName + " is not a valid channel!");
						}
					}
					else
					{
						ServerCore.output(Level.Alert, "TurkeyBot", "Your number of arguments is incorrect! try /Join (Channel)");
					}
				}
				else if(command.equalsIgnoreCase("remove"))
				{
					if(args.length > 1)
					{
						String channelName = args[1].toLowerCase();
						Integer channelID = TurkeyBot.bot.getChannelID(channelName);
						if(channelID != -1)
						{
							TurkeyBot.bot.removeWatchedChannel(channelID, true);
							ServerCore.output(Level.Info, "TurkeyBot", "Removed " + args[1].toLowerCase() + " to the watched channels");
						}
						else
						{
							ServerCore.output(Level.Error, "TurkeyBot", channelName + " is not a valid channel!");
						}
					}
				}
				else if(command.equalsIgnoreCase("reconnect"))
				{
					TurkeyBot.bot.reconnectBot();
				}
				else if(command.equalsIgnoreCase("say"))
				{
					if(args.length > 2)
					{
						String channel = args[1].contains("#") ? args[1] : "#" + args[1];
						Integer channelID = TurkeyBot.bot.getChannelID(channel.toLowerCase());
						TurkeyBot.bot.isConnectedToChannel(channelID);
						StringBuilder builder = new StringBuilder();
						for(int i = 2; i < args.length; i++)
						{
							builder.append(args[i]);
							builder.append(" ");
						}
						String out = "[" + channel + "] Turkey2349: " + builder.toString();
						ServerCore.output(Level.Info, "TurkeyBot", out);
						TurkeyBot.bot.sendMessage(channel.toLowerCase(), builder.toString());
					}
				}
				else
				{
					ServerCore.output(Level.Alert, "TurkeyBot", "That is not a valid Command");
				}
			}

			@Override
			public String getUsage()
			{
				return "Valid Commands: \njoin <channel> \nleave <channel> \nadd <channel> \nremove <channel> \nreconnect \nsay \n";
			}

		});
	}
}
