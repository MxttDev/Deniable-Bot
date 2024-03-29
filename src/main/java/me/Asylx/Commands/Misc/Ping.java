package me.Asylx.Commands.Misc;

import me.Asylx.Utils.Config;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message msg = e.getMessage();
        MessageChannel channel = e.getChannel();
        if (msg.getContentRaw().equals(Config.PREFIX+"ping")) {
            channel.sendMessage("Pong!").queue();
        }
    }

}
