package utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

/**
 * 验证码生成工具
 * 
 * @author xxp
 * @since 2016年11月28日 下午6:25:41
 * @version
 */
public class ValidcodeImageUtility {
	public static final String ValidcodeImageUtilityLog = null;
	private char charTable[] = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i',
			'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S',
			't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Y', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };
	//画笔样式 
	 /**
     * The plain style constant.
     */
    //public static final int PLAIN       = 0;
    //public static final int BOLD        = 1;
    //public static final int ITALIC      = 2;
	private int[] charType={0,1,2};

	/**
	 * 生成验证码内容
	 * 
	 * @param length
	 *            验证码长度
	 * @return
	 */
	public String createValideCode(int length) {
		StringBuilder sb = new StringBuilder();
		length = length <= 0 ? 4 : length;

		for (int i = 0; i < length; i++) {
			sb.append(charTable[rand.nextInt(charTable.length)]);
		}
		return sb.toString();
	}
	private Random rand = new Random();
	public Object LogX;
	/**
	 * 生成二维码图片
	 * @param width
	 * @param height
	 * @param valideCode
	 * @return
	 */
	public BufferedImage drawPicture(int width, int height, String valideCode) {
		if (width <= 0)
			width = 100;
		if (height <= 0)
			height = 60;
		int length = valideCode.length();
		int xDuring = width / (length + 2);
		int yDuring = (height / 3);
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(new Color(0x5265fd));
		g.drawRect(0, 0, width, height);
		for (int i = 0; i < valideCode.length(); i++) {
			//字体style：Font.PLAIN, Font.BOLD, Font.ITALIC
			g.setFont(new Font("Times New Roman", charType[rand.nextInt(charType.length)], 18));
			g.drawString(valideCode.substring(i, i + 1), xDuring * (i + 1),yDuring+rand.nextInt(2*yDuring));
		}
		for (int i = 0; i < 25; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			g.drawOval(x, y, 1, 2);
		}
		g.dispose();
		return image;
	}
	/**
	 * 将图片转换成BASE64字符串
	 * @param image
	 * @return
	 * @throws IOException
	 */
	public String convertToBase64(BufferedImage image) throws IOException
	{
		
		ByteArrayOutputStream baos=null;
		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG",baos) ;
			return "data:image/JPEG;base64,"+ (new BASE64Encoder()).encode(baos.toByteArray());
		} catch (IOException e) {
			throw e;
		}
		finally{
			if(baos!=null)
			{
				baos.close();
			}
		}
	}

}
