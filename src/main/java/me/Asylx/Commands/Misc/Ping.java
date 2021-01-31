package me.Asylx.Commands.Misc;

import me.Asylx.Utils.Prefix;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message msg = e.getMessage();
        MessageChannel channel = e.getChannel();
        if (msg.getContentRaw().equals(""+""+"ping")) {
            channel.sendMessage("Pong!").queue();
        }
    }

}
