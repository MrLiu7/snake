package source;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author XiaoLiuPA
 */
public class GameStart {
    public static void main(String[] args) {
        new GameStart().init();
    }
    public void init() {
        //游戏主窗口
        JFrame jFrame = new JFrame("贪吃蛇-小柳编程之路");
        //设置窗口大小
        jFrame.setBounds(250, 100, 1425, 800);
        //设置窗口不可改大小
        jFrame.setResizable(true);
        //将游戏画板添加到主界面中
        jFrame.add(new GamePanel());
        //窗口可见
        jFrame.setVisible(true);
        //创建图标
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/resources/jfream/title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置窗口图标
        jFrame.setIconImage(image);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
