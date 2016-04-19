package fr.univ.lille1.ihm.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SlideGaucheListener extends MouseAdapter {

	private Boolean isPressed = false;
	private MouseEvent start = null;

	private static String methodNameGauche = "";
	private Method method;
	private Component component;
	private int pixelSlide;

	public SlideGaucheListener(Component component, String methodNameGauche, int pixelSlide) {
		this.methodNameGauche = methodNameGauche;
		this.component = component;
		this.pixelSlide = pixelSlide;
		try {
			this.method = component.getClass().getMethod(methodNameGauche);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		isPressed = true;
		start = e;
		super.mousePressed(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isPressed && start != null) {
			if (start.getX() - e.getX() >= pixelSlide) {
				try {
					method.invoke(component);
				} catch (IllegalAccessException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				} catch (IllegalArgumentException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				} catch (InvocationTargetException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
			}
		}
		super.mouseDragged(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;
		super.mouseReleased(e);
	}

}
