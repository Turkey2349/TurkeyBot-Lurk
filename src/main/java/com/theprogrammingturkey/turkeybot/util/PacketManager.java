package com.theprogrammingturkey.turkeybot.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.theprogrammingturkey.ggserver.events.PacketRecievedEvent;

public class PacketManager extends PacketRecievedEvent
{
	public PacketManager()
	{
		super("turkeybot");
	}

	@Override
	public void onPacketRecievedEvent(JsonElement element)
	{
		JsonObject jsonMessage = element.getAsJsonObject();

		if(jsonMessage.get("action").getAsString().equals("status"))
		{
//			String uuid = Util.getUniqueMessageId();
//			JsonObject toSend = new JsonObject();
//			toSend.addProperty("to", ServerCore.);
//			toSend.addProperty("message_id", uuid);
//			toSend.addProperty("purpose", "response");
//			toSend.addProperty("orig_msg_id", jsonMessage.get("message_id").getAsString());
//			JsonObject data = new JsonObject();
//			data.addProperty("version", TurkeyBot.VERSION);
//			toSend.add("data", data);
//			ServerCore.sendFCMMessage(uuid, toSend.toString());
		}
	}
}
