package club.fsCommunity.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class ValidateCodeUtils {

	static Random ran = new Random();

	public static String genNewCode(OutputStream out) throws IOException, FileNotFoundException {
		int width = 120;
		int height = 40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
		
		String number = "";
		for (int i = 0; i < 4; i++) {
			number += ran.nextInt(10);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("黑体", Font.ITALIC, 35));
		g.drawString(number, 20, 40);
		
		for (int i = 0; i < 30; i++) {
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			g.setColor(getRandomColr());
			g.drawLine(x1, y1, x2, y2);
		}
		
		ImageIO.write(image, "png", out);
		return number;
	}
	
	private static Color getRandomColr() {
		int r = ran.nextInt(256);
		int g = ran.nextInt(256);
		int b = ran.nextInt(256);
		
		return new Color(r, g, b);
	}
	
	
	
}
