package com.tw.commands;

import com.tw.player.Player;

/**
 * Created by pzzheng on 11/15/16.
 */
public interface Responsive {
    Player.Status respond(Player player, Response response);
}
