package me.Asylx.Commands.Misc;

import me.Asylx.Utils.JsonFromURL;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class Status extends ListenerAdapter {

    Boolean online;
    String mode;
    int onlineamount;

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message msg = e.getMessage();
        MessageChannel channel = e.getChannel();
        if (msg.getContentRaw().equals(""+"Status")) {
            try {
                JSONObject json = JsonFromURL.readJsonFromUrl("https://api.mcsrvstat.us/2/play.deniable.net");

                if (json.get("online").equals(true)) {
                    mode = "ONLINE";
                    onlineamount = json.getJSONObject("players").getInt("online");
                } else {
                    mode = "FALSE";
                }
                EmbedBuilder embed = new EmbedBuilder();

                embed.setTitle("Status | Deniable");
                embed.setDescription("Here is the current status for ``play.deniable.net``.");
                embed.addField("Status", mode, true);
                embed.addField("Players", ""+onlineamount, true);
                embed.setTimestamp(new Date().toInstant());
                channel.sendMessage(embed.build()).queue();


            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
