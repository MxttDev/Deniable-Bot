package me.Asylx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;

public class guildMessageReaction extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        Role role = e.getGuild().getRoleById("796758172412805180");
        if (e.getReaction().getChannel().getId().equals("805028571373371392")) {
            e.getGuild().addRoleToMember(e.getMember(), role).queue();
            e.getMember().getUser().openPrivateChannel().queue(channel -> {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle("Account verified");
                embed.setDescription("You have been verified on **Deniable** \n \n You now have access to all of the channels. ");
                embed.setTimestamp(new Date().toInstant());
                channel.sendMessage(embed.build()).queue();
            });
        }


    }
}
