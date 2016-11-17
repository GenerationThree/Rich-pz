package com.tw.core.commands;

import com.tw.core.Player;
import com.tw.core.responses.Response;
import com.tw.core.tools.Tool;

/**
 * Created by pzzheng on 11/17/16.
 */
public class UseBomb implements Command {
    private int steps;

    public UseBomb(int steps) {
        this.steps = steps;
    }

    @Override
    public Player.Status execute(Player player) {
        if(player.getAsests().hasTool(Tool.BOMB) && player.getGame().getMap().putBomb(Tool.BOMB)){
            player.getAsests().useTool(Tool.BOMB);
        }
        return player.waitForCommand();

    }

    @Override
    public Player.Status respond(Response response, Player player) {
        return null;
    }
}