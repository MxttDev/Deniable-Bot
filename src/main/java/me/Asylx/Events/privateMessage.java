package me.Asylx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;

public class privateMessage extends ListenerAdapter {

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
        if (e.getAuthor().isBot()) return;

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("Deniable | System");
        embed.setDescription("Incorrect code!");
        embed.setTimestamp(new Date().toInstant());
        e.getChannel().sendMessage(embed.build()).queue();
    }
}
