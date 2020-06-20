package com.github.evanluo42.commands;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CommandBiFollower implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bi")) {
            if(args[0].equals("follower")){
                if(args.length==2){
                    String UUID=args[1];
                    try {
                        Document doc = Jsoup.connect("https://api.bilibili.com/x/relation/stat?vmid="+UUID+"&jsonp=jsonp").get();
                        JSONObject obj = JSON.parseObject(String.valueOf(doc));
                        if(obj.getString("message").equals("0")){
                            JSONArray features = obj.getJSONArray("data");
                            sender.sendMessage("Up主的关注数:"+features.getJSONObject(5).getString("follower"));
                        }else{
                            sender.sendMessage("没有这个up哦");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else{
                    sender.sendMessage("/bi follower <uid>");
                }
            }
            return true;
        }
        return false;
    }
}
