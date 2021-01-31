package me.Asylx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;

public class privateMessage extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.isFromType(ChannelType.PRIVATE)) {
            PrivateChannel Channel = e.getPrivateChannel();
            EmbedBuilder embed = new EmbedBuilder();

            embed.setTitle("Deniable | System");
            embed.setDescription("Incorrect code.");
            embed.setTimestamp(new Date().toInstant());
            Channel.sendMessage(embed.build()).queue();
        }
    }
}
