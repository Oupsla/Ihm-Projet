package fr.univ.lille1.ihm.menu;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

import fr.univ.lille1.ihm.main.Main;


public abstract class MenuListener extends MouseInputAdapter{
	MenuPopup canvas = new MenuPopup(300,300);


	Point current,dragged;
	public void mousePressed(MouseEvent e){

		//Main.mainFrame.getContentPane().add(canvas);
		//Main.mainFrame.getContentPane().setComponentZOrder(canvas, 1);
		current=e.getLocationOnScreen();
		dragged=current;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		canvas.getMap().get("node2").showPie(new Point(e.getX(),e.getY()));
		//Main.mainFrame.repaint();
	}

	public void mouseReleased(MouseEvent e){
		canvas.getMap().get("node2").hidePie();
		if(current.getY()+30<dragged.getY()){
			if(current.getX()+30<dragged.getX()){
				share();
			}else if(current.getX()-30>dragged.getX()){
				edit();
			}
		}else if(current.getY()-30>dragged.getY()){
			if(current.getX()+30<dragged.getX()){
				delete();
			}else if(current.getX()-30>dragged.getX()){
				back();
			}

		}

	}

	public void mouseDragged(MouseEvent e){
		dragged=e.getLocationOnScreen();
	}

	public abstract void share();
	public abstract void edit();
	public abstract void delete();
	public abstract void back();

	public static void main(String args[]){
		MenuListener m = new MenuListener(){

			@Override
			public void share() {
				// TODO Auto-generated method stub

			}

			@Override
			public void edit() {
				// TODO Auto-generated method stub

			}

			@Override
			public void delete() {
				// TODO Auto-generated method stub

			}

			@Override
			public void back() {
				// TODO Auto-generated method stub

			};

		};
		JFrame frame = new JFrame();
		frame.addMouseListener(m);
		frame.addMouseMotionListener(m);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
