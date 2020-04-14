package renderengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class displaymanager {
	
	private static final int width = 1920;
	private static final int height = 1080;
	private static final int FPS_CAP = 120;

	public static void createdisplay() {
		ContextAttribs attribs = new ContextAttribs(3,2);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("gameengine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, width, height);
	}
	public static void updatedisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}
	public static void closeDisplay() {
		Display.destroy();
	}
	
}
