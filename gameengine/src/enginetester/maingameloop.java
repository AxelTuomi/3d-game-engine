package enginetester;

import renderengine.displaymanager;
import renderengine.loader;
import renderengine.rawmodel;
import renderengine.renderer;

import org.lwjgl.opengl.Display;

public class maingameloop {
	
	public static void main(String[] args) {
		System.out.println("main");
		gui gui = new gui();
	}
	public static void gameloop(String resolution, Double mousesensetivity) {
		System.out.println(mousesensetivity);
		displaymanager.createdisplay(resolution);
		
		loader loader = new loader();
		renderer renderer = new renderer();
			
		float[] vertices = {
				-0.5f, 0.5f, 0, //v0
				-0.5f, -0.5f, 0, //v1
				0.5f, -0.5f, 0, //v2
				0.5f, 0.5f, 0f, //v3
		};
			
		int[] indices = {
				0, 1, 3, //top left triangle (v0, v1, v3)
				3, 1, 2 //bottom right triangle (v3, v1, v2)
		};
			
		rawmodel model = loader.loadtovao(vertices, indices);
			
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			//game logic
			//render
			renderer.render(model);
			displaymanager.updatedisplay();
		}
			
		loader.cleanup();
		displaymanager.closeDisplay();
	}

}
