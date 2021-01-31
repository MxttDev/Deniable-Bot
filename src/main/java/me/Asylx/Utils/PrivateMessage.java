package me.Asylx.Utils;

import net.dv8tion.jda.api.entities.User;

public class PrivateMessage {

    public static void sendPrivateMessage(User user, String content) {
        // openPrivateChannel provides a RestAction<PrivateChannel>
        // which means it supplies you with the resulting channel
        user.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(content).queue();
        });
    }

}
