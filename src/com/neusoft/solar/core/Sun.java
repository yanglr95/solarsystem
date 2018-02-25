package com.neusoft.solar.core;

import java.awt.Graphics;

import com.neusoft.solar.constant.Constant;
import com.neusoft.solar.util.GameUtil;

public class Sun extends Star {
    
	public Sun(){
		this.img=GameUtil.getImage("com/neusoft/solar/img/sun.png");
		this.x=Constant.GAME_WIDTH/2-img.getWidth(null)/2;
		this.y=Constant.GAME_HEIGHT/2-img.getHeight(null)/2;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
         g.drawImage(img,x,y,null);
	}

}


