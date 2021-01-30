package me.Asylx.Events;

import me.Asylx.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Date;

public class guildMemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        TextChannel channel = e.getGuild().getTextChannelsByName("welcome", true).get(0);
        TextChannel rules = e.getGuild().getTextChannelsByName("rules", true).get(0);
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("New member");
        embed.setThumbnail(e.getMember().getUser().getAvatarUrl());
        embed.setDescription("Welcome, "+e.getMember().getUser().getName()+" to **Deniable Network**! \n \n Please read the rules in "+rules.getAsMention()+" \n \n **IP** » play.deniable.net \n **Store »** [https://store.deniable.net/](https://store.deniable.net/) \n **Applications »** [https://applications.deniable.net/](https://applications.deniable.net/) \n **Rules »** [https://rules.deniable.net/](https://rules.deniable.net/) \n **Discord »** [https://discord.deniable.net/](https://discord.deniable.net/)");
        embed.setTimestamp(new Date().toInstant());
        channel.sendMessage(embed.build()).queue();
    }
}
