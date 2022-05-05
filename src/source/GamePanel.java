package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author XiaoLiuPA
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    /**
     * 蛇的长度
     */
    int length;
    int[] snakeX = new int[1664];
    int[] snakeY = new int[1664];
    /**
     * 默认的蛇的方向
     * R：右  L：左  U：上 D:下
     */
    String fx;

    /**
     * 游戏开始标记
     */
    boolean isStart;

    /**
     * 定时器
     */
    Timer timer = new Timer(100, this);

    //定义一个食物
    int foodX;
    int foodY;
    Random random = new Random();

    //游戏失败标志
    boolean ifFail;

    //积分系统
    int score;

    public GamePanel() {
        init();

        //获取键盘监听事件
        this.setFocusable(true);
        this.addKeyListener(this);

        //启动计时器
        timer.start();
    }

    public void init() {
        //蛇长度
        length = 3;
        //头
        snakeX[0] = 29 * 25;
        snakeY[0] = 16 * 25;
        //蛇第二节
        snakeX[1] = 28 * 25;
        snakeY[1] = 16 * 25;
        //蛇第三节
        snakeX[2] = 27 * 25;
        snakeY[2] = 16 * 25;
        //方向
        fx = "R";
        isStart = false;
        //食物初始化
        foodX = 25 + 25 * random.nextInt(56);
        foodY = 25 + 25 * random.nextInt(30);

        //游戏失败标记
        ifFail = false;
        //成绩初始化
        score = (length - 3) * 5;
    }

    /**
     * 画板 画界面 画蛇
     * Graphics ：画笔
     */
    @Override
    protected void paintComponent(Graphics g) {
        //清屏
        super.paintComponent(g);
        /**
         * 绘制背景
         * 参数：窗口，画笔，开始绘画位置
         */
        Date.backgroundPicture.paintIcon(this, g, 0, 0);

        //绘制游戏区域
        //g.fillRect(0,0,1200,800);
        //绘制小蛇
        if (fx.equals("R")) {
            Date.headRightPicture.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Date.headLeftPicture.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Date.headUPPicture.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else {
            Date.headDownPicture.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i = 1; i < length; i++) {
            Date.bodyPicture.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        //绘制食物
        Date.foodPicture.paintIcon(this, g, foodX, foodY);

        //游戏提示
        if (!isStart) {
            //画一个文字
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("华文行楷", Font.BOLD, 40));
            g.drawString("游戏暂停，继续游戏请按空格键！", 300, 300);
        }

        //游戏失败
        if (ifFail) {
            //画一个文字
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("华文行楷", Font.BOLD, 40));
            g.drawString("游戏失败，重玩游戏请按空格键！", 300, 300);
        }

        //画成绩
        g.setColor(Color.RED);
        g.setFont(new Font("华文行楷", Font.BOLD, 22));
        g.drawString("长度 " + length + " 节", 1300, 30);
        g.drawString("分数 " + score + " 分", 1300, 60);
    }


    /**
     * 键盘监听
     * 实现 KeyListener 接口
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {//键盘按下，未释放
        //获取按键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {//空格按键
            if (ifFail) {
                init();
            } else {
                isStart = !isStart;
                repaint();//刷新界面
            }
        } else if (keyCode == KeyEvent.VK_LEFT && !("R".equals(fx))) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT && !("L".equals(fx))) {
            fx = "R";
        } else if (keyCode == KeyEvent.VK_UP && !("D".equals(fx))) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN && !("U".equals(fx))) {
            fx = "D";
        }
    }

    //定时器 监听时间 帧
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && !ifFail) {
            //右移动
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            //头部移动
            if ("R".equals(fx)) {
                snakeX[0] += 25;
                if (snakeX[0] > 1430) {
                    snakeX[0] = 0;
                }
            } else if ("L".equals(fx)) {
                snakeX[0] -= 25;
                if (snakeX[0] < 0) {
                    snakeX[0] = 1430;
                }
            } else if ("U".equals(fx)) {
                snakeY[0] -= 25;
                if (snakeY[0] < 0) {
                    snakeY[0] = 800;
                }
            } else if ("D".equals(fx)) {
                snakeY[0] += 25;
                if (snakeY[0] > 800) {
                    snakeY[0] = 0;
                }
            }
            //小蛇吃到食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;
                //食物更新
                foodX = 25 + 25 * random.nextInt(56);
                foodY = 25 + 25 * random.nextInt(30);

                //刷新分数
                score += 5;
            }

            //如果死亡
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    ifFail = true;
                    break;
                }
            }
            //刷新界面
            repaint();
        }
        //启动计时器
        timer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //键盘释放
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下，弹起：敲击
    }
}
