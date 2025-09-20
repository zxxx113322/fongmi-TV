// App.java
import android.app.Application;
import java.net.IDN;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 你的初始化逻辑...
        initDefaultConfigs();
    }

    private void initDefaultConfigs() {
        try {
            // 点播 (type = 0)
            if (Config.vod().isEmpty()) {
                Config.vod()
                        .url("http://www.zuoxuxuan.fun:5678/tvbox/my_ext.json")
                        .name("默认点播")
                        .update();
            }

            // 直播 (type = 1)
            if (Config.live().isEmpty()) {
                Config.live()
                        .url("https://degeone.gh-proxy.com/https://raw.githubusercontent.com/zxxx113322/iptv-Jiangxi/refs/heads/main/demo.m3u")
                        .name("默认直播")
                        .update();
            }

            // 壁纸 (type = 2)
            if (Config.wall().isEmpty()) {
                // 把中文域名转成 punycode
                String host = "深色壁纸"; // 中文子域名
                String asciiHost = IDN.toASCII(host); // 转换为 xn--xxxx
                String wallpaperUrl = "https://" + asciiHost + ".xxooo.cf/";
                Config.wall()
                        .url(wallpaperUrl)
                        .name("默认壁纸")
                        .update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
