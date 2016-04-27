package fr.univ.lille1.ihm.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Hashtable;

import javax.swing.JFrame;

import fr.lri.swingstates.canvas.CEllipse;
import fr.lri.swingstates.canvas.CHierarchyTag;
import fr.lri.swingstates.canvas.CNamedTag;
import fr.lri.swingstates.canvas.CPolyLine;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.CText;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.sm.StateMachine;

public class MenuPopup extends Canvas {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*** Members ***/	
	private static final Color  menu_bkgnd_color       = new Color(251,249,201);	
	private static final Color  menu_highlight_color   = new Color(165,246,154);
	private static final Color  menu_border_color      = new Color(130,195,240);
	private static final Font   menu_font              = new Font("verdana", Font.PLAIN, 12);	
	private static final int    menu_item_width        = 50;
	private static final double menu_hysteresis_radius = 5;	

	/* les tags permettent de gerer les interactions avec les differents 	
	 * elements d'un menu */	
	private CTag tag_menu_item;	
	private CNamedTag tag_menu_popup;	
	private CTag tag_menu_node;	
	private CNamedTag tag_pie_menu;	
	private CNamedTag tag_pie_node;	
	private CTag mnu_pie_tag;		

	private StateMachine firstMachine, secondMachine, thirdMachine, fourthMachine, fifthMachine;	

	private PieMenu mnu_pie;	

	/* cette table de hachage contient les menus deroulants de la barre 	
	 * de menus, indexes selon leur entete */	
	private Hashtable<String,PieMenu>pie_hash;	




	/*** Constructor ***/	
	public MenuPopup(int w, int h) {	
		super(w,h);	

		pie_hash = new Hashtable<String,PieMenu>();	

		/* ce tag indique un element de menu - le rectangle de fond */	
		tag_menu_item = new CNamedTag("menu_item");	
		tag_menu_node = new CNamedTag("menu_node");	
		tag_pie_menu = new CNamedTag("pie-menu");	
		tag_pie_node = new CNamedTag("pie_node");	


		PieMenu piePopup;	
		String[] mnuPieNode2 = {	
				"Partager",	
				"Editer",	
				"Archiver",	
				"Retour"		
		};	
		piePopup = new PieMenu("node2",mnuPieNode2);	
		pie_hash.put("node2",piePopup);	
		piePopup.getPieTag().addTag(tag_menu_popup);	

	}	


	public class PieMenu extends CShape {	

		private String header;	
		private String[] menuItems;	
		private CHierarchyTag menu_tag;	

		private CShape[] pie_portions;	
		private CText[] pie_texts;	

		private static final int pie_radius = 60;			
		private static final int ring_length = 40;	


		
		public PieMenu(String name, String[] items) {	

			super(new Ellipse2D.Double(800,800,pie_radius,pie_radius));	
			setFillPaint(new Color(255,255,255)).setOutlinePaint(menu_border_color);	

			header = name;	
			menuItems = items;	

			addShape(this);	

			int num_items = menuItems.length;	
			if (num_items>8) throw new IllegalArgumentException("il faut au plus 8 elements pour former un pie-menu");	

			double hole_radius = pie_radius - ring_length;	
			CEllipse e = new CEllipse(this.getCenterX()-hole_radius/2, this.getCenterY()-hole_radius/2,hole_radius,hole_radius);	
			e.setFillPaint(Color.white).setOutlinePaint(menu_border_color);	
			e.setParent(this);	

			pie_portions = builditems(num_items);//
			//	pie_portions = num_items<5 ? build4items() : build8items();	
			pie_texts = buildtexts(num_items);;//num_items<5 ? build4Texts() : build8Texts();	

			CShape item;	
			CText itemText;	
			boolean isNode;	
			for(int i=0; i<num_items; i++) {	
				item = pie_portions[i];	
				itemText = pie_texts[i];	

				isNode = false;	
				String itemString = menuItems[i];	
				if (itemString.startsWith(">")) {	
					itemString = itemString.substring(1);	
					isNode = true;	
				}	

				itemText.setText(itemString);	

				addShape(item);	
				addShape(itemText);	

				item.addChild(itemText);				
				e.above(item);	
				item.addTag(isNode ? tag_pie_node : tag_menu_item);	
				this.addChild(item);	
			}	

			menu_tag = new CHierarchyTag(this);	
			menu_tag.addTag(tag_pie_menu);	

			hidePie();	
		}	

