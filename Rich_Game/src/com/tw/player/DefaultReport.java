package com.tw.player;

import com.tw.asest.AssistancePower;
import com.tw.map.Estate;
import com.tw.toolHouse.Tool;
import com.tw.toolHouse.ToolType;

import java.util.List;

/**
 * Created by pzzheng on 11/13/16.
 */
public class DefaultReport implements Report {
    private StringBuilder res;

    @Override
    public String reportAsString(int funds, int points, List<Estate> estates, List<Tool> tools) {
        res = new StringBuilder();
        res.append("资金: " + funds + "元\n");
        res.append("点数: " + points + "点\n");
        appendEstateInfo(estates);
        appendToolInfo(tools);
        return res.toString();
    }

    private void appendToolInfo(List<Tool> tools) {
        int bomb = 0;
        int block = 0;
        int robotDull = 0;
        for(AssistancePower tool: tools) {
            if(tool.equals(ToolType.Bomb))    bomb++;
            if(tool.equals(ToolType.Block))   block++;
            if(tool.equals(ToolType.RobotDull)) robotDull++;
        }
        res.append("道具: 路障" + block + "个; 炸弹" + bomb + "个; 机器娃娃" + robotDull + "个\n");
    }

    private void appendEstateInfo(List<Estate> estates) {
        int emptyHouse = 0;
        int thatchHouse = 0;
        int foreignStyleHouse = 0;
        int skyscraper = 0;
        for(Estate estate: estates) {
            if(estate.getLevel().equals(Estate.EstateLevel.EMPTY))  emptyHouse++;
            if(estate.getLevel().equals(Estate.EstateLevel.THATCH))  thatchHouse++;
            if(estate.getLevel().equals(Estate.EstateLevel.FOREIGN_STYLE))  foreignStyleHouse++;
            if(estate.getLevel().equals(Estate.EstateLevel.SKYSCRAPER))  skyscraper++;
        }
        res.append("地产: 空地" + emptyHouse + "处; 茅屋" + thatchHouse + "处; 洋房" + foreignStyleHouse + "处; 摩天楼" + skyscraper + "处\n");
    }
}
