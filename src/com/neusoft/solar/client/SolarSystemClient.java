package com.neusoft.solar.client;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.solar.constant.Constant;
import com.neusoft.solar.core.Planet;
import com.neusoft.solar.core.Sun;
import com.neusoft.solar.util.GameUtil;
import com.neusoft.solar.util.MyFrame;

public class SolarSystemClient extends MyFrame {
	
	Image bj=GameUtil.getImage("com/neusoft/solar/img/bj.jpg");
	
    Sun sun = new Sun();

    
    Planet earth=new Planet(sun,"com/neusoft/solar/img/diqiu.png",179,0,765,0.0167,true,false,"µØÇò");
   Planet water=new Planet(sun,"com/neusoft/solar/img/shui.png",579,0,888,0.0556,true,false,"Ë®ÐÇ");
    Planet wood=new Planet(sun,"com/neusoft/solar/img/mu.png",458,0,622,0.0289,false,false,"Ä¾ÐÇ");
    Planet jin=new Planet(sun,"com/neusoft/solar/img/jin.png",108,0,700,0.006,true,false,"½ðÐÇ");
    Planet huo=new Planet(sun,"com/neusoft/solar/img/huo.png",307,0,687,0.0933,true,false,"»ðÐÇ");
    Planet haiwang=new Planet(sun,"com/neusoft/solar/img/haiwang.png",4498,0,3645,0.0127,true,false,"º£Íõ");
    Planet tu=new Planet(sun,"com/neusoft/solar/img/tu.png",259,0,600,0.0539,true,false,"ÍÁÐÇ");
    Planet tianwang=new Planet(sun,"com/neusoft/solar/img/tianwang.png",387,0,854,0.04315,true,false,"ÌìÍõÐÇ");
    
    Planet moon=new Planet(earth,"com/neusoft/solar/img/moon.png",100,0,605,0.0167,true,false,"ÔÂÇò");
    Planet hui=new Planet(sun,"com/neusoft/solar/img/hui.png",526,0,5*365,0.9,true,true,"åçÐÇ");
    
    
    public void paint(Graphics g){
    	
    	g.drawImage(bj, 0, 0,null);
    	//»­ÐÇÌå
    	sun.draw(g);
    	Font f = new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30);
		g.setFont(f);
    	g.drawString("Ì«Ñô", Constant.GAME_WIDTH/2-30, Constant.GAME_HEIGHT/2+10);
    	
		
    	earth.draw(g);
    	water.draw(g);
    	wood.draw(g);
    	jin.draw(g);
    	haiwang.draw(g);
    	huo.draw(g);
    	tu.draw(g);
    	tianwang.draw(g);
    	moon.draw(g);
    	hui.draw(g);
    	
    }
    
    public static void main(String[] args){
    	new SolarSystemClient().launchFrame();
    }
    
    
    
    
    
    
}