		public void showPie(Point2D p) {	
			translateTo(p.getX(), p.getY());	
			menu_tag.setDrawable(true);	
			menu_tag.and(tag_menu_item.or(tag_pie_node)).setDrawable(false);	
			menu_tag.and(tag_menu_item.or(tag_pie_node)).setPickable(true);	
		}	
		public void enablePie(Point2D p) {	
			translateTo(p.getX(), p.getY());	
			//			menu_tag.setDrawable(true);	
			//		menu_tag.and(tag_menu_item.or(tag_pie_node)).setDrawable(false);	
			menu_tag.and(tag_menu_item.or(tag_pie_node)).setPickable(true);	
		}

		public void hidePie() {	
			menu_tag.setDrawable(false);	
			menu_tag.and(tag_menu_item).setPickable(false);
			translateTo(800, 800);
		}	

		private CShape[] builditems(int n) {	
			CPolyLine p;
			double pad = pie_radius-ring_length;	

			CShape[] items = new CShape[n];
			for(int i=0;i<n;i++){
				double c1 = Math.cos(Math.PI*2*(i)/n);
				double s1 = Math.sin(Math.PI*2*(i)/n);
				double c2 = Math.cos(Math.PI*2*(i+1)/n);
				double s2 = Math.sin(Math.PI*2*(i+1)/n);
				p = new CPolyLine(getCenterX(),getCenterY());	
				p.lineTo(getCenterX()+ pie_radius*c1, getCenterY()+ pie_radius*s1);	
				p.lineTo(getCenterX()+ pie_radius*c2, getCenterY()+ pie_radius*s2);	

				p.close().setOutlinePaint(menu_border_color).setFillPaint(menu_highlight_color);	
				p.setClip(this);	
				items[i] = p;	
			}	

			return items;	
		}	

		private CText[] buildtexts(int n) {
			float text_dist_fact=(float) 0.75;
			CText x;	
			CText[] t = new CText[n];	
			for(int i=0; i<n; i++){
				double c = Math.cos(Math.PI*2*(i+0.5)/n);
				double s = Math.sin(Math.PI*2*(i+0.5)/n);

				x = new CText(new Point2D.Double(0,0),"",menu_font);	
				x.setOutlined(false).setPickable(false);
				x.setReferencePoint(0,0);
				x.setText(menuItems[i]);	
				x.translateTo(getCenterX()+text_dist_fact*pie_radius*c-x.getWidth()/2,getCenterY()+text_dist_fact*pie_radius*s-x.getHeight()/2);	
				t[i] = x;	
			}
			return t;

		}

		public String getPieHeader() { return header; }	

		public String[] getPieItems() { return menuItems; }	

		public CTag getPieTag() { return menu_tag; }	

		public String getPieItemText(CShape s) {	
			java.util.LinkedList<CShape> child = s.getChildren();	
			return ((CText)child.get(0)).getText();	
		}	
	}	

	public static double getMinWidth(String[] items) {	
		int text_padx = 5;	

		double val = menu_item_width;	
		double stringWidth;	
		java.awt.font.FontRenderContext frc = new java.awt.font.FontRenderContext(null, true,false);	
		for (int i=0; i<items.length; i++) {	
			stringWidth = menu_font.getStringBounds(items[i],frc).getWidth() + 2*text_padx;	
			if (stringWidth > val) val = stringWidth;	
		}	
		return val;	
	}	

	public Hashtable<String,PieMenu> getMap(){
		return pie_hash;
	}
}
