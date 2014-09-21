import java.awt.Graphics;

import com.embah.ScratchEngine.Drawing.Painter;


public class GameRender implements Painter{

	public void paint(Graphics g) {
		g.drawString("Painting from painter - GameRender", 5, 15);
	}
}
