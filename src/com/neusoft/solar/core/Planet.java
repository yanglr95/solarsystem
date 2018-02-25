package com.neusoft.solar.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.neusoft.solar.constant.Constant;
import com.neusoft.solar.util.GameUtil;

public class Planet extends Star {
     /**
      * 
      */
	
	int longAxis;     //长轴
	int shortAxis;    //短轴
	double degree;    //角度
	double speed;    //速度
	
	String name;     //名字
	int satelliteCount;    //卫星个数
	int t;              //周期
	double e;          //离心率
	boolean clockWise=true;  //顺时针
    boolean comee=true;  //彗星
	Star center;
	
	
	public Planet(Star center,String imgPath, int longAxis,int satelliteCount,int t,double e,boolean clockWise,boolean comee,String name){
		this.center=center;
		this.x=center.x+longAxis;
		this.y=center.y;
		this.img=GameUtil.getImage(imgPath);
		this.longAxis=longAxis;
		this.e=e;
		this.shortAxis=getMyShortAxis();
		this.t=t;
		this.speed=getMySpeed();
		this.clockWise=clockWise;
		this.comee=comee;
		this.name=name;
	}
	
	
	public void draw(Graphics g) {
		
		Font f = new Font("微软雅黑", Font.BOLD, 20);
		g.setFont(f);
		
		Color c=g.getColor();
		g.setColor(Color.RED);
		g.drawString(name, x, y);
		g.setColor(c);
		g.drawImage(img, x, y,null);
		move();
		drawTrace(g);
		
	}
	
	private void move(){
		if(clockWise){
			x=(int)(center.x+center.img.getWidth(null)/2-img.getWidth(null)/2+longAxis * Math.cos(degree));
			y=(int)(center.y+center.img.getWidth(null)/2-img.getHeight(null)/2+shortAxis * Math.sin(degree));
			degree += speed;
			
			if(comee){
				x=(int)(longAxis*Math.cos(degree)*Math.cos(Math.PI/4)-shortAxis*Math.sin(degree)*Math.sin(Math.PI/4)+center.x+center.img.getWidth(null)/2-img.getWidth(null)/2-100);
				y=(int)(longAxis*Math.cos(degree)*Math.sin(Math.PI/4)+shortAxis*Math.sin(degree)*Math.cos(Math.PI/4)+center.y+center.img.getHeight(null)/2-img.getHeight(null)/2-100);
				degree += 0.05;
			}
		}else{
			//逆时针
		x=(int)(center.x+center.img.getWidth(null)/2-img.getWidth(null)/2+longAxis * Math.sin(degree));
		y=(int)(center.y+center.img.getWidth(null)/2-img.getHeight(null)/2+shortAxis * Math.cos(degree));
		degree += speed;
		}
	}
	
	private int getMyShortAxis(){
		//return (int)((longAxis*Math.sqrt(1-e*e))/2);
		return (int)(longAxis*Math.sqrt(1-e*e));
	}
	
	private double getMySpeed(){
		return 36.5/t;
	}
	
	
	public void drawTrace(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.PINK);
		if(comee){
			//g.drawOval((int)(center.x+center.img.getWidth(null)/2-Math.sqrt((double)(longAxis^2-shortAxis^2))-longAxis),center.y+center.img.getHeight(null)/2-shortAxis,2*longAxis,2*shortAxis);
		}else{
		    g.drawOval(center.x+center.img.getWidth(null)/2-longAxis,center.y+center.img.getHeight(null)/2-shortAxis,2*longAxis,2*shortAxis);
	       }
	}
	
	
	
	
}
 