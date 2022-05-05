package source;

import javax.swing.*;
import java.net.URL;

/**
 * @author XiaoLiuPA
 */
public class Date {
    /**
     * 背景图片
     * URL:定位图片地址
     * ImageIcon：图片
     */
    private static final URL backgroundPictureURL = Date.class.getResource("/resources/jfream/background.png");
    public static final ImageIcon backgroundPicture;

    static {
        assert backgroundPictureURL != null;
        backgroundPicture = new ImageIcon(backgroundPictureURL);
    }

    /**
     * 食物图片
     */

    private static final URL foodPictureURL = Date.class.getResource("/resources/game/food.png");
    public static final ImageIcon foodPicture;

    static {
        assert foodPictureURL != null;
        foodPicture = new ImageIcon(foodPictureURL);
    }

    /**
     * 身体
     */
    private static final URL bodyPictureURL = Date.class.getResource("/resources/game/body.png");
    public static final ImageIcon bodyPicture;

    static {
        assert bodyPictureURL != null;
        bodyPicture = new ImageIcon(bodyPictureURL);
    }

    /**
     * 头： 左 上 右 下
     */
    private static final URL headUPPictureURL = Date.class.getResource("/resources/game/headUP.png");
    public static final ImageIcon headUPPicture;

    static {
        assert headUPPictureURL != null;
        headUPPicture = new ImageIcon(headUPPictureURL);
    }

    private static final URL headLeftPictureURL = Date.class.getResource("/resources/game/headLeft.png");
    public static final ImageIcon headLeftPicture;

    static {
        assert headLeftPictureURL != null;
        headLeftPicture = new ImageIcon(headLeftPictureURL);
    }

    private static final URL headRightPictureURL = Date.class.getResource("/resources/game/headRight.png");
    public static final ImageIcon headRightPicture;

    static {
        assert headRightPictureURL != null;
        headRightPicture = new ImageIcon(headRightPictureURL);
    }

    private static final URL headDownPictureURL = Date.class.getResource("/resources/game/headDown.png");
    public static final ImageIcon headDownPicture;

    static {
        assert headDownPictureURL != null;
        headDownPicture = new ImageIcon(headDownPictureURL);
    }

    /**
     * 登录界面
     */
    private static final URL loginPictureURL = Date.class.getResource("/resources/login/login.png");
    public static final ImageIcon loginPicture;
    static {
        assert loginPictureURL!=null;
        loginPicture = new ImageIcon(loginPictureURL);
    }

    /**
     * 主界面
     */
    private static final URL mainPictureURL = Date.class.getResource("/resources/login/main.png");
    public static final ImageIcon mainPicture;
    static {
        assert mainPictureURL !=null;
        mainPicture = new ImageIcon(mainPictureURL);
    }
}
