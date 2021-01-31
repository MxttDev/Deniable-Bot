package me.Asylx;

import me.Asylx.Commands.Misc.Ping;
import me.Asylx.Commands.Misc.Status;
import me.Asylx.Events.guildMemberJoin;
import me.Asylx.Events.guildMessageReaction;
import me.Asylx.Utils.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {

    private static JDA bot;

    public static void main(String[] args) throws LoginException, IOException {
        bot = JDABuilder.createDefault(Config.TOKEN)
                .setActivity(Activity.playing("play.deniable.net"))
                .addEventListeners(new Ping())
                .addEventListeners(new guildMemberJoin())
                .addEventListeners(new guildMessageReaction())
                .addEventListeners(new Status())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS)
                .build();

    }

}
