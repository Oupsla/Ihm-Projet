package fr.univ.lille1.ihm.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TimerTask;

public class TimerLongClickListener extends MouseAdapter {

	private static String methodName = "";
	private Method method;
	private Component component;

	private java.util.Timer t;

	public TimerLongClickListener(Component component, String methodName) {
		this.methodName = methodName;
		this.component = component;
		try {
			this.method = component.getClass().getMethod(methodName);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mousePressed(MouseEvent e) {
		if (t == null) {
			t = new java.util.Timer();
		}
		t.schedule(new TimerTask() {
			public void run() {
				try {
					method.invoke(component);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 700, 5000);
	}

	public void mouseReleased(MouseEvent e) {
		if (t != null) {
			t.cancel();
			t = null;
		}
	}
}
