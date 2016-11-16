package com.tw.core.places;

import com.tw.core.Player;
import com.tw.core.commands.CommandFactory;
import com.tw.core.tools.Tool;

/**
 * Created by pzzheng on 11/16/16.
 */
public class ToolHouse extends House {


    public ToolHouse(Tool... items) {
        super(items);
    }



    @Override
    public Player.Status comeHere(Player player) {
        player.moveTo(this);
        if(canNotAffordAnyToolWith(player.getAsests().getPoints())) {
            return Player.Status.WAIT_FOR_TURN;
        }
        player.setLastCommand(CommandFactory.BuyTool);
        return Player.Status.WAIT_FOR_RESPONSE;
    }

    public boolean canNotAffordAnyToolWith(int points) {
        return items.stream().min((a, b) -> a.getValue() - b.getValue()).get().getValue() > points;
    }
}
